package com.cadence.dojoninjas.service;

import org.springframework.stereotype.Service;

import com.cadence.dojoninjas.model.Ninja;
import com.cadence.dojoninjas.repo.NinjaRepository;

@Service
public class NinjaService {
	private final NinjaRepository ninjaRepository;
	public NinjaService(NinjaRepository ninjaRepository) {
		this.ninjaRepository = ninjaRepository;
	}
	
	public Ninja createNinja(Ninja ninja) {
		// TODO Auto-generated method stub
		return ninjaRepository.save(ninja);
	}

}
