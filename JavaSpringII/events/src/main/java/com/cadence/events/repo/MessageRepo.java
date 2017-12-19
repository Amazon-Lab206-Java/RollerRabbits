package com.cadence.events.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cadence.events.models.Message;


@Repository
public interface MessageRepo extends CrudRepository<Message, Long> {
   
}