/***********************************************************************
      
	  File Name	            :     DisplayDoctors.java
	  Principal Author      	: GR_TH3_03
	  Subsystem Name        :
	  Module Name           	: Display Doctors 
	  Date of First Release 	: 18-05-2016
	  Author			:          GR_TH3_03
	  Description           	:  class fetching all doctors from database


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
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.aricent.configuration.ConnectionManager;
import com.aricent.daointerfaces.DisplayDoctorsInterface;
import com.aricent.pojofiles.AddDoctorBean;

/**
 * fetching all doctors from database
 * 
 * @see DisplayDoctorsDAO
 * @see DisplaydoctorsDAO#displayDoctor()
 * @version 1.0
 * @author GR_TH3_03
 */
public class DisplayDoctorsDAO implements DisplayDoctorsInterface {
	/**
	 * fetches all doctors from database
	 * 
	 * @see displaydoctors()
	 * @exception SQLException
	 * @see displayDoctorsDAO
	 * @version initial version
	 * @author GR_TH3_03
	 */
	public List<AddDoctorBean> displayDoctor() {
		// creating log object
		final Logger log = Logger.getLogger(DisplayDoctorsDAO.class);
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		Connection connection = null;

		List<AddDoctorBean> doctorList = new ArrayList<>();

		try {// start try
				// establishing connection
			connection = ConnectionManager.getConnection();
			// writing query to fetch all doctors
			preparedStatement = connection
					.prepareStatement("Select * from doctor_profile");
			// executing query
			result = preparedStatement.executeQuery();
			while (result.next()) {
				// start while loop
				log.info("doctors are fetched from database successfully");
				AddDoctorBean doctor = new AddDoctorBean();
				int id = result.getInt(1);
				String doctor_name = result.getString(2);
				String qualification = result.getString(5);
				String specialization = result.getString(7);
				String image = result.getString(8);
				doctor.setId(id);
				doctor.setName(doctor_name);
				doctor.setQualification(qualification);
				doctor.setSpecialization(specialization);
				doctor.setImage(image);

				doctorList.add(doctor);
			}// end while loop
		}// end try
		catch (Exception ex) {

			ex.printStackTrace();
			log.error(ex.getMessage());
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
		return doctorList;
	}
}
