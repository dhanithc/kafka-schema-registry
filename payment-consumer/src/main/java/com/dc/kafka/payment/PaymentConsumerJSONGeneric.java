package com.dc.kafka.payment;

import com.fasterxml.jackson.databind.JsonNode;
import io.confluent.kafka.serializers.KafkaJsonDeserializerConfig;
import io.confluent.kafka.serializers.json.KafkaJsonSchemaDeserializer;
import io.confluent.kafka.serializers.json.KafkaJsonSchemaDeserializerConfig;
import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.Properties;

/**
 * Created by dhanith on 1/29/2024
 */
public class PaymentConsumerJSONGeneric {

    private static final Logger LOG = LoggerFactory.getLogger(PaymentConsumerJSONGeneric.class);
    private static final String JSON_PAYMENT_TOPIC = "payment-json";

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "json.payment.consumer");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KafkaJsonSchemaDeserializer.class.getName());
//        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        props.put(KafkaJsonSchemaDeserializerConfig.SCHEMA_REGISTRY_URL_CONFIG, "http://localhost:8081");
        props.put(KafkaJsonDeserializerConfig.JSON_VALUE_TYPE, JsonNode.class.getName());

        final Consumer<String, JsonNode> consumer = new KafkaConsumer<>(props);

        Thread shutdownHook = new Thread(consumer::close);
        Runtime.getRuntime().addShutdownHook(shutdownHook);

        consumer.subscribe(Collections.singletonList(JSON_PAYMENT_TOPIC));

        while(true) {
            ConsumerRecords<String, JsonNode> records = consumer.poll(100);
            for(ConsumerRecord<String, JsonNode> record : records) {
                JsonNode payment = record.value();
                LOG.info("Received a payment, " + payment);
            }
        }
    }
}
