package com.cadence.drivers.controllers;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cadence.drivers.models.Person;
import com.cadence.drivers.services.DMVService;

@Controller
@RequestMapping("persons")
public class Persons {
	private final DMVService dmv;
	
	public Persons(DMVService dmv) {
		this.dmv = dmv;
	}
	
	@RequestMapping("/new")
	public String newPerson(@ModelAttribute("person") Person person) {
		return "/persons/new.jsp";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String newPerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		if(result.hasErrors()) {
			return "/persons/new.jsp";
		} else {
			dmv.createPerson(person);
			return "redirect:/licenses/new";
		}
	}
	
	@RequestMapping("/{id}")
	public String showPerson(@PathVariable("id") Long id, Model model) {
		model.addAttribute("person", dmv.getPerson(id));
		return "/persons/show.jsp";
	}
}

