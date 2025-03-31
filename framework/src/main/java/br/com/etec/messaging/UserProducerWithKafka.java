package br.com.etec.messaging;

import br.com.etec.messaging.dto.UserProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserProducerWithKafka {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserProducerWithKafka.class);

    private final KafkaTemplate<String, UserProducer> kafkaTemplate;

    public UserProducerWithKafka(KafkaTemplate<String, UserProducer> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void produce(final String name) {
        kafkaTemplate.send("mks-topic", UUID.randomUUID().toString(), new UserProducer(name));

//        try {
//            kafkaTemplate.send("mks-topic", UUID.randomUUID().toString(), new UserProducer(name))
//                    .get(5, TimeUnit.SECONDS);
//        } catch (InterruptedException | ExecutionException | TimeoutException ex) {
//            LOGGER.error("Producing error {}", name, ex);
//        }
    }
}