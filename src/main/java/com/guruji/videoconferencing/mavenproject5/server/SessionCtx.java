package com.guruji.videoconferencing.mavenproject5.server;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;



import com.google.inject.servlet.SessionScoped;
import com.guruji.videoconferencing.mavenproject5.shared.domain.Registration;

@SessionScoped
public class SessionCtx 
{

    @Inject
    private HttpSession session;

    public Registration getRegistration() {
        try {
            return (Registration)session.getAttribute("user");
        } catch (Exception e) 
        {
            return null;
        }
    }

    public void setUser(Registration user) {
        session.setAttribute("user", user);
    }
}
