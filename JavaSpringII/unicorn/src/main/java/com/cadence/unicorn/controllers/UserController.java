package com.cadence.unicorn.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cadence.unicorn.models.User;
import com.cadence.unicorn.services.UserService;
import com.cadence.unicorn.validator.UserValidator;


@Controller
public class UserController {
	
	private final UserValidator userValidator;
	private final UserService userService;
	
	
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
    
    @PostMapping("/registration")
    public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model, HttpSession session) {
    	 userValidator.validate(user, result);
    	if (result.hasErrors()) {
    		
            return "registrationPage.jsp";
        }
        userService.saveWithUserRole(user);
        return "redirect:/login";
    }
    
}
