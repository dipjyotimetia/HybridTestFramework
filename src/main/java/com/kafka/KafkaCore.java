package com.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

@Slf4j
public class KafkaCore {
    public void CreateTopic(String topic, String value, Properties properties) {
        // Create the producer
        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);
        ProducerRecord<String, String> record = new ProducerRecord<>(topic, value);
        System.out.println("Creating producer");
        // Send Data
        producer.send(record, (metadata, e) -> {
            // Execute every time record is successfully send
            if (e == null) {
                log.info(String.valueOf(metadata.timestamp()));
                log.info(topic, metadata.topic());
                log.info(String.valueOf(metadata.hasOffset()));
                log.info(String.valueOf(metadata.hasTimestamp()));
            } else {
                e.printStackTrace();
            }
        });
        producer.flush();
        producer.close();
    }
}
