/***********************************************************************
       
	  File Name	            :     AddDoctor.java
	  Principal Author      	: GR_TH3_03
	  Subsystem Name        :
	  Module Name           	: add doctor 
	  Date of First Release 	: 10-05-2016
	  Author			:          GR_TH3_03
	  Description           	:  class controlling add Doctor module


	  Change History

	  Version      		:  1.0
	  Date(DD/MM/YYYY) 	:  10-05-2016
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

import com.aricent.daofiles.AddDoctorDAO;
import com.aricent.daointerfaces.AddDoctorInterface;
import com.aricent.pojofiles.AddDoctorBean;

/**
 * Servlet implementation class AddDoctorServlet
 * 
 * @see AddDoctor
 * @see addDoctor#doPost()
 * @version 1.0
 * @author GR_TH3_03
 */
@WebServlet("/AddDoctor")
public class AddDoctor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddDoctor() {
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
	 * @see AddDoctor
	 * @version initial version
	 * @author GR_TH3_03
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// creating object of Logger class
		final Logger log = Logger.getLogger(AddDoctor.class);

		log.info("add doctor module started");

		// creating object of bean class
		AddDoctorBean beanObject = new AddDoctorBean();
		// setting objects of bean class taking parameters from form
		beanObject.setName(request.getParameter("name"));
		beanObject.setContactNumber(Long.parseLong(request
				.getParameter("phone")));
		beanObject.setAddress(request.getParameter("address"));
		beanObject.setQualification(request.getParameter("qualification"));
		beanObject.setTimingToMeet(request.getParameter("timings"));
		beanObject.setSpecialization(request.getParameter("specialization"));
		beanObject.setImage(request.getParameter("pic"));
		beanObject.setEmail(request.getParameter("email_id"));

		// creating object of dao class
		AddDoctorInterface addDoctor = new AddDoctorDAO();

		// defining variable to check if doctor already exists
		boolean existing = addDoctor.checkFordatabase(beanObject);
		if (existing) {
			log.info("doctor is already present with this contact number");
			// setting request attribute and forwarding to Signup.jsp
			request.setAttribute("statusTrue", "already present");
			request.getRequestDispatcher("addDoctorForm.jsp").forward(request,
					response);
		} else {

			log.info("new doctor has been added");
			// calling method to add doctor
			addDoctor.addDoctor(beanObject);

			// setting request attribute and forwarding to Signup.jsp
			request.setAttribute("statusFalse", "added");
			request.getRequestDispatcher("addDoctorForm.jsp").forward(request,
					response);
		}
	}

}
