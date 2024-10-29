package com.dc.kafka.payment;

import com.dc.kafka.avro.btlnse.Audit;
import com.dc.kafka.avro.btlnse.Payment;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import io.confluent.kafka.serializers.KafkaAvroSerializerConfig;
import io.confluent.kafka.serializers.json.KafkaJsonSchemaSerializerConfig;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by dhanith on 1/29/2024
 */
public class PaymentAvroProducer {
    private static final Logger LOG = LoggerFactory.getLogger(PaymentAvroProducer.class);
    private static final String AVRO_PAYMENT_TOPIC = "payment-avro";

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class.getName());
        props.put(KafkaAvroSerializerConfig.SCHEMA_REGISTRY_URL_CONFIG, "http://localhost:8081");
//        props.put(KafkaAvroSerializerConfig.VALUE_SUBJECT_NAME_STRATEGY, RecordNameStrategy.class.getName());
        props.put(KafkaJsonSchemaSerializerConfig.AUTO_REGISTER_SCHEMAS, "false");
        props.put(KafkaJsonSchemaSerializerConfig.USE_LATEST_VERSION, "true");

        KafkaProducer<String, Payment> producer = new KafkaProducer<>(props);

        Thread shutdownHook = new Thread(producer::close);
        Runtime.getRuntime().addShutdownHook(shutdownHook);

        Audit audit = Audit.newBuilder()
                .setCompanyId("SG00011")
                .setEventCreationTime("2024-01-26T16:40:34")
                .setInputterList(Arrays.asList("242343_SYS.E232_I_INAU"))
                .setEventId("24234343-d34355-3432-2323-23232323")
                .setDateTimeList(Arrays.asList("2019-04-08T16:40:00+08:00", "2019-04-08T16:40:00+08:00"))
                .build();

        Payment payment = Payment.newBuilder()
                .setBU("0058")
                .setId("AvrP")
                .setCurrNo(16733)
                .setCompanyCode("SG00011")
                .setCountryCode("KR")
                .setAudit(audit)
                .setTestRequiredField("testRequiredValue")
                .build();

        LOG.info("Sending a payment ID=" + payment.getId() + ",  " + payment);

        ProducerRecord<String, Payment> producerRecord =
                new ProducerRecord<>(AVRO_PAYMENT_TOPIC, "AvrP", payment);
        Future<RecordMetadata> send = producer.send(producerRecord);
        try {
            RecordMetadata recordMetadata = send.get(60, TimeUnit.SECONDS);
            LOG.info(recordMetadata.toString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}