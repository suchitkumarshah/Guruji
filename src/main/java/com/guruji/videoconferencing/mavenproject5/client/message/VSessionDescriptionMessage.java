package com.guruji.videoconferencing.mavenproject5.client.message;


public abstract class VSessionDescriptionMessage extends VMessage {

    protected VSessionDescriptionMessage() {}
    
    public final native String getSDPType() /*-{
        return this.type;
    }-*/;
    
}
