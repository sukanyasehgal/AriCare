/***********************************************************************
     
	  File Name	            :     DeleteDoctorDAO.java
	  Principal Author      	: GR_TH3_03
	  Subsystem Name        :
	  Module Name           	: delete doctor
	  Date of First Release 	: 13-05-2016
	  Author			:          GR_TH3_03
	  Description           	:  class deleting doctor from database


	  Change History

	  Version      		:  1.0
	  Date(DD/MM/YYYY) 	:  13-05-2016
	  Modified by		:  GR_TH3_03
	  Description of change : 

 ***********************************************************************/
package com.aricent.daofiles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.aricent.configuration.ConnectionManager;
import com.aricent.daointerfaces.DeleteDoctorInterface;
import com.aricent.pojofiles.DeleteDoctorBean;

/**
 * deletes doctor from database
 * 
 * @see DeleteDoctorDAO
 * @see DeleteDoctorDAO#deleteDoctor(),doctorIsPresent()
 * @version 1.0
 * @author GR_TH3_03
 */
public class DeleteDoctorDAO implements DeleteDoctorInterface {

	static Connection connection = null;
	ResultSet result = null;

	/**
	 * deletes doctor from database
	 * 
	 * @see deleteDoctor()
	 * @param DeleteDoctorBean
	 *            beanObject
	 * @exception SQLException
	 * @see DeleteDoctorDAO
	 * @version initial version
	 * @author GR_TH3_03
	 */
	public boolean deleteDoctor(DeleteDoctorBean deleteDoctorBean) {
		PreparedStatement preparedStatement1 = null;
		PreparedStatement preparedStatement2 = null;
		PreparedStatement preparedStatement3 = null;
		PreparedStatement preparedStatement4 = null;

		Long phone = deleteDoctorBean.getPhoneNumber();
		String name = deleteDoctorBean.getName();
		String specialization = deleteDoctorBean.getSpecialization();
		try {// start try

			// establishing connection
			connection = ConnectionManager.getConnection();

			// storing query into string
			String query = "delete from pill_details where doctor_id = (select doctor_id from doctor_profile"
					+ " where phone_number = ? and doctor_name = ? and specialization = ?)";
			preparedStatement1 = connection.prepareStatement(query);
			preparedStatement1.setLong(1, phone);
			preparedStatement1.setString(2, name);
			preparedStatement1.setString(3, specialization);
			// executing query
			preparedStatement1.executeUpdate();
			// storing query into string
			query = "delete from appointment_details where doctor_id = (select doctor_id from doctor_profile"
					+ " where phone_number = ? and doctor_name = ? and specialization = ?)";
			preparedStatement2 = connection.prepareStatement(query);
			preparedStatement2.setLong(1, phone);
			preparedStatement2.setString(2, name);
			preparedStatement2.setString(3, specialization);
			// executing query
			preparedStatement2.executeUpdate();
			// storing query into string
			query = "delete from doctor_profile where phone_number = ? and doctor_name = ? and specialization = ?";
			preparedStatement3 = connection.prepareStatement(query);
			preparedStatement3.setLong(1, phone);
			preparedStatement3.setString(2, name);
			preparedStatement3.setString(3, specialization);
			// executing query
			preparedStatement3.executeUpdate();
			// storing query into string
			query = "delete from login_details where phone_number = ? and doctor_name = ? and specialization = ?";
			preparedStatement4 = connection.prepareStatement(query);
			preparedStatement4.setLong(1, phone);
			preparedStatement4.setString(2, name);
			preparedStatement4.setString(3, specialization);
			// executing query
			preparedStatement4.executeUpdate();

			// closing all connections
			preparedStatement1.close();
			preparedStatement2.close();
			preparedStatement3.close();
			preparedStatement4.close();

			connection.close();
		}// end try block
		catch (SQLException e) {
			e.printStackTrace();
		}

		return true;
	}

	/**
	 * @see doctorIsPresent()
	 * @param DeleteDoctorBean
	 *            beanObject
	 * @exception SQLException
	 * @see DeleteDoctorDAO
	 * @version initial version
	 * @author GR_TH3_03
	 */
	public boolean doctorIsPresent(DeleteDoctorBean deleteDoctorBean) {
		// establishing connection
		Connection con = ConnectionManager.getConnection();
		PreparedStatement preparedStatement = null;
		Long phone = deleteDoctorBean.getPhoneNumber();
		String name = deleteDoctorBean.getName();
		String specialization = deleteDoctorBean.getSpecialization();
		try {// start try block

			// storing query into string
			String query = "select * from doctor_profile where phone_number = ? and doctor_name = ? and specialization = ?";
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setLong(1, phone);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, specialization);
			// executing query
			ResultSet rs = preparedStatement.executeQuery();
			boolean result = rs.next();
			// closing connections
			rs.close();
			preparedStatement.close();
			con.close();
			if (result == true) {
				return true;

			} else {

				return false;

			}

		}// end try block
		catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

}
