/***********************************************************************
      
	  File Name	            :     SignupDAO.java
	  Principal Author      	: GR_TH3_03
	  Subsystem Name        :
	  Module Name           	: SignUp 
	  Date of First Release 	: 18-05-2016
	  Author			:          GR_TH3_03
	  Description           	:  class adding patient details to database


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
import com.aricent.daointerfaces.SignupInterface;
import com.aricent.pojofiles.PatientDetailsBean;

/**
 * adding patient details to db
 * 
 * @see SignupDAO
 * @see SignupDAO#checkfordatabase(),registser user()
 * @version 1.0
 * @author GR_TH3_03
 */
public class SignupDAO implements SignupInterface {

	static Connection connection = null;
	static ResultSet result = null;

	/**
	 * checks from database whether user already exists
	 * 
	 * @see checkFordatabase()
	 * @param PatientDetailsBean
	 *            beanObject
	 * @exception SQLException
	 * @see SignupDAO
	 * @version initial version
	 * @author GR_TH3_03
	 */
	public boolean checkFordatabase(PatientDetailsBean beanObject) {
		long phone_number = beanObject.getPhone_number();
		PreparedStatement preparedStatement = null;
		// storing query to string variable
		String Query = "select * from login_details where phone_number=?";
		// connect to db
		connection = ConnectionManager.getConnection();
		try {// start try

			preparedStatement = connection.prepareStatement(Query);
			preparedStatement.setLong(1, phone_number);
			// execute query
			result = preparedStatement.executeQuery();
			boolean exists = result.next();
			// if user exists return true else false
			if (exists) {
				return true;

			} else {

				return false;
			}

		}// end try
			// some exception handling
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

	/**
	 * adding patient details to db
	 * 
	 * @see registserUser()
	 * @param PatientDetailsBean
	 *            beanObject
	 * @exception SQLException
	 * @see SignupDAO
	 * @version initial version
	 * @author GR_TH3_03
	 */
	public void registserUser(PatientDetailsBean beanObject) {
		PasswordEncryptor encryptor = new PasswordEncryptor();

		String p_name = beanObject.getP_name();
		long phone_number = beanObject.getPhone_number();
		String address = beanObject.getAddress();
		String email_id = beanObject.getEmail_id();
		String role = "patient";
		String password = beanObject.getPassword();
		String ePassword = encryptor.encryptPassword(password);

		PreparedStatement firstStatement = null;
		PreparedStatement secondStatement = null;
		// connect to db
		connection = ConnectionManager.getConnection();
		// storing query to string
		String insertQuery1 = "INSERT INTO login_details VALUES(?,?,?)";
		try {// start try
			firstStatement = connection.prepareStatement(insertQuery1);
			firstStatement.setLong(1, phone_number);
			firstStatement.setString(2, ePassword);
			firstStatement.setString(3, role);
			// execute query
			firstStatement.execute();

			// storing query to string
			String insertQuery2 = "INSERT INTO patient_profile(patient_name,phone_number"
					+ ",address,email_id) VALUES(?,?,?,?)";
			secondStatement = connection.prepareStatement(insertQuery2);
			secondStatement.setString(1, p_name);
			secondStatement.setLong(2, phone_number);
			secondStatement.setString(3, address);
			secondStatement.setString(4, email_id);
			// execute query
			secondStatement.execute();

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

			if (firstStatement != null) {
				try {
					firstStatement.close();
				} catch (Exception e) {
				}
				firstStatement = null;
			}

			if (secondStatement != null) {
				try {
					secondStatement.close();
				} catch (Exception e) {
				}
				secondStatement = null;
			}

			if (connection != null) {
				try {
					connection.close();
				} catch (Exception e) {
				}

				connection = null;
			}
		}
	}
}
