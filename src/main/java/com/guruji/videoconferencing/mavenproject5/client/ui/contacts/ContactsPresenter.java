package com.guruji.videoconferencing.mavenproject5.client.ui.contacts;

import java.util.List;

import javax.inject.Inject;

import com.guruji.videoconferencing.mavenproject5.client.VideoChatServiceAsync;
import com.guruji.videoconferencing.mavenproject5.client.event.SocketEvent;
import com.guruji.videoconferencing.mavenproject5.client.event.SocketEvent.SocketHandlerAdapter;
import com.guruji.videoconferencing.mavenproject5.client.message.VContactListMessage;
import com.guruji.videoconferencing.mavenproject5.client.message.VUserOnlineStatusMessage;
import com.guruji.videoconferencing.mavenproject5.client.ui.chat.VideoChatPlace;
import com.guruji.videoconferencing.mavenproject5.shared.domain.Registration;

import com.google.gwt.place.shared.PlaceChangeEvent;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.web.bindery.event.shared.EventBus;
import com.guruji.videoconferencing.mavenproject5.shared.domain.Registration;

public class ContactsPresenter implements ContactsView.Presenter, PlaceChangeEvent.Handler {
    
    private ContactsView view;
    
    private VideoChatServiceAsync service;
    
    private SocketHandlerAdapter handler = new SocketHandlerAdapter() {
        @Override
        public void onContactListMessage(SocketEvent event) {
            final VContactListMessage message = event.getJson().cast();
            if (message.getContactMessageType().equals("ONLINE_STATUS")) {
                final VUserOnlineStatusMessage onlineMsg = message.cast();
                view.userOnlineStatusChanged(onlineMsg.getUserId(), onlineMsg.isOnline());
            }
        }
    };
    
    @Inject
    public ContactsPresenter(VideoChatServiceAsync service, EventBus eventBus) {
        this.service = service;
        eventBus.addHandler(SocketEvent.TYPE, handler);
        eventBus.addHandler(PlaceChangeEvent.TYPE, this);
    }

    @Override
    public void setView(ContactsView view) 
    {
        this.view = view;
    }
    
    @Override
    public void loadContacts() {
        service.getUsersOnline(new AsyncCallback<List<Registration>>()
        {
            @Override
            public void onSuccess(List<Registration> result) {
                view.setContacts(result);
            }
            
            @Override
            public void onFailure(Throwable caught) {}
        });
    }

    @Override
    public void onPlaceChange(PlaceChangeEvent event) {
        if (event.getNewPlace() instanceof VideoChatPlace) {
            loadContacts();
        }
    }
}
