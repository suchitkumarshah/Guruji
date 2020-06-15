package com.guruji.videoconferencing.mavenproject5.server;

import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.guruji.videoconferencing.mavenproject5.shared.domain.Registration;



@SuppressWarnings("serial")
public class VideoChatRoomManager implements Serializable {

    private static int USER_ID_COUNTER = 0;

    private static final List<ChatRoom> rooms = new LinkedList<ChatRoom>();

    private static final Map<String,Registration> users = new ConcurrentHashMap<String,Registration >();
    
    private static List<Registration> usersOnline = Collections.synchronizedList(new LinkedList<Registration>());
    
    private static class ChatRoomFactory {

        private static final ChatRoomFactory INSTANCE = new ChatRoomFactory();

        private static int ID_COUNTER = 0;

        public static ChatRoomFactory get() {
            return INSTANCE;
        }

        private ChatRoomFactory() {}

        final ChatRoom createChatRoom(int initiatorId) {
            return new ChatRoom(ID_COUNTER++, initiatorId);
        }
    }
    
    public static Registration getUser(String username) {
        Registration user = users.get(username);
        if (user == null) {
            int userId = USER_ID_COUNTER++;
            user = new Registration();
            user.setFirst_name(username);
            users.put(username, user);
        }
        return user;
    }
    
    public static ChatRoom createRoom(int creatorId) {
        final ChatRoom room = ChatRoomFactory.get().createChatRoom(creatorId);
        rooms.add(room);
        return room;
    }

    public static List<String> getUsersOnline() {
        final List<String> result = new LinkedList<String>();
        for (final Registration user : usersOnline) {
            result.add(user.getFirst_name());
        }
        return result;
    }
    
}
