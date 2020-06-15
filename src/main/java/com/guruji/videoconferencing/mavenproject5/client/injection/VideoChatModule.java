package com.guruji.videoconferencing.mavenproject5.client.injection;

import com.guruji.videoconferencing.mavenproject5.client.SessionInfo;
import com.guruji.videoconferencing.mavenproject5.client.framework.activity.VideoChatActivityMapper;
import com.guruji.videoconferencing.mavenproject5.client.framework.place.VideoChatPlaceHistoryMapper;
import com.guruji.videoconferencing.mavenproject5.client.serverconnection.PeerConnectionManager;
import com.guruji.videoconferencing.mavenproject5.client.serverconnection.ServerConnection;
import com.guruji.videoconferencing.mavenproject5.client.ui.chat.VideoChatActivity;
import com.guruji.videoconferencing.mavenproject5.client.ui.chat.VideoChatPlace;
import com.guruji.videoconferencing.mavenproject5.client.ui.chat.VideoChatView;
import com.guruji.videoconferencing.mavenproject5.client.ui.chat.VideoChatViewImpl;
import com.guruji.videoconferencing.mavenproject5.client.ui.contacts.ContactsPresenter;
import com.guruji.videoconferencing.mavenproject5.client.ui.contacts.ContactsView;
import com.guruji.videoconferencing.mavenproject5.client.ui.contacts.ContactsViewImpl;
import com.guruji.videoconferencing.mavenproject5.client.ui.dialog.IncomingCallDialogView;
import com.guruji.videoconferencing.mavenproject5.client.ui.dialog.IncomingCallDialogViewImpl;
import com.guruji.videoconferencing.mavenproject5.client.ui.login.LoginActivity;
import com.guruji.videoconferencing.mavenproject5.client.ui.login.LoginView;
import com.guruji.videoconferencing.mavenproject5.client.ui.login.LoginViewImpl;
import com.guruji.videoconferencing.mavenproject5.client.widget.VideoWidget;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.user.client.ui.HasOneWidget;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;

public class VideoChatModule extends AbstractGinModule {

    @Override
    protected void configure() {
        // Widgets
        bind(VideoWidget.class);
    
        // Activities
        bind(VideoChatActivity.class);
        bind(LoginActivity.class);
        
        // Views (singletons)
        bind(VideoChatView.class).to(VideoChatViewImpl.class).in(Singleton.class);
        bind(LoginView.class).to(LoginViewImpl.class).in(Singleton.class);
        bind(ContactsView.class).to(ContactsViewImpl.class).in(Singleton.class);
        bind(ContactsPresenter.class);
        
        bind(SimplePanel.class).in(Singleton.class);
        bind(EventBus.class).to(SimpleEventBus.class).in(Singleton.class);
        bind(PlaceController.class).toProvider(PlaceControllerProvider.class).asEagerSingleton();
        
        //Dialogs
        bind(IncomingCallDialogView.class).to(IncomingCallDialogViewImpl.class);
        
        bind(ActivityMapper.class).to(VideoChatActivityMapper.class).in(Singleton.class);
        bind(PlaceHistoryMapper.class).to(VideoChatPlaceHistoryMapper.class).in(Singleton.class);
        
        bind(SessionInfo.class).in(Singleton.class);
        bind(HasOneWidget.class).to(SimplePanel.class);
        bind(ServerConnection.class).asEagerSingleton();
        bind(PeerConnectionManager.class).asEagerSingleton();
    }

    @Provides
    @Singleton
    public ActivityManager getActivityManager(ActivityMapper mapper, EventBus eventBus, HasOneWidget display) {
        ActivityManager activityManager = new ActivityManager(mapper, eventBus);
        activityManager.setDisplay(display);
        return activityManager;
    }
    
    @Provides
    @Singleton
    public PlaceHistoryHandler getHistoryHandler(PlaceController placeController, PlaceHistoryMapper historyMapper, EventBus eventBus,
            ActivityManager activityManager) {
        PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
        historyHandler.register(placeController, eventBus, new VideoChatPlace());
        return historyHandler;
    }
}
