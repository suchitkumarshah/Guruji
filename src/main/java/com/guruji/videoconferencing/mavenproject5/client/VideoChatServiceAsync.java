package com.guruji.videoconferencing.mavenproject5.client;

import java.util.List;

import com.guruji.videoconferencing.mavenproject5.shared.domain.Registration;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of {@link VideoChatService}.
 */
public interface VideoChatServiceAsync {

	void signIn(Registration user, AsyncCallback<Integer> callback) throws IllegalArgumentException;

	void createChatRoom(int creatorId, AsyncCallback<Integer> callback) throws IllegalArgumentException;
	
	void getUsersOnline(AsyncCallback<List<Registration>> callback);
	
	void authenticate(AsyncCallback<Integer> callback) throws IllegalArgumentException;

    void register(Registration user, AsyncCallback<Integer> asyncCallback);
}
