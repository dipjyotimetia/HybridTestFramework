package com.eventing;

import io.cloudevents.CloudEvent;
import io.cloudevents.core.builder.CloudEventBuilder;
import io.cloudevents.kafka.CloudEventDeserializer;
import io.cloudevents.kafka.CloudEventSerializer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.net.URI;
import java.time.Duration;
import java.time.OffsetDateTime;
import java.util.Properties;
import java.util.UUID;

public class CloudEvents {

    public Properties cloudEventProducerConfig(Config config) {
        Properties props = new Properties();
        props.setProperty(ProducerConfig.ACKS_CONFIG, "1");
        props.setProperty(ProducerConfig.RETRIES_CONFIG, "10");
        props.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, config.getBootstrapURL());
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, CloudEventSerializer.class);
        return props;
    }

    public Properties cloudEventConsumerConfig(Config config) {
        Properties props = new Properties();
        props.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, config.getBootstrapURL());
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, CloudEventDeserializer.class);
        props.setProperty(ConsumerConfig.GROUP_ID_CONFIG, config.getGroupID());
        props.setProperty(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false");
        props.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest"); // "earliest/latest/none"
        return props;
    }

    public void CloudEventProducer(Config config, Properties props, byte[] eventData) {
        try (KafkaProducer<String, CloudEvent> producer = new KafkaProducer<>(props)) {

            // Build an event
            CloudEvent event = CloudEventBuilder.v1()
                    .withId(UUID.randomUUID().toString())
                    .withSubject("order")
                    .withTime(OffsetDateTime.now())
                    .withType("example.kafka")
                    .withSource(URI.create("http://localhost"))
                    .withDataContentType("application/json")
                    .withData(eventData)
                    .build();

            // Produce the event
            producer.send(new ProducerRecord<>(config.getTopic(), event));
        }
    }

    public void CloudEventConsumer(Properties props) {
        try (KafkaConsumer<String, CloudEvent> consumer = new KafkaConsumer<>(props)) {

            ConsumerRecords<String, CloudEvent> records = consumer.poll(Duration.ofSeconds(10));

            records.forEach(rec -> {
                System.out.println(rec.value().toString());
            });
        }
    }
}
