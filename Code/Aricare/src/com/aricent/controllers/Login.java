/***********************************************************************
             
	  File Name	            :     Login.java
	  Principal Author      	: GR_TH3_03
	  Subsystem Name        :
	  Module Name           	: login
	  Date of First Release 	: 11-05-2016
	  Author			:          GR_TH3_03
	  Description           	:  class controlling login module


	  Change History

	  Version      		:  1.0
	  Date(DD/MM/YYYY) 	:  11-05-2016
	  Modified by		:  GR_TH3_03
	  Description of change : 

 ***********************************************************************/
package com.aricent.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.aricent.daofiles.LoginDAO;
import com.aricent.daofiles.RoleCheckDAO;
import com.aricent.daointerfaces.LoginInterface;
import com.aricent.daointerfaces.RoleCheckInterface;
import com.aricent.pojofiles.LoginBean;

/**
 * Servlet implementation class LoginServlet
 * 
 * @see Login
 * @see Login#doPost()
 * @version 1.0
 * @author GR_TH3_03
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 * @exception ServletException
	 *                , IOException
	 * @see Login
	 * @version initial version
	 * @author GR_TH3_03
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// creating log object
		final Logger log = Logger.getLogger(Login.class);
		try { // start try block

			// creating object of bean class
			LoginBean user = new LoginBean();

			user.setPhone_number(Long.parseLong(request.getParameter("uname")));

			user.setPassword(request.getParameter("ps"));

			// creating object of dao class
			LoginInterface login = new LoginDAO();
			// calling method to login
			user = login.login(user);

			// if user is valid then redirect to corresponding logged in page
			// according to role
			if (user.isValid()) {

				log.info("login success");
				HttpSession session = request.getSession(true);
				session.setAttribute("currentSessionUser", user);

				RoleCheckInterface roleCheck = new RoleCheckDAO();
				// calling checkrole method to check role of user
				String role = roleCheck.checkRole(user);
				// calling getUserName to get UserName of logged in user
				String userName = roleCheck.getUserName(role, user);
				session.setAttribute("userName", userName);
				// if role is patient then redirect to patientLoggedIn
				if (role.equals("patient")) {
					log.info("redirected to patientloggedin");
					session.setAttribute("forwardPage", "patientloggedin.jsp");
					response.sendRedirect("patientloggedin.jsp");
				}
				// else if role is doctor redirect to doctorloggedin
				else if (role.equals("doctor")) {
					log.info("redirected to doctorloggedin");
					session.setAttribute("forwardPage", "doctorloggedin.jsp");
					response.sendRedirect("doctorloggedin.jsp");
				}
				// else if role is admin redirect to adminLoggedin
				else {
					log.info("redirected to admin");
					session.setAttribute("forwardPage", "adminLoggedIn.jsp");
					response.sendRedirect("adminLoggedIn.jsp");
				}

			}
			// if user is not valid then redirect to login page again with a
			// message
			else {

				log.info("Login not possible incorrect credentials");
				request.setAttribute("valid", "incorrect credentials");

				request.getRequestDispatcher("login.jsp").forward(request,
						response);

			}// end try block

		} catch (Throwable theException) {
			
			log.error(theException.getMessage());
		}
	}

}
