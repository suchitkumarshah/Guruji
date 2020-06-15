package com.guruji.videoconferencing.mavenproject5.server.persistence;

import javax.inject.Singleton;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Singleton
public class VideoChatEMF {
    
    EntityManagerFactory factory =  Persistence.createEntityManagerFactory("video_chat");
    
    public EntityManagerFactory getFactory()
    {
                     System.out.println("Database URl:"+factory.getProperties().toString());
        return factory;
    }
    
}
