package com.dc.kafka.reminder;

import com.dc.kafka.proto.ReminderProto;
import io.confluent.kafka.serializers.protobuf.KafkaProtobufSerializer;
import io.confluent.kafka.serializers.protobuf.KafkaProtobufSerializerConfig;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class RemindersProducerProtobuf {

    private static final Logger LOG = LoggerFactory.getLogger(RemindersProducerProtobuf.class);
    private static final String PROTOBUF_REMINDERS_TOPIC = "reminders-proto";

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaProtobufSerializer.class.getName());
        props.put(KafkaProtobufSerializerConfig.SCHEMA_REGISTRY_URL_CONFIG, "http://localhost:8081");

        KafkaProducer<String, ReminderProto.Reminder> producer = new KafkaProducer<>(props);

        Thread shutdownHook = new Thread(producer::close);
        Runtime.getRuntime().addShutdownHook(shutdownHook);

        ReminderProto.Reminder reminderProto = ReminderProto.Reminder.newBuilder()
                .setId(2)
                .setEvent("Buy Milk")
                .setDate("11/11/2020")
                .setTime("18:00")
                .setRecurring(false)
                .build();

        LOG.info("Sending a reminder to " + reminderProto.getEvent() + " on " + reminderProto.getDate() + " at " + reminderProto.getTime());

        ProducerRecord<String, ReminderProto.Reminder> producerRecord =
                new ProducerRecord<>(PROTOBUF_REMINDERS_TOPIC, "", reminderProto);
        producer.send(producerRecord);
    }
}
