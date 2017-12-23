package com.cadence.events.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cadence.events.models.Event;


@Repository
public interface EventRepo extends CrudRepository<Event, Long> {
   
	@Query("SELECT e FROM Event e WHERE state = ?1")
	public List<Event> getInStateEvents(String state);
	
	@Query("SELECT e FROM Event e WHERE state != ?1")
	public List<Event> getOutOfStateEvents(String state);
}