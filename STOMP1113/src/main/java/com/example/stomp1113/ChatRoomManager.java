package com.example.stomp1113;

import com.example.stomp1113.DTO.ChatRoom;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ChatRoomManager {
    private final List<ChatRoom> chatRooms = new ArrayList<>();

    public void addChatRoom(ChatRoom chatRoom) {
        chatRooms.add(chatRoom);
    }

    public List<ChatRoom> getAllChatRooms() {
        return chatRooms;
    }

    public ChatRoom getChatRoom(String roomName) {
        return chatRooms.stream()
                .filter(room -> room.getRoomName().equals(roomName))
                .findFirst()
                .orElse(null);
    }
}