package com.guruji.videoconferencing.mavenproject5.client.message;

import com.google.gwt.core.client.JavaScriptObject;

public class VMessage extends JavaScriptObject {

    protected VMessage() {}
    
    public final native String getMessageType() /*-{
        return this.messageType;    
    }-*/;
    
    public static native final VMessage parse(String data) /*-{
		return eval('(' + data + ')');
    }-*/;
}
