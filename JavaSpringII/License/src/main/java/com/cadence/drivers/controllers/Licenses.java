package com.cadence.drivers.controllers;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cadence.drivers.models.License;
import com.cadence.drivers.services.DMVService;

@Controller
@RequestMapping("/licenses")
public class Licenses {
	// This allows the input date field for the expiration date to be parsed in a Date object
	// When submitting the form, the input for the expiration date will come as a String, therefore
	// we get a TypeMismatch error. This code bellow allows us to parse the String into the Date
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	private final DMVService dmv;
	
	public Licenses(DMVService dmv) {
		this.dmv = dmv;
	}
	
	@RequestMapping("/new")
	public String newLicense(@ModelAttribute License license, Model model) {
		model.addAttribute("persons", dmv.allPersons());
		return "/licenses/new.jsp";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String createLicense(@Valid @ModelAttribute License license, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("persons", dmv.allPersons());
			return "/licenses/new.jsp";
		} else {
			License lic = dmv.createLicense(license);
			String personId = Long.toString(lic.getPerson().getId());
			return "redirect:/persons/".concat(personId);
		}
	}
}