package com.cadence.dojoninjas.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cadence.dojoninjas.model.Dojo;
import com.cadence.dojoninjas.service.DojoService;
@Controller
@RequestMapping("/dojos")
public class Dojos {
	private final DojoService dojoService;
	
	
	public Dojos(DojoService dojoService) {
		this.dojoService = dojoService;
	}
	
	@RequestMapping("/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "dojos/new.jsp";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String newDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "/dojos/new.jsp";
		} else {
			dojoService.createDojo(dojo);
			return "redirect:/ninjas/new";
		}
	}	
	
	@RequestMapping("/{id}")  //this is the dojo id
	public String newDojo(@PathVariable("id") Long id, Model model) {
		model.addAttribute("dojo", dojoService.getDojo(id));
		return "/dojos/show.jsp";
	}
}