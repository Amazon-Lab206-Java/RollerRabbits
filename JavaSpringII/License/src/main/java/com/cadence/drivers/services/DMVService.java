package com.cadence.drivers.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cadence.drivers.models.License;
import com.cadence.drivers.models.Person;
import com.cadence.drivers.repositories.LicenseRepository;
import com.cadence.drivers.repositories.PersonRepository;

@Service
public class DMVService {
	private final PersonRepository personRepo;
	private final LicenseRepository licenseRepo;
	
	public DMVService(PersonRepository personRepo, LicenseRepository licenseRepo) {
		this.personRepo = personRepo;
		this.licenseRepo = licenseRepo;
	}
	
	public List<Person> allPersons() {
		return personRepo.findAll();
	}
	
	public Person createPerson(Person person) {
		return personRepo.save(person);
	}
	
	public Person getPerson(Long id) {
		return personRepo.findOne(id);
	}
	
	public License createLicense(License license) {
		Long personId = license.getPerson().getId();
		// Pad with 0 with a width of 6
		String licNumber = String.format("%06d", personId);

		license.setNumber(licNumber);
		License lic = licenseRepo.save(license);
		
		return lic;
	}
}