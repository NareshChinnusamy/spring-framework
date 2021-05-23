package com.springframework.spring5intro.rabbitMQ.entity;

import java.io.Serializable;

public class MessageFromMars implements Serializable {

    private long messageId;

    private String messageName;

    private String messageContent;

    public long getMessageId() {
        return messageId;
    }

    public void setMessageId(long messageId) {
        this.messageId = messageId;
    }

    public String getMessageName() {
        return messageName;
    }

    public void setMessageName(String messageName) {
        this.messageName = messageName;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }
}
