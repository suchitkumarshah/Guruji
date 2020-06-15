package com.guruji.videoconferencing.mavenproject5.server.service.user;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.guruji.videoconferencing.mavenproject5.server.SessionCtx;
import com.guruji.videoconferencing.mavenproject5.server.persistence.OnlineUsersPool;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.servlet.SessionScoped;
import com.guruji.videoconferencing.mavenproject5.shared.domain.Registration;

/**
 *
 * @author dell
 */
@SessionScoped
public class RegisrationServiceImpl implements RegisrationService 
{

    @Inject 
    private OnlineUsersPool onlineUsersPool;
    
    @Inject
    private EntityManager em;

    @Inject
    private SessionCtx sessionCtx;

    @Override
    public Registration signIn(String email) 
    {
       
        
        try {
             System.out.println("Database URl:"+em.getProperties().toString());
            return em.createQuery("select u from registration_table u where u.email =:email", Registration.class).
            setParameter("email", email).
            getSingleResult();
        } catch (Exception e) {
            System.out.println("Failed to find user by email: " + email + " cause: " + e.getMessage());
            return null;
        }
    }

    @Override
    public Iterable<Registration> getRegistrationList() {
        final Registration user = sessionCtx.getRegistration(); 
        return user != null ? user.getRegistrationlist() : Lists.<Registration>newLinkedList();
    }

    @Override
    public Iterable<Registration> getUsersOnline() {
        return Iterables.filter(getRegistrationList(), new Predicate<Registration>() {
            @Override
            public boolean apply(Registration user) {
                return onlineUsersPool.isUserOnline(user);
            }
        });
    }

    @Override
    public void setCurrentUserOnline(boolean isOnline) {
        final Registration current = sessionCtx.getRegistration();
        if (current != null) {
            onlineUsersPool.setUserOnline(current, true);
        }
    }

    @Override
    public Registration registerUser(Registration newUser) {
        em.getTransaction().begin();
        for (final Registration user : onlineUsersPool.getUsersOnline())
        {
            newUser.addContact(user);
        }
        em.persist(newUser);
        em.getTransaction().commit();
        return newUser;
    }

    @Override
    public Integer getCurrentUserId() {
        return sessionCtx.getRegistration()== null ? -1 : sessionCtx.getRegistration().getReg_id();
    }

    @Override
    public void addToContacts(Registration user) {
        final Registration current = sessionCtx.getRegistration();
        if (current != null) 
        {
            try {
                em.getTransaction().begin();
                current.addContact(user);
                em.merge(current);
                em.getTransaction().commit();
            } 
            catch (IllegalArgumentException e) 
            {
                System.out.println("Failed to add contact, cause: " + e.getMessage());
            }
        }
    }

}
