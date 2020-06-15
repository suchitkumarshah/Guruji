package com.guruji.videoconferencing.mavenproject5.server;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import com.google.inject.Provider;
import com.guruji.videoconferencing.mavenproject5.shared.domain.Registration;


@Singleton
public class VideoChatSocketManagerImpl implements VideoChatSocketManager {

    private final ListMultimap<Registration, VideoChatSocket> sockets = ArrayListMultimap.create();

    @Inject
    private Provider<SessionCtx> sessionCtx;

    @Override
    public List<VideoChatSocket> getSocketForUser(Registration user) {
        return sockets.get(user);
    }

    @Override
    public void registerSocket(VideoChatSocket socket) {
        System.out.println("Registered socket for user " + sessionCtx.get().getRegistration().getEmail());
        sockets.put(sessionCtx.get().getRegistration(),socket);
    }

    @Override
    public void deregisterSocket(VideoChatSocket socket) {
        sockets.remove(sessionCtx.get().getRegistration(), socket);
    }

}
