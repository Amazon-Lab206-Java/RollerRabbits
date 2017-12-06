package com.cadence.grouplingo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cadence.grouplingo.model.Lingo;

@Service
public class LingoService {
	private List<Lingo> lingos = new ArrayList<Lingo>();
	
	public List<Lingo> getLanguages() {
		return lingos;
	}
	
	public void addLanguage(Lingo lang) {
		lingos.add(lang);
	}
	
	public Lingo getLanguage(int id) {
		return lingos.get(id);
	}
	
	public void updateLanguage(int id, Lingo lang) {
		lingos.set(id, lang);
	}
	
	public void deleteLanguage(int id) {
		lingos.remove(id);
	}	
}
