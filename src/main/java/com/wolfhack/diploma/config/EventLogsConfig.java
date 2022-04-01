package com.wolfhack.diploma.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class EventLogsConfig {

    @Bean
    public NewTopic registrationTopic() {
        return TopicBuilder.name("registration")
                .build();
    }

}
