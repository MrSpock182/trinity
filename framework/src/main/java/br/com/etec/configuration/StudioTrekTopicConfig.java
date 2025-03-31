package br.com.etec.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class StudioTrekTopicConfig {
    @Bean
    public NewTopic mksTopic() {
        return TopicBuilder.name("studio-trek-topic")
                .partitions(10)
                .replicas(2)
                .build();
    }
}