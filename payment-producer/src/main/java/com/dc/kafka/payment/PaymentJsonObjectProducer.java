package com.dc.kafka.payment;

import com.dc.kafka.json.btlnse.Audit;
import com.dc.kafka.json.btlnse.Payment;
import io.confluent.kafka.schemaregistry.json.SpecificationVersion;
import io.confluent.kafka.serializers.json.KafkaJsonSchemaSerializer;
import io.confluent.kafka.serializers.json.KafkaJsonSchemaSerializerConfig;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Properties;

public class PaymentJsonObjectProducer {

    private static final Logger LOG = LoggerFactory.getLogger(PaymentJsonObjectProducer.class);
    private static final String JSON_PAYMENT_TOPIC = "payment-json";

    public static void main(String[] args) {

        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaJsonSchemaSerializer.class.getName());
        props.put(KafkaJsonSchemaSerializerConfig.FAIL_INVALID_SCHEMA, "true");
//        props.put("value.converter.ignore.default.for.nullables", "true");

        props.put(KafkaJsonSchemaSerializerConfig.SCHEMA_SPEC_VERSION, SpecificationVersion.DRAFT_2019_09.toString());
        //https://docs.confluent.io/cloud/current/sr/fundamentals/serdes-develop/serdes-json.html
        props.put(KafkaJsonSchemaSerializerConfig.AUTO_REGISTER_SCHEMAS, "false");
        props.put(KafkaJsonSchemaSerializerConfig.USE_LATEST_VERSION, "true");

        props.put(KafkaJsonSchemaSerializerConfig.SCHEMA_REGISTRY_URL_CONFIG, "http://localhost:8081");

        Audit audit = Audit.Builder.anAudit()
                .withCompanyId("SG00011")
                .withEventCreationTime("2024-01-26T16:40:34")
                .withInputter(Arrays.asList("242343_SYS.E232_I_INAU"))
                .withEventId("24234343-d34355-3432-2323-23232323")
                .withDateTime(Arrays.asList("2019-04-08T16:40:00+08:00", "2019-04-08T16:40:00+08:00"))
                .build();

        Payment payment = Payment.Builder.aPayment()
                .withBu("0058")
                .withId("ira")
                .withCurrNo(16732)
                .withCompanyCode("SG00011")
                .withCountryCode("KR")
                .withAudit(audit)
                .withTestRequiredField("RF")
                .build();

        LOG.info("Sending a payment ID=" + payment.getId() + "\n" + payment);

        try (Producer<String, Payment> producer = new KafkaProducer<>(props)) {
            ProducerRecord<String, Payment> record = new ProducerRecord<>(JSON_PAYMENT_TOPIC, payment.getId(), payment);
            producer.send(record, (metadata, exception) -> {
                if (exception == null) {
                    LOG.info("Message sent successfully. Topic: " + metadata.topic() +
                            ", Partition: " + metadata.partition() +
                            ", Offset: " + metadata.offset());
                } else {
                    LOG.error("Error sending message: " + exception.getMessage());
                }
            });
        }
    }
}
