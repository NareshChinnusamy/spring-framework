package com.springframework.spring5intro.rabbitMQ.queueListener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.springframework.spring5intro.rabbitMQ.entity.MessageFromMars;

@Component
public class ApplicationOrgMessageListener {

    @RabbitListener(queues = "${rabbitmq.application.msg.queue}")
    public void msgCreated(MessageFromMars message) {
        System.out.println(message.getMessageId());
        System.out.println(message.getMessageName());
        System.out.println(message.getMessageContent());
    }
}
