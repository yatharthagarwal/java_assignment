package com.exercise.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exercise.services.UserService;

/**
 * Servlet implementation class UserServlets
 */
@WebServlet("/user")
public class UserServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
	
	UserService service;
    public UserServlets() {
        // TODO Auto-generated constructor stub
    	service = new UserService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("username");
		String planType = request.getParameter("plan");
//		double cost = 0.0;
		
		
		
//		System.out.println("Cost is :" + cost);
		
		double value = service.amountDeduction(name,planType);
		
		request.setAttribute("value", value);
		request.setAttribute("limit", service.getCreditLimit(name));
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("message.jsp");
		dispatcher.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
