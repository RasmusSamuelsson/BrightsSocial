package com.example.BrightsSocial;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<People, Long> {

    People findByUsername(String username);
}
