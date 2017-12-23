package com.cadence.zebra100.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cadence.zebra100.models.User;
import com.cadence.zebra100.service.UserService;
import com.cadence.zebra100.validator.UserValidator;

@Controller
public class Users {
    private UserService userService;
    
    private UserValidator userValidator;
    
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
        return "redirect:/main";
    }
    
    
    @RequestMapping("/main")
    public String login(@RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout, Model model) {
        if(error != null) {
            model.addAttribute("errorMessage", "No such bunny or pw found, Please try again.");
        }
        if(logout != null) {
            model.addAttribute("logoutMessage", "You're no longer a bunny, please log in to continue being a bunny!");
        }
        return "loginPage.jsp";
    }
    
    @RequestMapping(value = {"/", "/professional_profile"})
    public String dashboard(Principal principal, Model model) {
        String email = principal.getName();
        User currentUser = userService.findByEmail(email);
        model.addAttribute("currentUser", currentUser);
        List<User> network = new ArrayList<User>(currentUser.getNetwork());
        network.addAll(currentUser.getUserNetwork());
        
        model.addAttribute("network", network);
        
        return "professionalProfile.jsp";
    }
    
    @RequestMapping(value = {"/users"})
    public String users(Principal principal, Model model) {
        String email = principal.getName();
        User currentUser = userService.findByEmail(email);
        List<User> invitableUsers = userService.findByEmailNotIn(email);
        
        // remove network and invited users
        invitableUsers.removeAll(currentUser.getInvitesToMe());
        invitableUsers.removeAll(currentUser.getMyInvites());
        invitableUsers.removeAll(currentUser.getNetwork());
        invitableUsers.removeAll(currentUser.getUserNetwork());
        
        model.addAttribute("invitableUsers", invitableUsers);
        
        invitableUsers.stream().forEach(u -> System.out.println(u));
        return "users.jsp";
    }
    
    @RequestMapping(value = "/users/{userId}")
    public String user(@PathVariable("userId") long userId, Principal principal, Model model) {
    	String email = principal.getName();
        User user = userService.findById(userId);
        model.addAttribute("user", user);
        return "user.jsp";
    }
    
    @RequestMapping(value = "/users/invite/{userId}")
    public String invite(@PathVariable("userId") long userId, Principal principal) {
    	String email = principal.getName();
        User currentUser = userService.findByEmail(email);
        User invitee = userService.findById(userId);
        
        userService.inviteUser(currentUser, invitee);
        
        return "redirect:/users";
    }

    @RequestMapping(value = "/users/accept/{userId}")
    public String accept(@PathVariable("userId") long userId, Principal principal) {
    	String email = principal.getName();
        User currentUser = userService.findByEmail(email);
        User invitee = userService.findById(userId);
        
        userService.acceptInvite(currentUser, invitee);
        
        return "redirect:/professional_profile";
    }
    
    @RequestMapping(value = "/users/ignore/{userId}")
    public String ignore(@PathVariable("userId") long userId, Principal principal) {
    	String email = principal.getName();
        User currentUser = userService.findByEmail(email);
        User invitee = userService.findById(userId);
        
        userService.ignoreInvite(currentUser, invitee);
        
        return "redirect:/professional_profile";
    }
    
}