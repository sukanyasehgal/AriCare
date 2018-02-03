/***********************************************************************
            
	  File Name	            :     Signup.java
	  Principal Author      	: GR_TH3_03
	  Subsystem Name        :
	  Module Name           	: signup
	  Date of First Release 	: 12-05-2016
	  Author			:          GR_TH3_03
	  Description           	:  class controlling signup module


	  Change History

	  Version      		:  1.0
	  Date(DD/MM/YYYY) 	:  12-05-2016
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

import org.apache.log4j.Logger;

import com.aricent.daofiles.SignupDAO;
import com.aricent.pojofiles.PatientDetailsBean;

/**
 * Servlet implementation class SignupServlet
 * 
 * @see Signup
 * @see Signup#doPost()
 * @version 1.0
 * @author GR_TH3_03
 */
@WebServlet("/Signup")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Signup() {
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
	 * @see Signup
	 * @version initial version
	 * @author GR_TH3_03
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// creating log object
		final Logger log = Logger.getLogger(Signup.class);
		boolean existing = false;
		// creating object of PatientDetailsBean
		PatientDetailsBean beanObject = new PatientDetailsBean();
		// setting beanObject by taking parameters from form
		beanObject.setP_name(request.getParameter("name"));
		beanObject.setPhone_number(Long.parseLong(request
				.getParameter("phone_number")));
		beanObject.setAddress(request.getParameter("address"));
		beanObject.setEmail_id(request.getParameter("email_id"));
		beanObject.setRole(request.getParameter("role"));
		beanObject.setPassword(request.getParameter("password"));

		SignupDAO check = new SignupDAO();

		// calling method to check whether user is already existing
		existing = check.checkFordatabase(beanObject);

		if (existing) {
			log.info("user already exists");
			request.setAttribute("statusTrue", "available");
			request.getRequestDispatcher("Signup.jsp").forward(request,
					response);
		} else {

			log.info("new user is registered");
			check.registserUser(beanObject);

			request.setAttribute("statusFalse", "notavailable");
			request.getRequestDispatcher("Signup.jsp").forward(request,
					response);

		}
	}
}
