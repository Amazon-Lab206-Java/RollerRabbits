package com.cadence.lookify.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.lookify.models.Song;
import com.codingdojo.lookify.services.SongService;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cadence.lookify.models.Song;
import com.cadence.lookify.services.SongService;

@Controller
public class Main {
private final SongService songService;
	
	public Main(SongService songService) {
		this.songService = songService;
	}
	
	@RequestMapping("/")
	public String index() {
		return "main/index.jsp"; 
	}
	
	@RequestMapping("/dashboard")
	public String dashboard(Model model) {
		model.addAttribute("songs", songService.findAll());
		return "main/dashboard.jsp";
	}
	

	@RequestMapping(value="/search", method=RequestMethod.POST)
	public String search(@RequestParam("artist") String artist) {
		return "redirect:/search/".concat(artist);
	}
	
	@RequestMapping("/search/topTen")
	public String topTen(Model model) {
		model.addAttribute("songs", songService.searchTopTen());
		return "search/topTen.jsp";
	}
	
	@RequestMapping("/search/{artist}")
	public String searchResult(@PathVariable("artist") String artist, Model model) {
		model.addAttribute("artist", artist);
		List<Song> songs = songService.searchByArtist(artist);
		
		if(songs.isEmpty()) {
			return "redirect:/dashboard";
		} else {
			model.addAttribute("songs", songService.searchByArtist(artist));
			return "search/result.jsp";			
		}
	}
}
