package com.cadence.port.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PortController {
	@RequestMapping("/")
	public String index() {
		return "index.html";
	}
	@RequestMapping("/projects")
	public String projects() {
		return "myprojects.html";
	}
	@RequestMapping("/me")
	public String me() {
		return "aboutme.html";
	}
}
