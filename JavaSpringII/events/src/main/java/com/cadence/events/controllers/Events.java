package com.cadence.events.controllers;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cadence.events.models.Event;
import com.cadence.events.models.Message;
import com.cadence.events.models.User;
import com.cadence.events.service.EventService;
import com.cadence.events.service.MessageService;
import com.cadence.events.service.UserService;
import com.cadence.events.validator.EventValidator;

@Controller
public class Events {
	private final UserService userService;
	private final EventService eventService;
	private final EventValidator eventValidator;
	private final MessageService messageService;
	
	private static final Map<String, String> states = new LinkedHashMap<String,String>();
	
	static {
		states.put("AZ", "AZ");
		states.put("CA", "CA");
		states.put("NY", "NY");
		states.put("WA", "WA");
	}
	
	Events(UserService userService, EventService eventService, EventValidator eventValidator, 
			MessageService messageService) {
		this.userService = userService;
		this.eventService = eventService;
		this.eventValidator = eventValidator;
		this.messageService = messageService;
	}
	
	@InitBinder     
	public void initBinder(WebDataBinder binder){
	     binder.registerCustomEditor(Date.class,     
	                         new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true, 10));   
	}
	
    @RequestMapping("/events")
    public String registerForm(@ModelAttribute("event") Event event, Principal principal, Model model) {
		String email = principal.getName();
		User user = userService.findByEmail(email);
		model.addAttribute("states", states);
		model.addAttribute("inStateEvents", userService.getInStateEvents(user));
		model.addAttribute("outOfStateEvents", userService.getOutOfStateEvents(user));
		model.addAttribute("currentUser", user);
        return "events.jsp";
    }
    
    @PostMapping("/newEvent")
    public String registration(@Valid @ModelAttribute("event") Event event, BindingResult result, Model model, Principal principal) {
    	 // Event validator to ensure event is in the future
    	this.eventValidator.validate(event, result);
    	if (result.hasErrors()) {
    		model.addAttribute("states", states);
            return "events.jsp";
        }
    	String email = principal.getName();
		User user = userService.findByEmail(email);
		
		event.setHost(user);
		
        eventService.save(event);
        return "redirect:/events";
    }
    
    @RequestMapping("/events/{eventId}")
    public String registerForm(@ModelAttribute("message") Message message, @PathVariable("eventId") long eventId, Model model) {
    	Event event = eventService.findOne(eventId);
		model.addAttribute("event", event);
        return "eventDetail.jsp";
    }
    
    @PostMapping("/newMessage/{eventId}")
    public String newEvent(@Valid @ModelAttribute("message") Message message,
    		BindingResult result, @PathVariable("eventId") long eventId, Principal principal) {
    	String email = principal.getName();
		User user = userService.findByEmail(email);
    	message.setUser(user);
    	Event event = eventService.findOne(eventId);
    	message.setEvent(event);
    	messageService.save(message);
    	return "redirect:/events" + "/" + eventId;
    }
    
    @RequestMapping("/event/{eventId}/delete")
    public String deleteEvent(@PathVariable("eventId") long eventId) {
    	this.eventService.delete(eventId);
    	return "redirect:/events";
    }
    
}
