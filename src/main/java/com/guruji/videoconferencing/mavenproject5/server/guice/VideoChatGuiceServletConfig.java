package com.guruji.videoconferencing.mavenproject5.server.guice;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.eclipse.jetty.websocket.WebSocket;
import com.guruji.videoconferencing.mavenproject5.server.VideoChatServiceImpl;
import com.guruji.videoconferencing.mavenproject5.server.VideoChatSocket;
import com.guruji.videoconferencing.mavenproject5.server.VideoChatSocketManager;
import com.guruji.videoconferencing.mavenproject5.server.VideoChatSocketManagerImpl;
import com.guruji.videoconferencing.mavenproject5.server.VideoWebSocketServlet;
import com.guruji.videoconferencing.mavenproject5.server.persistence.OnlineUsersPool;
import com.guruji.videoconferencing.mavenproject5.server.persistence.VideoChatEMF;


import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Provides;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.RequestScoped;
import com.google.inject.servlet.ServletModule;
import com.guruji.videoconferencing.mavenproject5.server.service.user.RegisrationService;
import com.guruji.videoconferencing.mavenproject5.server.service.user.RegisrationServiceImpl;
import java.sql.Connection;


public class VideoChatGuiceServletConfig extends GuiceServletContextListener {

    @Override
    protected Injector getInjector() {
        return Guice.createInjector(new ServletModule() {
            @Override
            protected void configureServlets() {
                bind(RegisrationService.class).to(RegisrationServiceImpl.class);
                bind(WebSocket.OnTextMessage.class).to(VideoChatSocket.class);
                bind(VideoChatSocketManager.class).to(VideoChatSocketManagerImpl.class);
                bind(VideoChatEMF.class);
                bind(OnlineUsersPool.class);

                serve("/VaadinVideoChat/service").with(VideoChatServiceImpl.class);
                serve("/socket/*").with(VideoWebSocketServlet.class);
            }

            @SuppressWarnings("unused")
            @Provides @RequestScoped @Inject
            public EntityManager getEntityManager(VideoChatEMF emf) 
            {
                Connection connection;
                
                
                             System.out.println("Database URl:"+emf.toString());
              
                             return emf.getFactory().createEntityManager();
            }
        });
    }
    
    
}
