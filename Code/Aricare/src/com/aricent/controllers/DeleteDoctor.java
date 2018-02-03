/***********************************************************************
       
	  File Name	            :     DeleteDoctor.java
	  Principal Author      	: GR_TH3_03
	  Subsystem Name        :
	  Module Name           	: Delete Doctor
	  Date of First Release 	: 13-05-2016
	  Author			:          GR_TH3_03
	  Description           	:  class controlling delete doctor module


	  Change History

	  Version      		:  1.0
	  Date(DD/MM/YYYY) 	:  13-05-2016
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

import com.aricent.daofiles.DeleteDoctorDAO;
import com.aricent.daointerfaces.DeleteDoctorInterface;
import com.aricent.pojofiles.DeleteDoctorBean;

/**
 * Servlet implementation class DeleteDoctorServlet
 * 
 * @see DeleteDoctor
 * @see DeleteDoctor#doPost()
 * @version 1.0
 * @author GR_TH3_03
 */
@WebServlet("/DeleteDoctor")
public class DeleteDoctor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteDoctor() {
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
	 * @see DeleteDoctor
	 * @version initial version
	 * @author GR_TH3_03
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// creating log object
		final Logger log = Logger.getLogger(DeleteDoctor.class);
		// creating object of bean class
		DeleteDoctorBean deleteDoctorBean = new DeleteDoctorBean();
		// setting bean class object by takng parameters from form
		deleteDoctorBean.setName(request.getParameter("name"));
		deleteDoctorBean.setSpecialization(request
				.getParameter("specialization"));
		deleteDoctorBean.setPhoneNumber(Long.parseLong(request
				.getParameter("phone")));
		// cerating object of dao class
		DeleteDoctorInterface deleteDoctorDAO = new DeleteDoctorDAO();

		request.setAttribute("DoctorPresent",
				deleteDoctorDAO.doctorIsPresent(deleteDoctorBean));
		// if doctor is present in the database delete doctor
		if (deleteDoctorDAO.doctorIsPresent(deleteDoctorBean)) {
			log.info("doctor is deleted");
			// calling method of dao to delete doctor
			deleteDoctorDAO.deleteDoctor(deleteDoctorBean);
			request.setAttribute("statusTrue", "deleted");
			request.getRequestDispatcher("deleteDoctorForm.jsp").forward(
					request, response);
		} else {
			log.info("such doctor does not exist");
			request.setAttribute("statusFalse", "Notprersent");
			request.getRequestDispatcher("deleteDoctorForm.jsp").forward(
					request, response);

		}

	}

}
