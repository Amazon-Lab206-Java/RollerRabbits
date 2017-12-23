package com.cadence.rainbowpoop.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cadence.rainbowpoop.models.User;
import com.cadence.rainbowpoop.repo.RoleRepository;
import com.cadence.rainbowpoop.repo.UserRepository;

@Service
public class UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;

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
        user.setRoles(roleRepository.findByName("ROLE_ADMIN"));// only if there is admin.
        userRepository.save(user);
    }    
    
    // 3
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    

    

    
}