package com.cadence.dojoninjas.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cadence.dojoninjas.model.Ninja;
import com.cadence.dojoninjas.service.DojoService;
import com.cadence.dojoninjas.service.NinjaService;

@Controller

@RequestMapping("/ninjas")
public class Ninjas {
		private final DojoService dojoService;
		private final  NinjaService ninjaService;
		
public Ninjas(DojoService dojoService, NinjaService ninjaService) {
	this.dojoService=dojoService;
	this.ninjaService=ninjaService;
}

@RequestMapping("/new")
public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
	model.addAttribute("dojos", dojoService.getAll());
	return "/ninjas/new.jsp";
}
@PostMapping

public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
	if(result.hasErrors()) {
		return "/ninajs/new.jsp";
}else {
	Ninja n = ninjaService.createNinja(ninja); //what does this n stand for?
	String dojoId= Long.toString(n.getDojo().getId());
	return "redirect:/dojos/".concat(dojoId);
		}
	}
}
