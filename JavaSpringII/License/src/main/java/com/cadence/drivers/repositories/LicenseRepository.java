package com.cadence.drivers.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cadence.drivers.models.License;


@Repository
public interface LicenseRepository extends CrudRepository<License, Long> {

}
