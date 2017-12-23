package com.cadence.rainbowpoop.controllers;

import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cadence.rainbowpoop.models.User;
import com.cadence.rainbowpoop.service.UserService;
import com.cadence.rainbowpoop.validator.UserValidator;

@Controller
public class Users {
	
	private final UserValidator userValidator;
	private final UserService userService;
	private static final Map<String, String> states = new LinkedHashMap<String,String>();
	

	
	public Users(UserValidator userValidator, UserService userService) {
		this.userValidator = userValidator;
		this.userService = userService;
	}
	
    @RequestMapping("/login")
    public String login(@RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout, Model model) {
        if(error != null) {
            model.addAttribute("errorMessage", "No such bunny or pw found, Please try again.");
        }
        if(logout != null) {
            model.addAttribute("logoutMessage", "You're no longer a bunny, please log in to continue being a bunny!");
        }
        return "loginPage.jsp";
    }
    
    @RequestMapping("/registration")
    public String registerForm(@Valid @ModelAttribute("user") User user, Model model) {
        return "registrationPage.jsp";
    }
    
    @RequestMapping("/events")
    public String home(Principal principal, Model model) {
    	String email=principal.getName();
    	model.addAttribute("currentUser", userService.findByEmail(email));
    	return "events.jsp";
    }
    
    @PostMapping("/registration")`
    public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model, HttpSession session) {
    	 userValidator.validate(user, result);
    	if (result.hasErrors()) {
             return "registrationPage.jsp";
        }
        userService.saveWithUserRole(user);
        return "redirect:/login";
    }
    
}
