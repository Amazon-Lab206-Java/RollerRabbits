package com.cadence.human.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class HelloHumanController {

	@RequestMapping("/")
    public String index(@RequestParam(value="name", required=false) String username, Model model){
       if(username==null) {
    	   model.addAttribute("username", "Human");
       }else {
    	   model.addAttribute("username", username);
       }
		return "index.jsp";
	}


}
