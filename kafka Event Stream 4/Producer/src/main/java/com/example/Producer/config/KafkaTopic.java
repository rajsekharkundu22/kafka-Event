package com.example.Producer.config;


import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopic {

    @Bean
    public NewTopic topic() {
        return TopicBuilder.name("wiki_topic")
                .partitions(1)
                .replicas(1)
                .build();
    }


}
