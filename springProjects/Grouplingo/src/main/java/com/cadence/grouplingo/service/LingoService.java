package com.cadence.grouplingo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cadence.grouplingo.model.Lingo;
import com.cadence.grouplingo.repository.LingoRepo;

@Service
public class LingoService {
	private final LingoRepo lingoRepo;
	public LingoService(LingoRepo lingoRepo) {
		this.lingoRepo = lingoRepo;
	}
	
	public List<Lingo> getLanguages() {
		return lingoRepo.findAll();
	}
	
	public void addLanguage(Lingo lang) {
		lingoRepo.save(lang);
	}
	
	public Lingo getLanguage(Long id) {
		return lingoRepo.findOne(id);
	}
	
	public void updateLanguage(Lingo lang) {
		lingoRepo.save(lang);
	}
	
	public void deleteLanguage(Long id) {
		lingoRepo.delete(id);
	}	
}
