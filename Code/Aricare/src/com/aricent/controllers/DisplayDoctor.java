/***********************************************************************
  
	  File Name	            :     DisplayDoctor.java
	  Principal Author      	: GR_TH3_03
	  Subsystem Name        :
	  Module Name           	: Display Doctors
	  Date of First Release 	: 18-05-2016
	  Author			:          GR_TH3_03
	  Description           	:  class controlling display doctors module


	  Change History

	  Version      		:  1.0
	  Date(DD/MM/YYYY) 	:  18-05-2016
	  Modified by		:  GR_TH3_03
	  Description of change : 

 ***********************************************************************/
package com.aricent.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.aricent.daofiles.DisplayDoctorsDAO;
import com.aricent.daointerfaces.DisplayDoctorsInterface;
import com.aricent.pojofiles.AddDoctorBean;

/**
 * Servlet implementation class DisplayDoctorServlet
 * 
 * @see DisplayDoctor
 * @see DisplayDoctor#doGet()
 * @version 1.0
 * @author GR_TH3_03
 */
@WebServlet("/DisplayDoctor")
public class DisplayDoctor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DisplayDoctor() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 * @exception ServletException
	 *                , IOException
	 * @see DisplayDoctor
	 * @version initial version
	 * @author GR_TH3_03
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// creating log object
		final Logger log = Logger.getLogger(DisplayDoctor.class);
		List<AddDoctorBean> doctorList = new ArrayList<>();
		// creating object of dao class
		DisplayDoctorsInterface display = new DisplayDoctorsDAO();
		// calling method to display doctors
		doctorList = display.displayDoctor();

		log.info("Doctor list is successfully fetched");
		// setting request attribute and forwarding to doctors.jsp
		request.setAttribute("doctorList", doctorList);
		request.getRequestDispatcher("doctors.jsp").forward(request, response);
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
