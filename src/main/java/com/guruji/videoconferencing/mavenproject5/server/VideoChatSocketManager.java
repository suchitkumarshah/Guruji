package com.guruji.videoconferencing.mavenproject5.server;

import com.guruji.videoconferencing.mavenproject5.shared.domain.Registration;
import java.util.List;

public interface VideoChatSocketManager 
{
    
    List<VideoChatSocket> getSocketForUser(Registration user);
    
    void registerSocket(final VideoChatSocket socket);
    
    void deregisterSocket(final VideoChatSocket socket);
}
