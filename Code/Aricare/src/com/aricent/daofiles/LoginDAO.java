/***********************************************************************
     
	  File Name	            :     LoginDAO.java
	  Principal Author      	: GR_TH3_03
	  Subsystem Name        :
	  Module Name           	: Login
	  Date of First Release 	: 18-05-2016
	  Author			:          GR_TH3_03
	  Description           	:  class checking user credentials from database for login


	  Change History

	  Version      		:  1.0
	  Date(DD/MM/YYYY) 	:  18-05-2016
	  Modified by		:  GR_TH3_03
	  Description of change : 

 ***********************************************************************/
package com.aricent.daofiles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.aricent.configuration.ConnectionManager;
import com.aricent.configuration.PasswordEncryptor;
import com.aricent.daointerfaces.LoginInterface;
import com.aricent.pojofiles.LoginBean;

/**
 * checks user credentials from database for login
 * 
 * @see LoginDAO
 * @see LoginDAO#login()
 * @version 1.0
 * @author GR_TH3_03
 */
public class LoginDAO implements LoginInterface {
	Connection connection = null;
	ResultSet result = null;

	/**
	 * checks user credentials from database for login
	 * 
	 * @see login()
	 * @param LoginBean
	 *            bean
	 * @exception SQLException
	 * @see LoginDAO
	 * @version initial version
	 * @author GR_TH3_03
	 */
	public LoginBean login(LoginBean bean) {

		PasswordEncryptor decryptor = new PasswordEncryptor();
		long phone_number = bean.getPhone_number();
		String password = bean.getPassword();
		// storing query to string variable
		String Query = "select password from login_details where phone_number=?";

		PreparedStatement preparedStatement = null;
		try {// start try
				// connect to DB
			connection = ConnectionManager.getConnection();
			preparedStatement = connection.prepareStatement(Query);
			preparedStatement.setLong(1, phone_number);
			// executing query
			result = preparedStatement.executeQuery();

			boolean exists = result.next();

			// if user does not exist set the isValid variable to false
			if (!exists) {

				bean.setValid(false);

			} else if (exists) // if user exists set the isValid variable to
								// true
			{

				if (decryptor.matchPassword(password, result.getString(1))) {
					bean.setValid(true);
				} else {
					bean.setValid(false);
				}
			}

		}// end try
		catch (Exception ex) {

			ex.printStackTrace();
		}
		// some exception handling
		finally {
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

		return bean;

	}
}
