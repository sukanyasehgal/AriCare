/***********************************************************************

	  File Name	            :     Admin.java
	  Principal Author      	: GR_TH3_03
	  Subsystem Name        :
	  Module Name           	: admin 
	  Date of First Release 	: 17-05-2016
	  Author			:          GR_TH3_03
	  Description           	:  adding admin to database on initialization of server 


	  Change History

	  Version      		:  1.0
	  Date(DD/MM/YYYY) 	:  17-05-2016
	  Modified by		:  GR_TH3_03
	  Description of change : 

 ***********************************************************************/
package com.aricent.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;

import com.aricent.configuration.ConnectionManager;
import com.aricent.configuration.PasswordEncryptor;

/**
 * Servlet implementation class AdminServlet
 * 
 * @see Admin
 * @see Admin#init()
 * @version 1.0
 * @author GR_TH3_03
 */
@WebServlet("/Admin")
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * adding admin to database
	 * 
	 * @see init
	 * @exception ServletException
	 * @see Admin
	 * @version initial version
	 * @author GR_TH3_03
	 */
	@Override
	public void init() throws ServletException {
		// declaring connection
		Connection connection = null;
		// declaring prepared statement
		PreparedStatement ps = null;
		String role = "admin";
		ResultSet rs = null;
		boolean result = false;
		try {// start try

			// creating log object to create logs
			final Logger log = Logger.getLogger(Admin.class);
			// establishing connection
			connection = ConnectionManager.getConnection();
			// preparing query to retrieve admin from database
			ps = connection
					.prepareStatement("Select * from login_details where role = ?");
			ps.setString(1, role);
			// executing query
			rs = ps.executeQuery();
			result = rs.next();
			ps.close();

			// if admin does not exist add admin to database else do nothing
			if (result == false) {// if starts
				log.info("admin is added into database");
				Long phone_number = new Long("9879879870");
				String password = "10000000";
				// creating object of password encryptor
				PasswordEncryptor encryptor = new PasswordEncryptor();
				// encrypting password
				String epassword = encryptor.encryptPassword(password);

				// writing query to add admin to database
				ps = connection
						.prepareStatement("insert into login_details(phone_number,password,role) values (?,?,?)");
				ps.setLong(1, phone_number);
				ps.setString(2, epassword);
				ps.setString(3, role);
				// executing query
				ps.executeUpdate();

			}// if ends

		}// end try block
		catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				connection.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
	}

}
