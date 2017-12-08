package com.cadence.lookify.controllers;



import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.lookify.models.Song;
import com.codingdojo.lookify.services.SongService;

@Controller
public class Songs {
	private final SongService songService;
	
	public Songs(SongService songService) {
		this.songService = songService;
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
	
