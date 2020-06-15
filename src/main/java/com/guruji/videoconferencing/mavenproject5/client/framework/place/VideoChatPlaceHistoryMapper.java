package com.guruji.videoconferencing.mavenproject5.client.framework.place;

import com.guruji.videoconferencing.mavenproject5.client.ui.chat.VideoChatTokenizer;
import com.guruji.videoconferencing.mavenproject5.client.ui.login.LoginPlaceTokenizer;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

@WithTokenizers(value = {LoginPlaceTokenizer.class, VideoChatTokenizer.class})
public interface VideoChatPlaceHistoryMapper extends PlaceHistoryMapper {
   
}
