package com.example.BrightsSocial;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserRepositoryyy {

    List<People> people = new ArrayList<>();



  /*  public UserRepository() {
        User user = new User("Moutasem", "Abu Hashim", "Stockholm", "Mouta", "12345678");
        user.setPresentation("Blivande datatekniker som studerar på JAVA WINTER23");
        users.add(user);
        users.add(new User("Christian", "Neemé", "Stockholm", "Christian", "12345678"));
        users.add(new User("Rasmus", "Samuelsson", "Gävle", "Rasmus", "12345678"));
        users.add(new User("Maryam", "Saddiqa", "Simrishamn", "Maryam", "12345678"));
        users.add(new User("Bilal", "Ejaz", "Simrishamn", "Bil", "12345678"));
        users.get(1).setPresentation("Blivande datatekniker som studerar på JAVA WINTER23");
        users.get(2).setPresentation("Blivande datatekniker som studerar på JAVA WINTER23");
        users.get(3).setPresentation("Blivande datatekniker som studerar på JAVA WINTER23");
        users.get(4).setPresentation("Blivande datatekniker som studerar på JAVA WINTER23");

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
    }*/
}

