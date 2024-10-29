package com.dc.kafka.reminder;

import com.dc.kafka.json.ReminderJSON;
import io.confluent.kafka.serializers.json.KafkaJsonSchemaSerializer;
import io.confluent.kafka.serializers.json.KafkaJsonSchemaSerializerConfig;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class RemindersProducerJSON {

    private static final Logger LOG = LoggerFactory.getLogger(RemindersProducerJSON.class);
    private static final String JSON_REMINDERS_TOPIC = "reminders-json";

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaJsonSchemaSerializer.class.getName());
        props.put(KafkaJsonSchemaSerializerConfig.SCHEMA_REGISTRY_URL_CONFIG, "http://localhost:8081");

        KafkaProducer<String, ReminderJSON> producer = new KafkaProducer<>(props);

        Thread shutdownHook = new Thread(producer::close);
        Runtime.getRuntime().addShutdownHook(shutdownHook);

        ReminderJSON coffeeReminderJSON
                = new ReminderJSON(2, "Drink Coffee", "10/10/2020", "08:00",false,"test" );

        LOG.info("Sending a reminder to " + coffeeReminderJSON.getEvent() + " on " + coffeeReminderJSON.getDate() + " at " + coffeeReminderJSON.getTime());

        ProducerRecord<String, ReminderJSON> producerRecord =
                new ProducerRecord<>(JSON_REMINDERS_TOPIC, "2", coffeeReminderJSON);
        Future<RecordMetadata> send = producer.send(producerRecord);
        try {
            RecordMetadata recordMetadata = send.get(60, TimeUnit.SECONDS);
            System.out.println(recordMetadata);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (TimeoutException e) {
            throw new RuntimeException(e);
        }
    }
}
