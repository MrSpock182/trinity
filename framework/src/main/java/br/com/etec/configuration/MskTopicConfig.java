package br.com.etec.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class MskTopicConfig {
    @Bean
    public NewTopic mksTopic(
            @Value("${spring.kafka.replicas}") final Integer replicas,
            @Value("${spring.kafka.partitions}") final Integer partitions,
            @Value("${spring.kafka.topic.msk-topic}") final String topic) {
        return TopicBuilder
                .name(topic)
                .partitions(partitions)
                .replicas(replicas)
                .compact()
                .configs(topicConfigs())
                .build();
    }

    private Map<String, String> topicConfigs() {
        String time = "86500000";
        Map<String, String> map = new HashMap<>();
        map.put("delete.retention.ms", time);
        return map;
    }
}