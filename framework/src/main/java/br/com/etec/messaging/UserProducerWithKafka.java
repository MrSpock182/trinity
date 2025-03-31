package br.com.etec.messaging;

import br.com.etec.messaging.dto.UserProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Component
public class UserProducerWithKafka {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserProducerWithKafka.class);

    private final String topic;
    private final KafkaTemplate<String, UserProducer> kafkaTemplate;

    public UserProducerWithKafka(
            KafkaTemplate<String, UserProducer> kafkaTemplate,
            @Value("${spring.kafka.topic.msk-topic}") String topic) {
        this.topic = topic;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void produce(final String name) {
        try {
            kafkaTemplate.send(topic, UUID.randomUUID().toString(), new UserProducer(name))
                    .get(5, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException ex) {
            LOGGER.error("Producing error {}", name, ex);
        }
    }
}