package com.guruji.videoconferencing.mavenproject5.client.ui.contacts;

import java.util.List;

import com.guruji.videoconferencing.mavenproject5.shared.domain.Registration;

import com.google.gwt.user.client.ui.IsWidget;
import com.guruji.videoconferencing.mavenproject5.shared.domain.Registration;

public interface ContactsView extends IsWidget {
    
    void setContacts(List<Registration> result);
    
    void userOnlineStatusChanged(int userId, boolean online);
    
    interface Presenter 
    {
        
        void setView(ContactsView view);
        
        void loadContacts();
        
    }
}
