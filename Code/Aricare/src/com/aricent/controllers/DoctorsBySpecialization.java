/***********************************************************************
           
	  File Name	            :     DoctorsBySpecialization.java
	  Principal Author      	: GR_TH3_03
	  Subsystem Name        :
	  Module Name           	: Display Doctors of particular department
	  Date of First Release 	: 14-05-2016
	  Author			:          GR_TH3_03
	  Description           	:  class controlling display doctor according to specialization module


	  Change History

	  Version      		:  1.0
	  Date(DD/MM/YYYY) 	:  14-05-2016
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
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.aricent.daofiles.DoctorsBySpecializationDAO;
import com.aricent.daointerfaces.DoctorsBySpecializationInterface;
import com.aricent.pojofiles.AddDoctorBean;

/**
 * Servlet implementation class doctorsBySpecializationServlet
 * 
 * @see DoctorsBySpecialization
 * @see DoctorsBySpecialization#doGet()
 * @version 1.0
 * @author GR_TH3_03
 */
@WebServlet("/DoctorsBySpecialization")
public class DoctorsBySpecialization extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DoctorsBySpecialization() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 * @exception ServletException
	 *                , IOException
	 * @see DoctorsBySpecialization
	 * @version initial version
	 * @author GR_TH3_03
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// creating log object
		final Logger log = Logger.getLogger(DoctorsBySpecialization.class);
		// getting parameter from jsp
		String specialization = request.getParameter("sid");

		HttpSession session = request.getSession(false);
		List<AddDoctorBean> doctorList = new ArrayList<>();
		DoctorsBySpecializationInterface object = new DoctorsBySpecializationDAO();
		// calling method of dao class to display doctors of particular
		// department
		doctorList = object.displayDoctor(specialization);
		log.info("doctor list according to specialization is fetched successfully");
		// setting session attribute doctorList
		session.setAttribute("doctorList", doctorList);
		response.sendRedirect("displayDoctorsBySpecialization.jsp");
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
