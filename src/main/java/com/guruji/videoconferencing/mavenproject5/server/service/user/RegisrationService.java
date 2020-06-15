package com.guruji.videoconferencing.mavenproject5.server.service.user;

import com.guruji.videoconferencing.mavenproject5.shared.domain.Registration;

public interface RegisrationService
{

    Registration signIn(String email);

    Registration registerUser(Registration newUser);

    Iterable<Registration> getRegistrationList();

    Iterable<Registration> getUsersOnline();

    void setCurrentUserOnline(boolean isOnline);

    void addToContacts(Registration user);
    
    Integer getCurrentUserId();

}
