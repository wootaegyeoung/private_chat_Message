package com.example.stomp1113.Contoller;


import com.example.stomp1113.ChatRoomManager;
import com.example.stomp1113.DTO.ChatMessage;
import com.example.stomp1113.DTO.ChatRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ChatController {

    @Autowired
    private ChatRoomManager chatRoomManager;

    @MessageMapping("/chat/{room}")
    @SendTo("/topic/{room}")
    public ChatMessage sendMessage(@DestinationVariable("room") String roomName, @Payload ChatMessage message) {

        ChatRoom chatRoom = chatRoomManager.getChatRoom(roomName);
        if (chatRoom != null) {
            System.out.println("방 찾음");
            chatRoom.addMessage(message); // 메시지를 채팅방에 추가
        } else {
            System.out.println("방을 찾을 수 없습니다.");
        }

        return message; // 클라이언트에게 메시지 반환
    }


    @MessageMapping("/createRoom")
    @SendTo("/queue/chat-rooms")
    public ChatRoom createRoom(ChatRoom chatRoom) {
        System.out.println("방생성");
        chatRoomManager.addChatRoom(chatRoom); // 채팅방 추가
        return chatRoom; // 클라이언트에게 생성된 채팅방 반환
    }

    @GetMapping("/chat/{roomName}/messages")
    public List<ChatMessage> getMessages(@PathVariable String roomName) {
        ChatRoom chatRoom = chatRoomManager.getChatRoom(roomName);
;
        return chatRoom != null ? chatRoom.getMessages() : new ArrayList<>(); // 채팅 내역 반환
    }

    @GetMapping("/chat/rooms")
    public List<ChatRoom> getAllChatRooms() {
        return chatRoomManager.getAllChatRooms(); // 모든 채팅방 반환
    }
}