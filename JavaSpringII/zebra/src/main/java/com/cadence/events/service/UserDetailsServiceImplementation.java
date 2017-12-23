package com.cadence.events.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cadence.events.repo.UserRepository;
import com.cadence.events.models.Role;
import com.cadence.events.models.User;

@Service
public class UserDetailsServiceImplementation implements UserDetailsService{
	 private UserRepository userRepository;
	    
	    public UserDetailsServiceImplementation(UserRepository userRepository){
	        this.userRepository = userRepository;
	    }
	    // 1
	    @Override
	    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	        User user = userRepository.findByEmail(email);
	        
	        if(user == null) {
	            throw new UsernameNotFoundException("Email not found");
	        }
	        
	        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), getAuthorities(user));
	    }
	    
	    // 2
	    private List<GrantedAuthority> getAuthorities(User user){
	        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	        for(Role role : user.getRoles()) {
	            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getName());
	            authorities.add(grantedAuthority);
	        }
	        return authorities;
	    }
}
