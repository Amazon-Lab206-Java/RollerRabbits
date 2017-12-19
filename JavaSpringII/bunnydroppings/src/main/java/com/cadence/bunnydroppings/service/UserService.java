package com.cadence.bunnydroppings.service;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cadence.bunnydroppings.models.Idea;
import com.cadence.bunnydroppings.models.User;
import com.cadence.bunnydroppings.repo.RoleRepository;
import com.cadence.bunnydroppings.repo.UserRepository;

@Service
public class UserService {
    private UserRepository userRepository;
    private Repository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    public UserService(UserRepository userRepository, RoleRepository roleRepository,
    		BCryptPasswordEncoder bCryptPasswordEncoder)     {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
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
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    
    public List<Idea> getIdea(User user) {
		return eventRepo.getIdea(user.getIdea());
    }
    
  
}