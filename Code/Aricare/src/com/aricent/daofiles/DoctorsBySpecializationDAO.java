/***********************************************************************
    
	  File Name	            :     DoctorBySpecializationDAO.java
	  Principal Author      	: GR_TH3_03
	  Subsystem Name        :
	  Module Name           	: Display doctors according to department 
	  Date of First Release 	: 18-05-2016
	  Author			:          GR_TH3_03
	  Description           	:  class fetching doctors according to specialization from database


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

import com.aricent.configuration.ConnectionManager;
import com.aricent.daointerfaces.DoctorsBySpecializationInterface;
import com.aricent.pojofiles.AddDoctorBean;

/**
 * fetching doctors according to specialization from database
 * 
 * @see DoctorsBySpecializationDAO
 * @see DoctorsbySpecializationDAO#displaydoctor()
 * @version 1.0
 * @author GR_TH3_03
 */
public class DoctorsBySpecializationDAO implements
		DoctorsBySpecializationInterface {
	/**
	 * fetches doctors from database
	 * 
	 * @see displaydoctor()
	 * @param String
	 *            specialization
	 * @exception SQLException
	 * @see DoctorsBySpecializationDAO
	 * @version initial version
	 * @author GR_TH3_03
	 */
	public List<AddDoctorBean> displayDoctor(String specialization) {

		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		Connection connection = null;

		List<AddDoctorBean> doctorList = new ArrayList<>();

		try {// start try
				// establishing connection
			connection = ConnectionManager.getConnection();
			// writing query to fetch doctors
			preparedStatement = connection
					.prepareStatement("Select * from doctor_profile where specialization=?");
			preparedStatement.setString(1, specialization);
			// executing query
			result = preparedStatement.executeQuery();
			while (result.next()) {
				AddDoctorBean doctor = new AddDoctorBean();
				int id = result.getInt(1);
				String doctor_name = result.getString(2);
				String qualification = result.getString(5);
				String image = result.getString(8);
				doctor.setId(id);
				doctor.setName(doctor_name);
				doctor.setSpecialization(specialization);
				doctor.setQualification(qualification);
				doctor.setImage(image);

				doctorList.add(doctor);
			}// end try
		} catch (Exception ex) {

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
		return doctorList;
	}

}
