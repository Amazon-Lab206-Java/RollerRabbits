package com.cadence.events.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cadence.events.models.User;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByEmail(String email);
}