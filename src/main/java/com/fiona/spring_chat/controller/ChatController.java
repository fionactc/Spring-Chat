package com.fiona.spring_chat.controller;

import com.fiona.spring_chat.dao.MessageDAO;
import com.fiona.spring_chat.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChatController {
    @Autowired
    MessageDAO messageDAO;

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Message newMessage(Message msg) throws Exception {
        System.out.println("Received new message");
        // TODO:save the message
        messageDAO.saveMessage(msg);
        return msg;
    }

    @RequestMapping("/messages")
    public List<Message> index() {
        List<Message> messages = messageDAO.getMessages();
        return messages;
    }

//    @RequestMapping("/hey")
//    public String sayHi() {
//        System.out.println("It actually works");
//        return "hi";
//    }
}
