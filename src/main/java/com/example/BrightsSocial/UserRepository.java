package com.example.BrightsSocial;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserRepository {

    List<User> users = new ArrayList<>();



    public UserRepository() {
        users.add(new User("kalle", "anka", "stockholm", "hej", "12345678"));
        users.add(new User("kalle2", "anka2", "göteborg", "hej2", "12345678"));
        users.add(new User("kalle3", "anka3", "malmö", "hej3", "12345678"));


    }

    public void addUser (User user) {
        users.add(user);
    }

    public List<User> getUsers() {
        return users;
    }
    public User getUser (String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)){
                return user;
            }
          }
        return null;
    }
}

