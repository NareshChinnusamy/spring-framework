package com.springframework.spring5intro.rabbitMQ.config;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationOrgRabbitMqConfig {

    @Value("${rabbitmq.application.org.exchange}")
    String applicationOrgExchange;

    @Bean(name = "applicationOrgTopicExchange")
    public TopicExchange applicationOrgTopicExchange() {
        return new TopicExchange(applicationOrgExchange);
    }
}
