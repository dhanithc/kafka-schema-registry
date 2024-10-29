package com.dc.kafka.payment;

import com.dc.kafka.json.btlnse.Payment;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.confluent.kafka.schemaregistry.json.SpecificationVersion;
import io.confluent.kafka.serializers.json.KafkaJsonSchemaSerializer;
import io.confluent.kafka.serializers.json.KafkaJsonSchemaSerializerConfig;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class PaymentJsonStringProducer {

    private static final Logger LOG = LoggerFactory.getLogger(PaymentJsonStringProducer.class);
    private static final String JSON_PAYMENT_TOPIC = "payment-json";

    public static void main(String[] args) throws JsonProcessingException {

        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaJsonSchemaSerializer.class.getName());
        props.put(KafkaJsonSchemaSerializerConfig.FAIL_INVALID_SCHEMA, "true");
        props.put(KafkaJsonSchemaSerializerConfig.SCHEMA_SPEC_VERSION, SpecificationVersion.DRAFT_2019_09.toString());
        props.put(KafkaJsonSchemaSerializerConfig.AUTO_REGISTER_SCHEMAS, "true");
        props.put(KafkaJsonSchemaSerializerConfig.USE_LATEST_VERSION, "false");
//        props.put(KafkaJsonSchemaSerializerConfig.USE_SCHEMA_ID, 1);
        props.put(KafkaJsonSchemaSerializerConfig.SCHEMA_REGISTRY_URL_CONFIG, "http://localhost:8081");

        ObjectMapper mapper = new ObjectMapper();
        Payment payment = mapper.readValue(
                """
                        {
                          "id": "JStP2",
                          "currNo": 16732,
                          "companyCode": "SG00011",
                          "bu": "0058",
                          "audit": {
                            "companyId": "SG00011",
                            "eventCreationTime": "2024-01-26T16:40: 34",
                            "inputter": [
                              "242343_SYS.E232_I_INAU"
                            ],
                            "eventId": "24234343-d34355-3432-2323-23232323",
                            "dateTime": [
                              "2019-04-08T16: 40: 00+08: 00",
                              "2019-04-08T16: 40: 00+08: 00"
                            ]
                          },
                          "countryCode": "KR",
                          "testOptionalField": null,
                          "testRequiredField": "RF",
                          "newRequiredField":"NR"
                        }
                        """, Payment.class);

        try (Producer<String, Payment> producer = new KafkaProducer<>(props)) {

            ProducerRecord<String, Payment> producerRecord = new ProducerRecord<>(JSON_PAYMENT_TOPIC, payment.getId(), payment);
            producer.send(producerRecord, (metadata, exception) -> {
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
