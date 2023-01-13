package com.example.BrightsSocial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class MessageService {

    @Autowired
    MessageRepository messageRepository;

    List<Message> getAllMessages(){
        List<Message> allMessages =messageRepository.findAllMessages();


        return allMessages;
    }

    void saveMessage(Message message){
        messageRepository.save(message);
    }


}
