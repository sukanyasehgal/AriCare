/***********************************************************************
     
	  File Name	            :     AddNewsBean.java
	  Principal Author      	: GR_TH3_03
	  Subsystem Name        :
	  Module Name           	: add news 
	  Date of First Release 	: 13-05-2016
	  Author			:          GR_TH3_03
	  Description           	:  class controlling add news module


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

import com.aricent.daofiles.AddNewsDAO;
import com.aricent.daointerfaces.AddNewsInterface;
import com.aricent.newsletter.MailInvoker;
import com.aricent.pojofiles.AddNewsBean;

/**
 * Servlet implementation class AddNewsServlet
 * 
 * @see AddNews
 * @see AddNews#doPost()
 * @version 1.0
 * @author GR_TH3_03
 */
@WebServlet("/AddNews")
public class AddNews extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddNews() {
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
	 ** @exception ServletException
	 *                , IOException
	 * @see AddNews
	 * @version initial version
	 * @author GR_TH3_03
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// creating log for this class
		final Logger log = Logger.getLogger(AddNews.class);
		log.info("add news module starts");
		// creating object of bean class
		AddNewsBean beanObject = new AddNewsBean();

		// setting object of bean class by taking parameters from form
		beanObject.setSubject(request.getParameter("subject"));
		beanObject.setContent(request.getParameter("content"));

		// creating object of dao class
		AddNewsInterface addNews = new AddNewsDAO();
		// calling method to add newsLetter
		addNews.addNewsLetter(beanObject);
		// invoking mail invoker
		MailInvoker invoke = new MailInvoker();
		invoke.invokeNewsletter(beanObject);

		log.info("news are added into database");

		// setting request attribute and forwarding to addnewsForm.jsp
		request.setAttribute("status", "added");
		request.getRequestDispatcher("addnewsForm.jsp").forward(request,
				response);

	}

}
