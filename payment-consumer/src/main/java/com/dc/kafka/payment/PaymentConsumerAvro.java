package com.dc.kafka.payment;

import com.dc.kafka.avro.btlnse.Payment;
import io.confluent.kafka.serializers.KafkaAvroDeserializer;
import io.confluent.kafka.serializers.KafkaAvroDeserializerConfig;
import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

/**
 * Created by dhanith on 2/7/2024
 */
public class PaymentConsumerAvro {
    private static final Logger LOG = LoggerFactory.getLogger(PaymentConsumerAvro.class);

    private static final String AVRO_PAYMENT_TOPIC = "payment-avro";

    public static void main(String[] args) {

        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "avro.payment.consumer");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KafkaAvroDeserializer.class.getName());
        props.put(KafkaAvroDeserializerConfig.SCHEMA_REGISTRY_URL_CONFIG, "http://localhost:8081");
        props.put(KafkaAvroDeserializerConfig.SPECIFIC_AVRO_READER_CONFIG, true);

        final Consumer<String, Payment> consumer = new KafkaConsumer<>(props);

        Thread shutdownHook = new Thread(consumer::close);
        Runtime.getRuntime().addShutdownHook(shutdownHook);

        consumer.subscribe(Collections.singletonList(AVRO_PAYMENT_TOPIC));

        while(true) {
            ConsumerRecords<String, Payment> records = consumer.poll(Duration.ofMillis(100));

            for(ConsumerRecord<String, Payment> record : records) {
                Payment payment = record.value();
                LOG.info(payment.toString());
                LOG.info("Received a payment, ID=" + payment.getId() + ", BU=" + payment.getBU()+ ", CC=" + payment.getCompanyCode());
            }
        }
    }
}
