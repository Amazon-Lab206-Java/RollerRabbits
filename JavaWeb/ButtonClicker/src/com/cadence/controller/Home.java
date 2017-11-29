package com.cadence.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
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
		 RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/home.jsp");
	        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    HttpSession session = request.getSession();
	    Integer clickCount = (Integer) session.getAttribute("clickCount");
	    
	    // if it's the first time, it will be null
	    int clicks;
	    if (clickCount == null) {
	    	clicks = 0;
	    } else {
	    	clicks = clickCount + 1;
	    }
	    // update the session so we have it for next time
        session.setAttribute("clickCount", clicks);
		doGet(request, response);
	}

}
