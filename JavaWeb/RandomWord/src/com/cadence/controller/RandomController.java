package com.cadence.controller;

import java.io.IOException;
import java.util.Date;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RandomController
 */
@WebServlet("/Home")
public class RandomController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RandomController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get the click count from session
	    HttpSession session = request.getSession();
	    Integer clickCount = (Integer) session.getAttribute("clickCount");
	    
	    // if it's the first time, it will be null
	    int clicks;
	    if (clickCount == null) {
	    	clicks = 0;
	    } else {
	    	clicks = clickCount;
	    }
	    
		 request.setAttribute("count", clicks);
		 
		 String randomWord = (String) request.getAttribute("randomWord");
		 request.setAttribute("randomWord", randomWord);
		 
		 Date time = (Date) request.getAttribute("time");
		 request.setAttribute("time", time);
		 RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/random.jsp");
	        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    HttpSession session = request.getSession();
	    Random random = new Random();
	    char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
	    String randomWord = "";
	    for (int i = 0; i < 12; i++) {
	        char c = chars[random.nextInt(chars.length)];
	        randomWord += c ;
	    }
	    
	    session.setAttribute("randomWord", randomWord);
	    session.setAttribute("time", new Date());
	    	    
	    Integer clickCount = (Integer) session.getAttribute("clickCount");
	    int clicks;
	    if (clickCount == null) {
	    	clicks = 0;
	    } else {
	    	clicks = clickCount + 1;
	    }
	    session.setAttribute("clickCount", clicks);
		doGet(request, response);
	}

}
