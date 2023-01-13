package com.example.BrightsSocial;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepository extends CrudRepository<Message, Long> {

    List<Message> findAllOrderByTime();

    @Query(value ="Select * from Message order by Time desc", nativeQuery = true)
    List<Message> findAllMessages();

}
