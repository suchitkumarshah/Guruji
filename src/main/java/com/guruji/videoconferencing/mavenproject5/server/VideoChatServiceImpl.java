package com.guruji.videoconferencing.mavenproject5.server;

import java.util.List;

import javax.inject.Inject;

import com.guruji.videoconferencing.mavenproject5.client.VideoChatService;

import com.google.common.collect.Lists;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.guruji.videoconferencing.mavenproject5.server.service.user.RegisrationService;
import com.guruji.videoconferencing.mavenproject5.shared.domain.Registration;


/**
 * The server side implementation of the RPC service.
 */
@Singleton
public class VideoChatServiceImpl extends RemoteServiceServlet implements VideoChatService {

    private static final long serialVersionUID = 1L;
    
    @Inject
    private Provider<RegisrationService> userServiceProvider;

    @Inject
    private Provider<SessionCtx> sessionCtxProvider;
    
    @Override
    public int createChatRoom(int creatorId) {
        return VideoChatRoomManager.createRoom(creatorId).getId();
    }

    @Override
    public int signIn(Registration user) throws IllegalArgumentException {
        final Registration foundUser = userServiceProvider.get().signIn(user.getEmail());
        if (foundUser != null) {
            return setUserOnline(foundUser);
        } else {
            throw new IllegalArgumentException("User not found");
        }
        
    }

    private Integer setUserOnline(Registration foundUser) {
        sessionCtxProvider.get().setUser(foundUser);
        userServiceProvider.get().setCurrentUserOnline(true);
        return foundUser.getReg_id();
    }

    @Override
    public List<Registration> getUsersOnline() {
        final Registration user = sessionCtxProvider.get().getRegistration(); 
        return user == null ? Lists.<
                Registration>newArrayList() : user.getRegistrationlist(); 
    }

    @Override
    public int authenticate() throws IllegalArgumentException {
        Registration user = sessionCtxProvider.get().getRegistration();
        if (user != null) {
            return user.getReg_id();
        } else {
            throw new IllegalArgumentException("Not authenticated");   
        }
    }

    @Override
    public int register(Registration newUser) {
        final Registration user = userServiceProvider.get().registerUser(newUser);
        if (user != null)
        {
            return setUserOnline(user);
        }
        throw new IllegalArgumentException("Couldn't register new user");
    }

}
