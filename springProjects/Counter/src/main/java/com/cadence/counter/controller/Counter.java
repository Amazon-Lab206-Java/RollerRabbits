package com.cadence.counter.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Counter {
	@RequestMapping("/")
	public String home(HttpSession session) {
		int count = getCountFromSession(session);
		
		count += 1; // track that visit
		session.setAttribute("count", count);
		return "index.jsp";
	}
	
	@RequestMapping("/counter")
	public String counter(HttpSession session, Model model) {
		int count = getCountFromSession(session);
		
		model.addAttribute("count", count);
		return "counter.jsp";
	}
	
	private int getCountFromSession(HttpSession session) {
		Integer count = (Integer) session.getAttribute("count");
		// check if first time getting count
		if (count == null) {
			count = 0;
		}
		return count;
	}

}
