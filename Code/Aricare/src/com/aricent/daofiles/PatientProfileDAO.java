/***********************************************************************
     
	  File Name	            :     PatientProfileDAO.java
	  Principal Author      	: GR_TH3_03
	  Subsystem Name        :
	  Module Name           	: Display patient profile 
	  Date of First Release 	: 18-05-2016
	  Author			:          GR_TH3_03
	  Description           	:  class fetching patient details from database


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
import com.aricent.daointerfaces.PatientProfileInterface;
import com.aricent.pojofiles.LoginBean;
import com.aricent.pojofiles.PatientDetailsBean;

/**
 * fetching patient details from database
 * 
 * @see PatientProfileDAO
 * @see PatientProfileDAO#displaypatient()
 * @version 1.0
 * @author GR_TH3_03
 */
public class PatientProfileDAO implements PatientProfileInterface {
	/**
	 * fetches patient details from database
	 * 
	 * @see displayPatient()
	 * @param LoginBean
	 *            user
	 * @exception SQLException
	 * @see PatientProfileDAO
	 * @version initial version
	 * @author GR_TH3_03
	 */
	public PatientDetailsBean displayPatient(LoginBean user) {

		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		Connection connection = null;

		PatientDetailsBean patient = new PatientDetailsBean();

		try {// start try
				// establishing connection
			connection = ConnectionManager.getConnection();
			long phone_number = user.getPhone_number();
			// writing query to fetch patient details
			preparedStatement = connection
					.prepareStatement("Select * from patient_profile where phone_number=?");
			preparedStatement.setLong(1, phone_number);
			// executing query
			result = preparedStatement.executeQuery();
			result.next();

			String name = result.getString(2);

			long phone = result.getLong(3);
			String address = result.getString(4);
			String email = result.getString(5);

			patient.setP_name(name);
			patient.setPhone_number(phone);
			patient.setAddress(address);
			patient.setEmail_id(email);

		}// end try

		// some exception handling
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
		return patient;
	}

}
