package com.cadence.human.controller;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("sessionAttribute")
public class HelloHumanController {

	@AliasFor(value="Sammy")
	public abstract java.lang.String value
    public String index(@RequestParam(value="Sammy", required=false) String searchQuery) {
        return "index.jsp";
	}


}
