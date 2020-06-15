package com.guruji.videoconferencing.mavenproject5.client.message;

public class VContactListMessage extends VMessage {

    protected VContactListMessage() {}
    
    public final native String getContactMessageType() /*-{
        return this.contactMessageType;
    }-*/; 
}
