package com.example.stomp1113.DTO;

import lombok.Getter;
import lombok.Setter;

public class ChatMessage {

    private String user;
    private String content;
    private String timestamp;
    private String roomName;

    // 기본 생성자
    public ChatMessage() {}

    public ChatMessage(String user, String content, String timestamp, String roomName) {
        this.user = user;
        this.content = content;
        this.timestamp = timestamp;
        this.roomName=roomName;
    }

    // Getter 및 Setter
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}