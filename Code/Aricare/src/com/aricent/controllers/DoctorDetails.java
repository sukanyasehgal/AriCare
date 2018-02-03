/***********************************************************************
          
	  File Name	            :     DoctorDetails.java
	  Principal Author      	: GR_TH3_03
	  Subsystem Name        :
	  Module Name           	: Display Doctor Details
	  Date of First Release 	: 16-05-2016
	  Author			:          GR_TH3_03
	  Description           	:  class controlling display doctor details module


	  Change History

	  Version      		:  1.0
	  Date(DD/MM/YYYY) 	:  16-05-2016
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

import com.aricent.daofiles.DoctorDetailsDAO;
import com.aricent.pojofiles.AddDoctorBean;

/**
 * Servlet implementation class DoctorDetailsServlet
 * 
 * @see DoctorDetails
 * @see DoctorDetails#doGet()
 * @version 1.0
 * @author GR_TH3_03
 */
@WebServlet("/DoctorDetails")
public class DoctorDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DoctorDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 * @exception ServletException
	 *                , IOException
	 * @see DoctorDetails
	 * @version initial version
	 * @author GR_TH3_03
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// creating log object
		final Logger log = Logger.getLogger(DoctorDetails.class);
		// getting current session
		HttpSession session = request.getSession(false);
		// getting parameter from jsp
		int id = Integer.parseInt(request.getParameter("nid"));
		DoctorDetailsDAO display = new DoctorDetailsDAO();
		AddDoctorBean doctor = new AddDoctorBean();
		// calling method of dao to display doctor details
		doctor = display.displayDoctor(id);

		log.info("doctor details are displayed successfully");
		// setting session attribute
		session.setAttribute("doctor", doctor);
		response.sendRedirect("displayDoctorDetails.jsp");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
