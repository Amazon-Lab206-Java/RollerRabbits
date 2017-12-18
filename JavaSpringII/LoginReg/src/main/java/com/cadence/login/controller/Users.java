package com.cadence.login.controller;

import java.security.Principal;
import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cadence.login.models.User;
import com.cadence.login.service.UserService;
import com.cadence.login.validator.UserValidator;

@Controller
public class Users {
    private UserService userService;
    
    // NEW
    private UserValidator userValidator;
    
    // NEW
    public Users(UserService userService, UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
    }
    
    
    @RequestMapping("/registration")
    public String registerForm(@Valid @ModelAttribute("user") User user) {
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
    
    @RequestMapping(value = {"/", "/home"})
    public String home(Principal principal, Model model) {
        // 1
        String email = principal.getName();
        model.addAttribute("currentUser", userService.findByEmail(email));
        return "homePage.jsp";
    }
    
    @RequestMapping(value = {"/recordSignIn"})
    public String recordSignIn(Principal principal) {
        String email = principal.getName();
        User user = userService.findByEmail(email);
        user.setLastSignedIn(new Date());
        userService.save(user);
        return "redirect:/dashboard";
    }
    
    @RequestMapping(value = {"/dashboard"})
    public String dashboard(Principal principal, Model model) {
        // 1
        String email = principal.getName();
        model.addAttribute("currentUser", userService.findByEmail(email));
        return "dashboard.jsp";
    }
}