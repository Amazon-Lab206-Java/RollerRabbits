package com.cadence.grouplingo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cadence.grouplingo.model.Lingo;

@Repository
public interface LingoRepo extends CrudRepository<Lingo, Long>{
	List<Lingo> findAll();
}
