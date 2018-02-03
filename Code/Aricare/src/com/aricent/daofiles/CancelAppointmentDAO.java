/***********************************************************************
      
	  File Name	            :     CancelAppointmentDAO.java
	  Principal Author      	: GR_TH3_03
	  Subsystem Name        :
	  Module Name           	: Cancel Appointment
	  Date of First Release 	: 09-05-2016
	  Author			:          GR_TH3_03
	  Description           	:  class cancelling appointment from database


	  Change History

	  Version      		:  1.0
	  Date(DD/MM/YYYY) 	:  09-05-2016
	  Modified by		:  GR_TH3_03
	  Description of change : 

 ***********************************************************************/
package com.aricent.daofiles;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.aricent.configuration.ConnectionManager;
import com.aricent.daointerfaces.CancelAppointmentInterface;

public class CancelAppointmentDAO implements CancelAppointmentInterface {

	public void deleteAppointment(int appointment_id) {
		PreparedStatement preparedStatement = null;
		Connection connection = null;

		try {// start try
				// establishing connection
			connection = ConnectionManager.getConnection();

			// writing query to fetch doctor details
			preparedStatement = connection
					.prepareStatement("delete from appointment_details where appointment_id = ?");
			preparedStatement.setInt(1, appointment_id);
			// executing query
			preparedStatement.execute();

		}// end try
		catch (Exception ex) {

			ex.printStackTrace();
		}

		finally {
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

	}

}
