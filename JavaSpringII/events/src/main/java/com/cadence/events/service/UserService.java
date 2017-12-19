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
public class UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private EventRepo eventRepo;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    public UserService(UserRepository userRepository, RoleRepository roleRepository,
    		EventRepo eventRepo, BCryptPasswordEncoder bCryptPasswordEncoder)     {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.eventRepo = eventRepo;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    
    // 1
    public void save(User user) {
        userRepository.save(user);
    }
    
    // 1
    public void saveWithUserRole(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(roleRepository.findByName("ROLE_USER"));
        userRepository.save(user);
    }
     
     // 2 
    public void saveUserWithAdminRole(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(roleRepository.findByName("ROLE_ADMIN"));
        userRepository.save(user);
    }    
    
    // 3
    public User findByEmail(String username) {
        return userRepository.findByEmail(username);
    }
    
    public List<Event> getInStateEvents(User user) {
		return eventRepo.getInStateEvents(user.getState());
    }
    
    public List<Event> getOutOfStateEvents(User user) {
		return eventRepo.getOutOfStateEvents(user.getState());
    }
}