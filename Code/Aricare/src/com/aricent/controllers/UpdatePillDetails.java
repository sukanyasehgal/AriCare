/***********************************************************************
               
	  File Name	            :     UpdatePillDetails
	  Principal Author      	: GR_TH3_03
	  Subsystem Name        :
	  Module Name           	: Update Pill details
	  Date of First Release 	: 12-05-2016
	  Author			:          GR_TH3_03
	  Description           	:  class controlling UpdatePillDetails module


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

import com.aricent.daofiles.UpdatePillDetailsDAO;
import com.aricent.daointerfaces.UpdatePillDetailsInterface;
import com.aricent.pojofiles.UpdatePillDetailsBean;

/**
 * Servlet implementation class UpdatePillDetailsServlet
 * 
 * @see UpdatePillDetails
 * @see UpdatePillDetails#doPost()
 * @version 1.0
 * @author GR_TH3_03
 */
@WebServlet("/UpdatePillDetails")
public class UpdatePillDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdatePillDetails() {
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
	 * @see UpdatePillDetails
	 * @version initial version
	 * @author GR_TH3_03
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// creating log object
		final Logger log = Logger.getLogger(UpdatePillDetails.class);
		// creating object of bean class
		UpdatePillDetailsBean beanObject = new UpdatePillDetailsBean();
		// setting bean object taking parameters from jsp form
		beanObject.setDoctorName(request.getParameter("dname"));
		beanObject.setDoctorNumber(Long.parseLong(request
				.getParameter("dnumber")));
		beanObject.setPatientName(request.getParameter("pname"));
		beanObject.setPatientNumber(Long.parseLong(request
				.getParameter("pnumber")));
		beanObject.setPillName(request.getParameter("pill"));
		beanObject.setStartDate(request.getParameter("startDate"));
		beanObject.setEndDate(request.getParameter("endDate"));
		beanObject.setTiming(request.getParameter("timing"));
		beanObject.setDosage(Integer.parseInt(request.getParameter("dosage")));
		// creating object of dao
		UpdatePillDetailsInterface updatePill = new UpdatePillDetailsDAO();
		// call method to update pill details in database
		boolean valid = updatePill.validateEntries(beanObject);
		
		if (valid) {
			updatePill.updatePillDetails(beanObject);
			log.info("pills are updated successfully");
			// setting request attribute and forward to pillDetailsForm.jsp
			request.setAttribute("statusTrue", "added");
			request.getRequestDispatcher("pillDetailsForm.jsp").forward(
					request, response);
		} else {
			request.setAttribute("statusFalse", "invalid");
			request.getRequestDispatcher("pillDetailsForm.jsp").forward(
					request, response);
		}

	}

}
