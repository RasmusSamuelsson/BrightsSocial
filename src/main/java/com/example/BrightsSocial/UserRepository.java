package com.example.BrightsSocial;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserRepository {

    List<User> users = new ArrayList<>();


    public void addUser (User user) {
        users.add(user);
    }
}

