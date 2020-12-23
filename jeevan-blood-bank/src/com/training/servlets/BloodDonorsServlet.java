package com.training.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.training.daos.DaoImpl;
import com.training.ifaces.DataAccess;
import com.training.model.BloodDonor;
import com.training.utils.DbConnectionUtil;

/**
 * Servlet implementation class BloodDonorsServlet
 */
@WebServlet("/donor")
public class BloodDonorsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private Connection con;
	DataAccess dao = null;
    public BloodDonorsServlet() {
        super();
        con = DbConnectionUtil.getMySqlConnection();
        dao = new DaoImpl();
        }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<BloodDonor> list = dao.findAll();
		HttpSession session = request.getSession();
		
		System.out.println("new : " + session.isNew());
		
	
			if(session.getAttribute("validStatus") != null) {
				if(session.getAttribute("validStatus").equals("valid")) {
					request.setAttribute("valid", 1);
				}
			} else {
				request.setAttribute("valid", -1);
			}
		
		request.setAttribute("donorList", list);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("showDonors.jsp");
		dispatcher.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		if(session.getAttribute("validStatus").equals("valid")) {
			
			String name = request.getParameter("username");
			int age = Integer.parseInt(request.getParameter("age"));
			String gender = request.getParameter("gender");
			String group = request.getParameter("group");
			int mobileNumber = Integer.parseInt(request.getParameter("mobileNumber"));
			String email = request.getParameter("email");
			LocalDate dateOfBirth = LocalDate.parse(request.getParameter("dateOfBirth"));
			
			BloodDonor donor = new BloodDonor(name,age,gender,group,mobileNumber,email,dateOfBirth);
			
			
			int rowsAdded = dao.add(donor);
			
			request.setAttribute("rowsAdded", rowsAdded);
			RequestDispatcher dispatcher = request.getRequestDispatcher("addDonor.jsp");
			dispatcher.forward(request, response);
		}
		
	}

}
