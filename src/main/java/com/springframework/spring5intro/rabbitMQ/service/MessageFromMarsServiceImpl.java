package com.springframework.spring5intro.rabbitMQ.service;

import org.springframework.stereotype.Service;

import com.springframework.spring5intro.rabbitMQ.entity.MessageFromMars;

@Service
public class MessageFromMarsServiceImpl {

    public MessageFromMars messgae() {
        MessageFromMars messageFromMars = new MessageFromMars();
        messageFromMars.setMessageId(3);
        messageFromMars.setMessageName("Incoming message from field team");
        messageFromMars
                .setMessageContent("Mayday mayday we have been attacked by the martians. Requesting Immediate Backup");
        return messageFromMars;
    }
}
