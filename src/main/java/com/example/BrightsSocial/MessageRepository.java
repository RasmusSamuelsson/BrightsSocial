package com.example.BrightsSocial;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MessageRepository {

    private List<Message> messages = new ArrayList<>();

    public MessageRepository(){
        LocalDateTime localDatetime = LocalDateTime.now();
        Message message = new Message("Hej Allihop", "hej2", localDatetime);
        Message message2 = new Message("Hej Kalle", "hej3", localDatetime);
        messages.add(message);
        messages.add(message2);

    }

    public List<Message> getMessages(){
        return messages;
    }

    public void add(Message message){
        messages.add(message);
    }
}
