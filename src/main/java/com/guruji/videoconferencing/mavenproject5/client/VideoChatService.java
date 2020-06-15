package com.guruji.videoconferencing.mavenproject5.client;

import java.util.List;

import com.guruji.videoconferencing.mavenproject5.shared.domain.Registration;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("service")
public interface VideoChatService extends RemoteService {
	
    int createChatRoom(int creatorId) throws IllegalArgumentException;
    
    int signIn(Registration user) throws IllegalArgumentException;
    
    int authenticate() throws IllegalArgumentException;
    
    int register(Registration user);
    
    List<Registration> getUsersOnline();
}
