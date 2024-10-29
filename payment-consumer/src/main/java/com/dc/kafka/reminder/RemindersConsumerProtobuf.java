package com.dc.kafka.reminder;

import com.dc.kafka.proto.ReminderProto;
import io.confluent.kafka.serializers.protobuf.KafkaProtobufDeserializer;
import io.confluent.kafka.serializers.protobuf.KafkaProtobufDeserializerConfig;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;


public class RemindersConsumerProtobuf {

    private static final Logger LOG = LoggerFactory.getLogger(RemindersConsumerProtobuf.class);
    private static final String PROTOBUF_REMINDERS_TOPIC = "reminders-proto";

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "proto.reminders.consumer");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KafkaProtobufDeserializer.class.getName());
        props.put(KafkaProtobufDeserializerConfig.SCHEMA_REGISTRY_URL_CONFIG, "http://localhost:8081");
        props.put(KafkaProtobufDeserializerConfig.SPECIFIC_PROTOBUF_VALUE_TYPE, ReminderProto.Reminder.class);

        KafkaConsumer<String, ReminderProto.Reminder> consumer = new KafkaConsumer<>(props);

        Thread shutdownHook = new Thread(consumer::close);
        Runtime.getRuntime().addShutdownHook(shutdownHook);

        consumer.subscribe(Collections.singletonList(PROTOBUF_REMINDERS_TOPIC));

        while(true) {
            ConsumerRecords<String, ReminderProto.Reminder> records = consumer.poll(Duration.ofMillis(100));

            for(ConsumerRecord<String, ReminderProto.Reminder> record : records) {
                ReminderProto.Reminder reminderProto = record.value();
                LOG.info("Remind me on " + reminderProto.getDate() + " at " + reminderProto.getTime() + " to " + reminderProto.getEvent());
            }
        }
    }
}
