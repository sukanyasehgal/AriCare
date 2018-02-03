/***********************************************************************
    
	  File Name	            :     RoleCheckDAO.java
	  Principal Author      	: GR_TH3_03
	  Subsystem Name        :
	  Module Name           	: check Role 
	  Date of First Release 	: 16-05-2016
	  Author			:          GR_TH3_03
	  Description           	:  class fetching role of logged in user from database


	  Change History

	  Version      		:  1.0
	  Date(DD/MM/YYYY) 	:  16-05-2016
	  Modified by		:  GR_TH3_03
	  Description of change : 

 ***********************************************************************/
package com.aricent.daofiles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.aricent.configuration.ConnectionManager;
import com.aricent.daointerfaces.RoleCheckInterface;
import com.aricent.pojofiles.LoginBean;

/**
 * fetching role of logged in user from database
 * 
 * @see RoleCheckDAO
 * @see RoleCheckDAO#checkRole(),getUserName()
 * @version 1.0
 * @author GR_TH3_03
 */
public class RoleCheckDAO implements RoleCheckInterface {
	/**
	 * fetching role of logged in user from database
	 * 
	 * @see checkRole()
	 * @param LoginBean
	 *            user
	 * @exception SQLException
	 * @see RoleCheckDAO
	 * @version initial version
	 * @author GR_TH3_03
	 */
	public String checkRole(LoginBean user) {
		String role = null;
		Connection connection = null;
		ResultSet result = null;
		PreparedStatement preparedStatement = null;
		try {// start try
			long phone_number = user.getPhone_number();
			// connect to db
			connection = ConnectionManager.getConnection();
			// storing query to string
			String Query = "SELECT role FROM login_details WHERE phone_number= ?";
			preparedStatement = connection.prepareStatement(Query);
			preparedStatement.setLong(1, phone_number);
			// executing query
			result = preparedStatement.executeQuery();
			result.next();
			role = result.getString(1);

			return role;

		}// end try
			// some exception handling
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (result != null) {
				try {
					result.close();
				} catch (Exception e) {
				}
				result = null;
			}

			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (Exception e) {
				}
				preparedStatement = null;
			}

			if (connection != null) {
				try {
					connection.close();
				} catch (Exception e) {
				}

				connection = null;
			}
		}

		return role;

	}

	/**
	 * fetching name of logged in user from database
	 * 
	 * @see getUserName()
	 * @param LoginBean
	 *            user,String Role
	 * @exception SQLException
	 * @see RoleCheckDAO
	 * @version initial version
	 * @author GR_TH3_03
	 */
	public String getUserName(String role, LoginBean user) {
		String userName = null;
		Connection connection = null;
		ResultSet result = null;
		PreparedStatement preparedStatement = null;
		try {// start try
			long phone_number = user.getPhone_number();
			// connect to db
			connection = ConnectionManager.getConnection();
			String Query = null;
			// if role is doctor then check doctor_profile table
			if (role.equalsIgnoreCase("doctor")) {
				Query = "SELECT * FROM doctor_profile WHERE phone_number= ?";
				preparedStatement = connection.prepareStatement(Query);
				preparedStatement.setLong(1, phone_number);
				// executing query
				result = preparedStatement.executeQuery();
				result.next();
				userName = result.getString(2);
			}
			// if role is patient check patient_profile table
			else if (role.equalsIgnoreCase("patient")) {
				Query = "SELECT * FROM patient_profile WHERE phone_number= ?";
				preparedStatement = connection.prepareStatement(Query);
				preparedStatement.setLong(1, phone_number);
				// execute query
				result = preparedStatement.executeQuery();
				result.next();
				userName = result.getString(2);
			}
			// else set username to admin
			else {
				userName = "admin";
			}

		}// end try
			// some exception handling
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (result != null) {
				try {
					result.close();
				} catch (Exception e) {
				}
				result = null;
			}

			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (Exception e) {
				}
				preparedStatement = null;
			}

			if (connection != null) {
				try {
					connection.close();
				} catch (Exception e) {
				}

				connection = null;
			}
		}

		return userName;
	}

}
