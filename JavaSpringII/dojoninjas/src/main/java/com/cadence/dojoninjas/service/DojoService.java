package com.cadence.dojoninjas.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cadence.dojoninjas.model.Dojo;
import com.cadence.dojoninjas.repo.DojoRepository;

@Service
public class DojoService {
	private final DojoRepository dojoRepository;
	
	public DojoService(DojoRepository dojoRepository) {
		this.dojoRepository = dojoRepository;
	}

	
	public List<Dojo> getAll() {
		return dojoRepository.findAll();
	}
	
	
	public void createDojo(Dojo dojo) {
		// TODO Auto-generated method stub
		dojoRepository.save(dojo);
		
	}
	
	public Dojo getDojo(Long id) {
		return dojoRepository.findOne(id);
	}
}
