package com.cadence.zebra100.service;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cadence.zebra100.models.User;
import com.cadence.zebra100.repo.RoleRepository;
import com.cadence.zebra100.repo.UserRepository;

@Service
public class UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    public UserService(UserRepository userRepository, 
    		RoleRepository roleRepository, 
    		BCryptPasswordEncoder bCryptPasswordEncoder)     {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    
    public void save(User user) {
        userRepository.save(user);
    }
    
    public void saveWithUserRole(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(roleRepository.findByName("ROLE_USER"));
        userRepository.save(user);
    }
      
    public void saveUserWithAdminRole(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(roleRepository.findByName("ROLE_ADMIN"));
        userRepository.save(user);
    }    
    
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    
    public List<User> findByEmailNotIn(String email) {
        return userRepository.findByEmailNotIn(email);
    }
    
    public User findById(Long id) {
        return userRepository.findOne(id);
    }
    
    public void inviteUser(User inviteFrom, User inviteTo) {
        List<User> myInvites = inviteFrom.getMyInvites();
        myInvites.add(inviteTo);
        userRepository.save(inviteFrom);
    }
    
    public void acceptInvite(User accepter, User inviter) {
    	List<User> invites = inviter.getMyInvites();
    	invites.remove(accepter);
    	
    	List<User> network = inviter.getNetwork();
    	network.add(accepter);
        userRepository.save(inviter);
    }
    
    public void ignoreInvite(User accepter, User inviter) {
    	List<User> invites = inviter.getMyInvites();
    	invites.remove(accepter);
    	
        userRepository.save(inviter);
    }
   
}