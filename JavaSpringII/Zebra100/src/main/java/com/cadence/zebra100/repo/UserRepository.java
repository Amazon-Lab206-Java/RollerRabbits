package com.cadence.zebra100.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cadence.zebra100.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByEmail(String email);
    
    List<User> findAll();
    
    //@Query("SELECT u FROM User u WHERE email != ?1")
    List<User> findByEmailNotIn(String email);
}