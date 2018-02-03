/***********************************************************************
     
	  File Name	            :     DoctorProfileDAO.java
	  Principal Author      	: GR_TH3_03
	  Subsystem Name        :
	  Module Name           	: Display doctor profile 
	  Date of First Release 	: 18-05-2016
	  Author			:          GR_TH3_03
	  Description           	:  class fetching doctor details from database


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
import com.aricent.daointerfaces.DoctorProfileInterface;
import com.aricent.pojofiles.AddDoctorBean;
import com.aricent.pojofiles.LoginBean;

/**
 * fetching doctor details from database
 * 
 * @see DoctorProfileDAO
 * @see DoctorProfileDAO#displaydoctor()
 * @version 1.0
 * @author GR_TH3_03
 */
public class DoctorProfileDAO implements DoctorProfileInterface {

	/**
	 * fetches doctor details from database
	 * 
	 * @see displaydoctor()
	 * @param LoginBean
	 *            user
	 * @exception SQLException
	 * @see DoctorProfileDAO
	 * @version initial version
	 * @author GR_TH3_03
	 */
	public AddDoctorBean displayDoctor(LoginBean user) {

		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		Connection connection = null;

		AddDoctorBean doctor = new AddDoctorBean();

		try {// start try
				// establishing connection
			connection = ConnectionManager.getConnection();
			long phone_number = user.getPhone_number();
			// writing query to fetch doctor details
			preparedStatement = connection
					.prepareStatement("Select * from doctor_profile where phone_number=?");
			preparedStatement.setLong(1, phone_number);
			// executing query
			result = preparedStatement.executeQuery();
			result.next();

			String name = result.getString(2);

			long phone = result.getLong(3);
			String address = result.getString(4);
			String qualification = result.getString(5);
			String timings = result.getString(6);
			String specialization = result.getString(7);
			String image = result.getString(8);
			String email = result.getString(9);

			doctor.setName(name);
			doctor.setContactNumber(phone);
			doctor.setAddress(address);
			doctor.setQualification(qualification);
			doctor.setTimingToMeet(timings);
			doctor.setSpecialization(specialization);
			doctor.setImage(image);
			doctor.setEmail(email);

		}// end try
		catch (Exception ex) {

			ex.printStackTrace();
		}

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
		return doctor;
	}

}
