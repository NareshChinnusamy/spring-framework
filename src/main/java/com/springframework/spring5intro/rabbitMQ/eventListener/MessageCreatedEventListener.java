package com.springframework.spring5intro.rabbitMQ.eventListener;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.springframework.spring5intro.rabbitMQ.service.MessageFromMarsServiceImpl;

@Component
public class MessageCreatedEventListener {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    MessageFromMarsServiceImpl messageFromMarsServiceImpl;

    @Value("${rabbitmq.application.org.exchange}")
    String applicationOrgExchange;

    @Bean
    public void messageCreatedListener() {
        rabbitTemplate.convertAndSend(applicationOrgExchange, "key.app_org.msg.created",
                messageFromMarsServiceImpl.messgae());
    }

}
