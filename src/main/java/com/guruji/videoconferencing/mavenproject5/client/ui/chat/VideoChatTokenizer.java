package com.guruji.videoconferencing.mavenproject5.client.ui.chat;

import com.guruji.videoconferencing.mavenproject5.client.framework.place.BaseTokenizer;

import com.google.gwt.place.shared.Prefix;

@Prefix("chat")
public class VideoChatTokenizer extends BaseTokenizer<VideoChatPlace> {
    
    @Override
    public VideoChatPlace getPlace(String token) {
        return new VideoChatPlace();
    }

    @Override
    public String getToken(VideoChatPlace place) {
        return place.toString();
    }

}
