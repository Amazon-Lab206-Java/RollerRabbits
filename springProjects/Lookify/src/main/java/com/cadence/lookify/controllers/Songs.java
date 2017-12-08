package com.cadence.lookify.controllers;



import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cadence.lookify.models.Song;
import com.cadence.lookify.services.SongService;

@Controller
public class Songs {
	private final SongService songService;
	
	public Songs(SongService songService) {
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
	
	
	@RequestMapping("/songs/new")
	public String newSong(@ModelAttribute("song") Song song) {
		return "songs/new.jsp";
	}
	

	@RequestMapping(value="/songs", method=RequestMethod.POST)
	public String createSong(@Valid @ModelAttribute("song") Song song, BindingResult result) {
        if (result.hasErrors()) {
    		return "songs/new.jsp";
        }else{
        	songService.addSong(song);
            return "redirect:/dashboard";
        }
        
	}
        @RequestMapping("/songs/{id}")
    	public String showSong(@PathVariable("id") Long id, Model model) {
    		model.addAttribute("song", songService.findOne(id));
    		return "songs/show.jsp";
    	}
        
        @RequestMapping("/songs/delete/{id}")
    	public String deleteSong(@PathVariable("id") Long id) {
    		songService.deleteSong(id);
    		return "redirect:/dashboard";
    	}
        
        
	}
	
