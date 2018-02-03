/***********************************************************************
         
	  File Name	            :     DisplayNews.java
	  Principal Author      	: GR_TH3_03
	  Subsystem Name        :
	  Module Name           	: Display News
	  Date of First Release 	: 17-05-2016
	  Author			:          GR_TH3_03
	  Description           	:  class controlling display news module


	  Change History

	  Version      		:  1.0
	  Date(DD/MM/YYYY) 	:  17-05-2016
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

import com.aricent.daofiles.DisplayNewsDAO;
import com.aricent.pojofiles.AddNewsBean;

/**
 * Servlet implementation class DisplayNewsServlet
 * 
 * @see DisplayNews
 * @see DisplayNews#doGet()
 * @version 1.0
 * @author GR_TH3_03
 */
@WebServlet("/DisplayNews")
public class DisplayNews extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DisplayNews() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 * @exception ServletException
	 *                , IOException
	 * @see DisplayNews
	 * @version initial version
	 * @author GR_TH3_03
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// creating log object
		final Logger log = Logger.getLogger(DisplayNews.class);
		List<AddNewsBean> newsList = new ArrayList<>();
		// creating object of dao class
		DisplayNewsDAO display = new DisplayNewsDAO();
		// call method of dao class to display news
		newsList = display.displayNews();
		// logger
		log.info("news list is fetched successfully");
		// setting request attribute and forward to news.jsp page
		request.setAttribute("newsList", newsList);
		request.getRequestDispatcher("news.jsp").forward(request, response);
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
