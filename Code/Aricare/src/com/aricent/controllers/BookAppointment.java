/***********************************************************************
      
	  File Name	            :     BookAppointment.java
	  Principal Author      	: GR_TH3_03
	  Subsystem Name        :
	  Module Name           	: Book Appointment
	  Date of First Release 	: 11-05-2016
	  Author			:          GR_TH3_03
	  Description           	:  class controlling Book appointment module


	  Change History

	  Version      		:  1.0
	  Date(DD/MM/YYYY) 	:  11-05-2016
	  Modified by		:  GR_TH3_03
	  Description of change : 

 ***********************************************************************/
package com.aricent.controllers;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.aricent.daofiles.AppointmentDAO;
import com.aricent.daointerfaces.AppointmentInterface;
import com.aricent.pojofiles.AppointmentBean;
import com.aricent.pojofiles.LoginBean;

/**
 * Servlet implementation class Appointmentservlet
 * 
 * @see BookAppointment
 * @see BookAppointment#doPost()
 * @version 1.0
 * @author GR_TH3_03
 */
@WebServlet("/BookAppointment")
public class BookAppointment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookAppointment() {
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
	 * @see BookAppointment
	 * @version initial version
	 * @author GR_TH3_03
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// creating log object
		final Logger log = Logger.getLogger(BookAppointment.class);
		log.info("appointment module starts");

		// getting current seesion
		HttpSession session = request.getSession(false);
		// getting session attribute currentSessionUser
		LoginBean user = (LoginBean) session.getAttribute("currentSessionUser");
		// creating object of bean class
		AppointmentBean beanObject = new AppointmentBean();
		// setting object of bean class by taking parameters from form
		beanObject.setUser_number(user.getPhone_number());
		beanObject
				.setD_id(Integer.parseInt(request.getParameter("doctor_name")));
		// creating object of SimpleDateFormat to convert date into specific
		// format
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
		Date appointment_date = null;

		try {// start try
				// converting sql date to util date
			java.util.Date parseddate = formater.parse(request
					.getParameter("date"));
			appointment_date = new java.sql.Date(parseddate.getTime());
			beanObject.setDate(appointment_date);

		}// end try
		catch (ParseException e) {

			log.error(e.getMessage());
		}

		Time appointment_time = java.sql.Time.valueOf(request
				.getParameter("timing"));

		beanObject.setTime(appointment_time);

		AppointmentInterface book = new AppointmentDAO();
		// checking whether doctor is available
		boolean duplicateAppointment = book
				.duplicateAppointmentCheck(beanObject);

		if (duplicateAppointment) {

			log.info("duplicate appointment");
			request.setAttribute("duplicacystatus", "duplicate");
			request.getRequestDispatcher("BookAppointment.jsp").forward(
					request, response);

		} else {

			boolean doctorAvailable = book.AvailabilityCheck(beanObject);
			// if doctor is available then check time slot
			if (doctorAvailable) {
				log.info("doctor is available");
				// checking time slot
				boolean timeSlotAvailable = book.TimeSlotCheck(beanObject);

				// if time slot is available book appoitnment
				if (timeSlotAvailable) {
					log.info("time slot is available and appointment is booked");
					// booking appointment
					book.bookAppointment(beanObject);
					// setting request attribute and forwarding to
					// BookAppointment.jsp
					request.setAttribute("bookstatus", "booked");
					request.getRequestDispatcher("BookAppointment.jsp")
							.forward(request, response);
				}
				// if time slot is not available then don't book appointment
				else {

					log.info("time slot not available");
					// setting request attribute and forwarding to
					// BookAppointment.jsp
					request.setAttribute("timestatus", "not available");
					request.getRequestDispatcher("BookAppointment.jsp")
							.forward(request, response);
				}

			} else {

				log.info("doctor not available");
				// setting request attribute and forwarding to
				// BookAppointment.jsp
				request.setAttribute("doctorstatus", "not available");
				request.getRequestDispatcher("BookAppointment.jsp").forward(
						request, response);
			}
		}
	}
}
