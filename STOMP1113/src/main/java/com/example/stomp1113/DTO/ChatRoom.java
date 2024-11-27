package com.example.stomp1113.DTO;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class ChatRoom {
    private String roomName;
    private List<ChatMessage> messages;

    // 기본 생성자
    public ChatRoom() {
//        this.messages = new ArrayList<>();
    }

    @JsonCreator
    public ChatRoom(@JsonProperty("roomName") String roomName) {
        this.roomName = roomName;
        this.messages = new ArrayList<>();
    }

    // Getter 및 Setter
    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public List<ChatMessage> getMessages() {
        System.out.println(messages);
        return messages;
    }

    public void setMessages(List<ChatMessage> messages) {
        this.messages = messages;
    }

    public void addMessage(ChatMessage message) {
        System.out.println("입력된 메세지");
        System.out.println(message);
        messages.add(message);
    }
}