/***********************************************************************
  
	  File Name	            :     CancelAppointment.java
	  Principal Author      	: GR_TH3_03
	  Subsystem Name        :
	  Module Name           	: Cancel Appintment
	  Date of First Release 	: 18-05-2016
	  Author			:          GR_TH3_03
	  Description           	:  class controlling cancel appointment funcationality


	  Change History

	  Version      		:  1.0
	  Date(DD/MM/YYYY) 	:  18-05-2016
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

import com.aricent.daofiles.CancelAppointmentDAO;
import com.aricent.daointerfaces.CancelAppointmentInterface;

/**
 * Servlet implementation class CancelAppointment
 */
@WebServlet("/CancelAppointment")
public class CancelAppointment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CancelAppointment() {
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
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		final Logger log = Logger.getLogger(CancelAppointment.class);
		int appointment_id = Integer.parseInt(request
				.getParameter("appointment_id"));

		CancelAppointmentInterface delete = new CancelAppointmentDAO();
		delete.deleteAppointment(appointment_id);
		log.info(" Appointment is cancelled");
		response.sendRedirect("displayAppointmentHistory.jsp");

	}

}
