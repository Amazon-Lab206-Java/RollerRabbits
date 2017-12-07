package com.cadence.grouplingo.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cadence.grouplingo.model.Lingo;
import com.cadence.grouplingo.service.LingoService;

@Controller
public class GrouplingoController {

		private final LingoService lingoService;
		
		public GrouplingoController(LingoService lingoService) {
			this.lingoService=lingoService;
		}
		
		@RequestMapping("/")
		public String index(@ModelAttribute("language") Lingo language, Model model) {
			model.addAttribute("languages", lingoService.getLanguages());
			return "languages.jsp";
		}
		
		@PostMapping("/languages")
		public String createLanguages(@Valid @ModelAttribute("language") Lingo language, BindingResult result, Model model) {
	        if (result.hasErrors()) {
	        	model.addAttribute("languages", lingoService.getLanguages());
	    		return "languages.jsp";
	        }else{
	        	lingoService.addLanguage(language);
	            return "redirect:/";
	        }
		}
		
		@RequestMapping("/languages/{id}")
		public String showLanguage(Model model, @PathVariable("id") Long id) {
	    	Lingo lang = lingoService.getLanguage(id);
	    	model.addAttribute("id", id);
	    	model.addAttribute("language", lang);
			return "show.jsp";
		}
		
		@RequestMapping("/languages/edit/{id}")
		public String editLanguage(Model model, @PathVariable("id") Long id) {
			Lingo lang = lingoService.getLanguage(id);
	    	model.addAttribute("id", id);
	    	model.addAttribute("language", lang);
			return "edit.jsp";
		}	
		
		@PostMapping("/languages/update/{id}")
		public String updateLanguage(@Valid @ModelAttribute("language") Lingo language, BindingResult result, @PathVariable("id") Long id) {
	        if (result.hasErrors()) {
	    		return "edit.jsp";
	        }else{
	        	lingoService.updateLanguage(language);
	            return "redirect:/";
	        }
		}
		
		@RequestMapping("/languages/delete/{id}")
		public String deleteLanguage(@PathVariable("id") Long id) {
			lingoService.deleteLanguage(id);
	        return "redirect:/";
		}
}
