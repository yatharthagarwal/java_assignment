package com.training.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.training.model.User;
import com.training.services.Validator;

/**
 * Servlet implementation class User
 */
@WebServlet("/user")
public class ValidationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		
		User user = new User(userName,password,role);
		
		Validator validate = new Validator();
		RequestDispatcher dispatcher;
		HttpSession session = request.getSession();
		
		if(validate.validate(user)) {
			
			session.setAttribute("validStatus", "valid");
			dispatcher = request.getRequestDispatcher("afterAuthenticate.jsp");
			
		} else {
			
			dispatcher = request.getRequestDispatcher("index.jsp");
		}
		
		dispatcher.forward(request, response);
	}

}
