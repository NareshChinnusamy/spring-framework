package com.springframework.spring5intro.rabbitMQ.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationOrgMsgRabbitMqConfig {

    @Autowired
    TopicExchange applicationOrgTopicExchange;

    @Value("${rabbitmq.application.msg.queue}")
    String applicationOrgMsgQueue;

    @Bean
    public Queue applicationOrgMsgQueue() {
        return new Queue(applicationOrgMsgQueue, true);
    }

    @Bean
    Binding applicationOrgMsgCreatedBinding(Queue applicationOrgMsgQueue, TopicExchange applicationOrgTopicExchange) {
        return BindingBuilder.bind(applicationOrgMsgQueue).to(applicationOrgTopicExchange)
                .with("key.app_org.msg.created");
    }

}
