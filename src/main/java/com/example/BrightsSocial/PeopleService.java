package com.example.BrightsSocial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeopleService {

    @Autowired
    PeopleRepository peopleRepository;

    List<People> getAllPeople(){
        List<People> allPeople = (List<People>) peopleRepository.findAll();
        return allPeople;
    }

    void savePeople(People people){
        peopleRepository.save(people);
    }

    People findUser(String username){
        People people = peopleRepository.findByUsername(username);
        return people;
    }
}
