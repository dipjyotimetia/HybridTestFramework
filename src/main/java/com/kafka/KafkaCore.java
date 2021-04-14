package com.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.testng.Assert;

import java.util.Properties;

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
                System.out.println((metadata.timestamp()));
                Assert.assertEquals(topic, metadata.topic());
                Assert.assertTrue(metadata.hasOffset());
                Assert.assertTrue(metadata.hasTimestamp());
            } else {
                e.printStackTrace();
            }
        });
        producer.flush();
        producer.close();
    }
}
