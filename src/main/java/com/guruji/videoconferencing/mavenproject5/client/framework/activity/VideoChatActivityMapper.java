package com.guruji.videoconferencing.mavenproject5.client.framework.activity;

import javax.inject.Inject;

import com.guruji.videoconferencing.mavenproject5.client.ui.chat.VideoChatActivity;
import com.guruji.videoconferencing.mavenproject5.client.ui.chat.VideoChatPlace;
import com.guruji.videoconferencing.mavenproject5.client.ui.login.LoginActivity;
import com.guruji.videoconferencing.mavenproject5.client.ui.login.LoginPlace;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.inject.Provider;

public class VideoChatActivityMapper implements ActivityMapper {

    private final Provider<LoginActivity> loginActivityProvider;
    
    private final Provider<VideoChatActivity> videoChatActivityProvider;
    
    @Inject
    public VideoChatActivityMapper(Provider<LoginActivity> loginActivityProvider, Provider<VideoChatActivity> videoChatActivityProvider) {
        this.loginActivityProvider = loginActivityProvider;
        this.videoChatActivityProvider = videoChatActivityProvider;
    }
    
    @Override
    public Activity getActivity(Place place) {
        if (place instanceof LoginPlace) {
            return loginActivityProvider.get(); 
        }
        
        if (place instanceof VideoChatPlace) {
            return videoChatActivityProvider.get();
        }
        
        return null;
    }

}
