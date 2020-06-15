package com.guruji.videoconferencing.mavenproject5.server.persistence;

import com.guruji.videoconferencing.mavenproject5.shared.domain.Registration;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Singleton;




@Singleton
@SuppressWarnings("serial")
public class OnlineUsersPool implements Serializable 
{

    private static final List<Registration> usersOnline = Collections.synchronizedList(new ArrayList<Registration>());
    
    public void setUserOnline(final Registration user, boolean isUserOnline) 
    {
        if (isUserOnline && !isUserOnline(user)) 
        {
            usersOnline.add(user);
        } else {
            usersOnline.remove(user);
        }
        
    }

    public Iterable <Registration> getUsersOnline() 
    {
        return usersOnline;
    }
    
    public boolean isUserOnline(Registration user) {
        return usersOnline.contains(user);
    }
    
}
