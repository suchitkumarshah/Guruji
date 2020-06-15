package com.guruji.videoconferencing.mavenproject5.server.event;

import java.io.Serializable;

public class Message implements Serializable {

    private String messageType;
    
    public String getMessageType() {
        return messageType;
    }
    
    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }
}
