package com.dc.kafka.payment;

import io.confluent.kafka.serializers.KafkaAvroDeserializer;
import io.confluent.kafka.serializers.KafkaAvroDeserializerConfig;
import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

/**
 * Created by dhanith on 2/7/2024
 */
public class PaymentConsumerAvroGeneric {
    private static final Logger LOG = LoggerFactory.getLogger(PaymentConsumerAvroGeneric.class);

    private static final String AVRO_PAYMENT_TOPIC = "payment-avro";

    public static void main(String[] args) {

        final Consumer<String, GenericRecord> consumer = getStringGenericRecordConsumer();

        Thread shutdownHook = new Thread(consumer::close);
        Runtime.getRuntime().addShutdownHook(shutdownHook);

        consumer.subscribe(Collections.singletonList(AVRO_PAYMENT_TOPIC));

        while(true) {
            ConsumerRecords<String, GenericRecord> records = consumer.poll(Duration.ofMillis(100));

            for(ConsumerRecord<String, GenericRecord> record : records) {
                GenericRecord payment = record.value();
                LOG.info("Received a payment, " + payment);
            }
        }
    }

    @NotNull
    private static Consumer<String, GenericRecord> getStringGenericRecordConsumer() {
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "avro.payment.consumer");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KafkaAvroDeserializer.class.getName());
        props.put(KafkaAvroDeserializerConfig.SCHEMA_REGISTRY_URL_CONFIG, "http://localhost:8081");
        props.put(KafkaAvroDeserializerConfig.SPECIFIC_AVRO_READER_CONFIG, true);

        final Consumer<String, GenericRecord> consumer = new KafkaConsumer<>(props);
        return consumer;
    }
}
