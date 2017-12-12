package com.cadence.dojoninjas.repo;

import org.springframework.data.repository.CrudRepository;

import com.cadence.dojoninjas.model.Ninja;

public interface NinjaRepository extends CrudRepository<Ninja, Long> {

}
