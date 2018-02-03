/***********************************************************************
    
	  File Name	            :     DisplayAppointmentDAO.java
	  Principal Author      	: GR_TH3_03
	  Subsystem Name        :
	  Module Name           	: Display Appointment 
	  Date of First Release 	: 18-05-2016
	  Author			:          GR_TH3_03
	  Description           	:  class fetching appointment details from database


	  Change History

	  Version      		:  1.0
	  Date(DD/MM/YYYY) 	:  18-05-2016
	  Modified by		:  GR_TH3_03
	  Description of change : 

 ***********************************************************************/
package com.aricent.daofiles;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;

import com.aricent.configuration.ConnectionManager;
import com.aricent.daointerfaces.DisplayAppointmentInterface;
import com.aricent.pojofiles.AppointmentBean;
import com.aricent.pojofiles.LoginBean;

/**
 * fetching appointment details from database
 * 
 * @see DisplayAppointmentDAO
 * @see DisplayAppointmentDAO#displayAppointmentDetails()
 * @version 1.0
 * @author GR_TH3_03
 */
public class DisplayAppointmentDAO implements DisplayAppointmentInterface {
	/**
	 * fetches appointment details from database
	 * 
	 * @see displayAppointmentDetails()
	 * @param LoginBean
	 *            user
	 * @exception SQLException
	 * @see displayAppointmentDAO
	 * @version initial version
	 * @author GR_TH3_03
	 */
	public List<AppointmentBean> displayAppointmentDetails(LoginBean user) {
		// creating log object
		final Logger log = Logger.getLogger(DisplayAppointmentDAO.class);
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		Connection connection = null;

		List<AppointmentBean> appointmentList = new ArrayList<AppointmentBean>();

		try {// start try
				// establishing connection
			connection = ConnectionManager.getConnection();
			long phone_number = user.getPhone_number();
			// writing query to fetch appointment details
			Calendar cal = Calendar.getInstance();
			Date currentDate = new java.sql.Date(cal.getTimeInMillis());
			connection = ConnectionManager.getConnection();

			preparedStatement = connection
					.prepareStatement("select * from appointment_details where date >= ? and patient_id = (select patient_id from patient_profile where phone_number=?)");
			preparedStatement.setDate(1, currentDate);
			preparedStatement.setLong(2, phone_number);
			// executing query
			result = preparedStatement.executeQuery();
			while (result.next()) {
				// start while loop
				AppointmentBean appointment = new AppointmentBean();
				int appointment_id = result.getInt("appointment_id");
				String patientName = result.getString("patient_name");
				String doctorName = result.getString("doctor_name");
				Time appointmentTime = result.getTime("timing");
				Date appointmentDate = result.getDate("date");

				appointment.setAppointment_id(appointment_id);
				appointment.setP_name(patientName);
				appointment.setD_name(doctorName);
				appointment.setTime(appointmentTime);
				appointment.setDate(appointmentDate);

				appointmentList.add(appointment);

				log.info("appointment details are fetched from database successfully");
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
		return appointmentList;
	}

}
