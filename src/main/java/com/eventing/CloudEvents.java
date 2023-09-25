/*
MIT License

Copyright (c) 2023 Dipjyoti Metia

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/

package com.eventing;

import io.cloudevents.CloudEvent;
import io.cloudevents.core.builder.CloudEventBuilder;
import io.cloudevents.kafka.CloudEventDeserializer;
import io.cloudevents.kafka.CloudEventSerializer;
import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.net.URI;
import java.time.Duration;
import java.time.OffsetDateTime;
import java.util.Properties;
import java.util.UUID;

/**
 * This class provides methods for producing and consuming CloudEvents using the Apache Kafka framework.
 * It is used for creating producer and consumer configurations, producing CloudEvents to Kafka topics,
 * and consuming CloudEvents from Kafka topics.
 *
 * @author Dipjyoti Metia
 * @since 2023
 */
public class CloudEvents {

    /**
     * Creates a producer configuration for producing CloudEvents to a Kafka topic.
     *
     * @param config a Config object containing Kafka configuration settings
     * @return a Properties object containing the producer configuration settings
     */
    public Properties cloudEventProducerConfig(Config config) {
        Properties props = new Properties();
        props.setProperty(ProducerConfig.ACKS_CONFIG, "1");
        props.setProperty(ProducerConfig.RETRIES_CONFIG, "10");
        props.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, config.getBootstrapURL());
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, CloudEventSerializer.class.getName());
        return props;
    }

    /**
     * Creates a consumer configuration for consuming CloudEvents from a Kafka topic.
     *
     * @param config a Config object containing Kafka configuration settings
     * @return a Properties object containing the consumer configuration settings
     */
    public Properties cloudEventConsumerConfig(Config config) {
        Properties props = new Properties();
        props.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, config.getBootstrapURL());
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, CloudEventDeserializer.class.getName());
        props.setProperty(ConsumerConfig.GROUP_ID_CONFIG, config.getGroupID());
        props.setProperty(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false");
        props.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest"); // "earliest/latest/none"
        return props;
    }

    /**
     * Produces a CloudEvent to the specified Kafka topic using the provided producer configuration.
     *
     * @param config    a Config object containing Kafka configuration settings
     * @param props     a Properties object containing the producer configuration settings
     * @param eventData a byte array containing the CloudEvent data payload
     */
    public void cloudEventProducer(Config config, Properties props, byte[] eventData) {
        try (Producer<String, CloudEvent> producer = new KafkaProducer<>(props)) {

            // Build a CloudEvent
            CloudEvent event = CloudEventBuilder.v1()
                    .withId(UUID.randomUUID().toString())
                    .withSubject("order")
                    .withTime(OffsetDateTime.now())
                    .withType("example.kafka")
                    .withSource(URI.create("http://localhost"))
                    .withDataContentType("application/json")
                    .withData(eventData)
                    .build();

            // Produce the CloudEvent
            ProducerRecord<String, CloudEvent> record = new ProducerRecord<>(config.getTopic(), event);
            producer.send(record);
        }
    }

    /**
     * Consumes CloudEvents from the specified Kafka topic using the provided consumer configuration.
     *
     * @param props a Properties object containing the consumer configuration settings
     */
    public void cloudEventConsumer(Properties props) {
        try (KafkaConsumer<String, CloudEvent> consumer = new KafkaConsumer<>(props)) {

            consumer.subscribe(java.util.Collections.singletonList(props.getProperty(ConsumerConfig.ALLOW_AUTO_CREATE_TOPICS_CONFIG)));
            while (true) {
                ConsumerRecords<String, CloudEvent> records = consumer.poll(Duration.ofSeconds(10));
                records.forEach(rec -> {
                    System.out.println(rec.value().toString());
                });
            }
        }
    }
}
