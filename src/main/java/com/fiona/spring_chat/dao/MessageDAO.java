package com.fiona.spring_chat.dao;

import com.fiona.spring_chat.entity.Message;

import java.util.List;

public interface MessageDAO {
    public List<Message> getMessages();
    public void saveMessage(Message msg);
}
