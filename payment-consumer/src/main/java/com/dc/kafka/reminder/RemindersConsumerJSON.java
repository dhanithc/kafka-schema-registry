package com.dc.kafka.reminder;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

import com.dc.kafka.json.ReminderJSON;
import io.confluent.kafka.serializers.KafkaJsonDeserializerConfig;
import io.confluent.kafka.serializers.json.KafkaJsonSchemaDeserializer;
import io.confluent.kafka.serializers.json.KafkaJsonSchemaDeserializerConfig;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class RemindersConsumerJSON {

    private static final Logger LOG = LoggerFactory.getLogger(RemindersConsumerJSON.class);
    private static final String JSON_REMINDERS_TOPIC = "reminders-json";

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "json.reminders.consumer");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KafkaJsonSchemaDeserializer.class.getName());
        props.put(KafkaJsonSchemaDeserializerConfig.SCHEMA_REGISTRY_URL_CONFIG, "http://localhost:8081");
        props.put(KafkaJsonDeserializerConfig.JSON_VALUE_TYPE, ReminderJSON.class.getName());

        KafkaConsumer<String, ReminderJSON> consumer = new KafkaConsumer<>(props);

        Thread shutdownHook = new Thread(consumer::close);
        Runtime.getRuntime().addShutdownHook(shutdownHook);

        consumer.subscribe(Collections.singletonList(JSON_REMINDERS_TOPIC));

        while(true) {
            ConsumerRecords<String, ReminderJSON> records = consumer.poll(Duration.ofMillis(100));

            for(ConsumerRecord<String, ReminderJSON> record : records) {
                ReminderJSON reminderJSON = record.value();
                LOG.info("Remind me on " + reminderJSON.getDate() + " at " + reminderJSON.getTime() + " to " + reminderJSON.getEvent());
            }
        }
    }
}
