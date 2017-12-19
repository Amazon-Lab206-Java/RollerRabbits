package com.cadence.events.service;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cadence.events.models.Event;
import com.cadence.events.models.User;
import com.cadence.events.repo.EventRepo;
import com.cadence.events.repo.RoleRepository;
import com.cadence.events.repo.UserRepository;

@Service
public class EventService {
    

	private EventRepo eventRepo;
	private UserRepository userRepo;
	
	public EventService(EventRepo eventRepo, UserRepository userRepo) {
		this.eventRepo = eventRepo;
		this.userRepo = userRepo;
	}
    
    // 1
    public void save(Event event) {
    	eventRepo.save(event);
    }
    
    public Event findOne(Long eventId) {
    	return eventRepo.findOne(eventId);
    }
    
    public void delete(Long eventId) {
    	eventRepo.delete(eventId);
    }
    
	public void joinEvent(Long eventId, Long userId) {
		Event event = eventRepo.findOne(eventId);
		User user = userRepo.findOne(userId);
		List<User> guests = event.getGuests();
		guests.add(user);
		event.setGuests(guests);
		eventRepo.save(event);
	}
	
	public void leaveEvent(Long eventId, Long userId) {
		Event event = eventRepo.findOne(eventId);
		User user = userRepo.findOne(userId);
		List<User> guests = event.getGuests();
		guests.remove(user);
		event.setGuests(guests);
		eventRepo.save(event);
	}
}