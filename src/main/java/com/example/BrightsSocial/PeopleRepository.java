package com.example.BrightsSocial;

import org.springframework.data.repository.CrudRepository;

public interface PeopleRepository extends CrudRepository<People, Long> {

    People findByUsername(String username);
}
