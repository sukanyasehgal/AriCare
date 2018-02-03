/***********************************************************************
     
	  File Name	            :     UpdatePillDetailsDAO.java
	  Principal Author      	: GR_TH3_03
	  Subsystem Name        :
	  Module Name           	: update Pill details 
	  Date of First Release 	: 12-05-2016
	  Author			:          GR_TH3_03
	  Description           	:  class adding pill details into database


	  Change History

	  Version      		:  1.0
	  Date(DD/MM/YYYY) 	:  12-05-2016
	  Modified by		:  GR_TH3_03
	  Description of change : 

 ***********************************************************************/
package com.aricent.daofiles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.aricent.configuration.ConnectionManager;
import com.aricent.daointerfaces.UpdatePillDetailsInterface;
import com.aricent.pojofiles.UpdatePillDetailsBean;

/**
 * adding pill details to database
 * 
 * @see UpdatePillDetailsDAO
 * @see UpdatePillDetailsDAO#updatePillDetails()
 * @version 1.0
 * @author GR_TH3_03
 */
public class UpdatePillDetailsDAO implements UpdatePillDetailsInterface {

	Connection connection = null;
	ResultSet result = null;
	int patientId;
	int doctorId;

	/**
	 * adds pill details to database
	 * 
	 * @see updatePillDetails()
	 * @param UpdatePillDetailsBean
	 *            beanObject
	 * @exception SQLException
	 * @see UpdatePillDetailsDAO
	 * @version initial version
	 * @author GR_TH3_03
	 */
	public void updatePillDetails(UpdatePillDetailsBean beanObject) {

		long doctorNumber = beanObject.getDoctorNumber();
		long patientNumber = beanObject.getPatientNumber();
		String pillName = beanObject.getPillName();
		String startDate = beanObject.getStartDate();
		String endDate = beanObject.getEndDate();
		String timing = beanObject.getTiming();
		int dosage = beanObject.getDosage();

		PreparedStatement firstStatement = null;
		PreparedStatement secondStatement = null;
		PreparedStatement thirdStatement = null;

		try { // start try
				// connect to db
			connection = ConnectionManager.getConnection();
			// writing query to fetch patient id from patient profile table
			firstStatement = connection
					.prepareStatement("Select * from patient_profile where phone_number =?");
			firstStatement.setLong(1, patientNumber);
			// execute query
			result = firstStatement.executeQuery();
			result.next();

			patientId = result.getInt(1);
			// writing query to fetch doctor id from doctor profile table
			secondStatement = connection
					.prepareStatement("Select * from doctor_profile where phone_number =?");
			secondStatement.setLong(1, doctorNumber);
			// execute query
			result = secondStatement.executeQuery();
			result.next();
			doctorId = result.getInt(1);
			// writing query to add pill details into db
			thirdStatement = connection
					.prepareStatement("insert into pill_details(doctor_id,patient_id,pill_name,start_date,end_date,dosage_time,dosage)values(?,?,?,?,?,?,?)");
			thirdStatement.setInt(1, doctorId);
			thirdStatement.setInt(2, patientId);
			thirdStatement.setString(3, pillName);
			thirdStatement.setString(4, startDate);
			thirdStatement.setString(5, endDate);
			thirdStatement.setString(6, timing);
			thirdStatement.setInt(7, dosage);
			// execute query
			thirdStatement.executeUpdate();
		} // end try
			// some exception handling
		catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				result.close();
				firstStatement.close();
				secondStatement.close();
				thirdStatement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public boolean validateEntries(UpdatePillDetailsBean beanObject) {
		long doctorNumber = beanObject.getDoctorNumber();
		long patientNumber = beanObject.getPatientNumber();
		String patient_name = beanObject.getPatientName();
		String doctor_name = beanObject.getDoctorName();
		PreparedStatement firstStatement = null;
		PreparedStatement secondStatement = null;
		connection = ConnectionManager.getConnection();
		ResultSet result = null;

		int countp = 0;
		int countd = 0;
		// writing query to fetch patient id from patient profile table
		try {
			firstStatement = connection
					.prepareStatement("Select count(*) from patient_profile where phone_number =? and patient_name = ?");
			firstStatement.setLong(1, patientNumber);
			firstStatement.setString(2, patient_name);
			// execute query
			result = firstStatement.executeQuery();
			result.next();
			countp = result.getInt(1);

			secondStatement = connection
					.prepareStatement("Select count(*) from doctor_profile where phone_number =? and doctor_name=?");
			secondStatement.setLong(1, doctorNumber);
			secondStatement.setString(2, doctor_name);
			result = secondStatement.executeQuery();
			result.next();
			countd = result.getInt(1);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {

				firstStatement.close();
				secondStatement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		if (countd == 1 && countp == 1) {
			return true;
		} else {
			return false;
		}

	}

}
