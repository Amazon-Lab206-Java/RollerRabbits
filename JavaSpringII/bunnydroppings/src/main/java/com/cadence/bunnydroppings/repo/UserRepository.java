package com.cadence.bunnydroppings.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cadence.bunnydroppings.models.User;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByEmail(String email);
}