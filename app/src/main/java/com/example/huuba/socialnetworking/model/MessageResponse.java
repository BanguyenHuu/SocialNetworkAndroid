package com.example.huuba.socialnetworking.model;

/**
 * Created by Lap trinh on 3/28/2018.
 */
public class MessageResponse {
    private String content;
    private int senderId;
    private int receiverId;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public int getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(int receiverId) {
        this.receiverId = receiverId;
    }
}
