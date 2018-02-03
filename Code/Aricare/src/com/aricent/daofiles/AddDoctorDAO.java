/***********************************************************************
           
	  File Name	            :     AddDoctorDAO.java
	  Principal Author      	: GR_TH3_03
	  Subsystem Name        :
	  Module Name           	: add doctor 
	  Date of First Release 	: 10-05-2016
	  Author			:          GR_TH3_03
	  Description           	:  after checking whether doctor already exists or not and if doesn't exist
                                   adds doctor information into database

	  Change History

	  Version      		:  1.0
	  Date(DD/MM/YYYY) 	:  10-05-2016
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
import com.aricent.configuration.PasswordGenerator;
import com.aricent.daointerfaces.AddDoctorInterface;
import com.aricent.idpasswordcommunicator.MailInvoker;
import com.aricent.pojofiles.AddDoctorBean;

/**
 * adds doctor into database
 * 
 * @see AddDoctorDAO
 * @see addDoctorDAO#checkFordatabase()
 *      ,addDoctor(),addDoctorToLiginDetails(),addDoctorTodoctorProfile()
 * @version 1.0
 * @author GR_TH3_03
 */
public class AddDoctorDAO implements AddDoctorInterface {

	Connection connection = null;
	String role = "doctor";

	/**
	 * checking the existence of doctor into database
	 * 
	 * @see checkForDatabase()
	 * @param AddDoctorBean
	 *            beanObject
	 * @exception SQLException
	 * @see AddDoctorDAO
	 * @version initial version
	 * @author GR_TH3_03
	 */
	public boolean checkFordatabase(AddDoctorBean beanObject) {
		// getting phone_number of doctor
		long phone_number = beanObject.getContactNumber();
		// declaring preparedStatement
		PreparedStatement preparedStatement = null;
		// declaring resultSet
		ResultSet result;
		// query stored in a string variable query
		String Query = "select * from login_details where phone_number=?";
		// establishing connection
		connection = ConnectionManager.getConnection();
		try {
			// start try block

			// preparing query to check whether doctor already exists
			preparedStatement = connection.prepareStatement(Query);
			preparedStatement.setLong(1, phone_number);
			// executing query
			result = preparedStatement.executeQuery();
			boolean exists = result.next();

			if (exists) {
				return true;

			} else {

				return false;
			}

		}// end try block
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// start finally block

			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}// end finally block
		return false;
	}

	/**
	 * @see addDoctor#(AddDoctorBean beanObject)
	 * @exception SQLException
	 * @see AddDoctorDAO
	 * @version initial version
	 * @author GR_TH3_03
	 */
	public void addDoctor(AddDoctorBean beanObject) {

		// creating object of password generator
		PasswordGenerator generator = new PasswordGenerator();
		// creating object of password encryptor
		PasswordEncryptor encryptor = new PasswordEncryptor();
		// generating password
		generator.generatePassword(beanObject);
		String password = generator.getPassword();
		// encrypting password
		String epassword = encryptor.encryptPassword(password);

		// calling method to add doctor into loginDetails table
		addDoctorToLoginDetails(beanObject, epassword);
		// calling method to add doctor into Doctor_profile table
		addDoctorToDoctorPofile(beanObject);
		// invoking mailInvoker
		MailInvoker invoke = new MailInvoker();
		invoke.mailInvoker(beanObject);
	}

	/**
	 * @see addDoctorToLoginDetails#(AddDoctorBean beanObject,String password)
	 * @exception SQLException
	 * @see AddDoctorDAO
	 * @version initial version
	 * @author GR_TH3_03
	 */
	public void addDoctorToLoginDetails(AddDoctorBean beanObject,
			String password) {
		// establishing connection
		connection = ConnectionManager.getConnection();
		PreparedStatement statement = null;
		try {// start try

			// query stored in string variable
			String query = "insert into login_details(phone_number,password,role)values(?,?,?)";
			statement = connection.prepareStatement(query);
			statement.setLong(1, beanObject.getContactNumber());
			statement.setString(2, password);
			statement.setString(3, role);
			// executing query
			statement.executeUpdate();

			statement.close();
			connection.close();

		}// end try
		catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * @see addDoctorToDoctorProfile#(AddDoctorBean beanObject)
	 * @exception SQLException
	 * @see AddDoctorDAO
	 * @version initial version
	 * @author GR_TH3_03
	 */
	public void addDoctorToDoctorPofile(AddDoctorBean beanObject) {
		// establishing connection
		connection = ConnectionManager.getConnection();
		PreparedStatement statement = null;
		try {// start try

			// query stored in string to add into doctor profile table
			String query = "insert into doctor_profile(doctor_name,phone_number,"
					+ "address,qualification,timings,specialization,image,email_id)values(?,?,?,?,?,?,?,?)";
			statement = connection.prepareStatement(query);
			statement.setString(1, beanObject.getName());
			statement.setLong(2, beanObject.getContactNumber());
			statement.setString(3, beanObject.getAddress());
			statement.setString(4, beanObject.getQualification());
			statement.setString(5, beanObject.getTimingToMeet());
			statement.setString(6, beanObject.getSpecialization());
			statement.setString(7, beanObject.getImage());
			statement.setString(8, beanObject.getEmail());

			// executing query
			statement.executeUpdate();

			statement.close();
			connection.close();
		}// end try
		catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
