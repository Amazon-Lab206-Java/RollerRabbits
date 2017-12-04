package com.cadence.NinjaGold.Controllers;

import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NinjaGoldController {
	private static Random random= new Random();
	 //@RequestMapping(path="/gold", method=RequestMethod.GET)
	@GetMapping("/gold")
	public String index(Model model, HttpSession session) {
		Integer gold = (Integer) session.getAttribute("gold"); // Integer because taking from Object
		if (gold==null) {
			gold=0;
		}
		model.addAttribute("gold", gold);
		return "index.jsp";
	 }
	
	 @RequestMapping(path="/gold", method=RequestMethod.POST)
	 public String gold(@RequestParam(value="place") String place, HttpSession session) {
		 Integer gold = (Integer) session.getAttribute("gold"); // Integer because taking from Object
		 if (gold==null) {
			 gold=0;
		 }
		 
		 int goldEarned;
		 if(place.equals("farm")) {
			 goldEarned=getRandom(10,20);
		 } else if (place.equals("cave")){
			 goldEarned=getRandom(5,10);
		 } else if (place.equals("house")) { 
			 goldEarned=getRandom(2,5);
		 } else if (place.equals("casino")) {
			 goldEarned=getRandom(-50,50);
		 } else {
			 throw new RuntimeException("place is incorrect");
		 }
		 
		 
		 gold+=goldEarned;
		 session.setAttribute("gold", gold);
		 return "redirect:/gold";
		 
		// messages.add(0, msg);
		 session.setAttribute("messages", messages);
	 }
	
	 private int getRandom(int min, int max) {
		 int range=max-min+1;
		 return random.nextInt(range) + min;
	 }
	 
	// @RequestMapping("/reset")
	 //public String resetGame(HttpSession session){
	 //session.setAtttribute("gold",  null);
	 //session.setAttribute("messages", null);
	 //return "redirect:/";
}
