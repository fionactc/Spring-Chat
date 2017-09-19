package com.fiona.spring_chat.entity;

import javax.persistence.*;

@Entity
@Table(name="messages")
public class Message {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @Column(name="senderName")
    private String senderName;

    @Column(name="content")
    private String content;

    public Message() { }

    public int getId() {
        return id;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
