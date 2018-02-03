/***********************************************************************
    
	  File Name	            :     DisplayTodayAppointmentDAO.java
	  Principal Author      	: GR_TH3_03
	  Subsystem Name        :
	  Module Name           	: Display Appointment for the current day 
	  Date of First Release 	: 18-05-2016
	  Author			:          GR_TH3_03
	  Description           	:  class fetching current day appointment details from database


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
import com.aricent.daointerfaces.DisplayTodayAppointmentInterface;
import com.aricent.pojofiles.AppointmentBean;
import com.aricent.pojofiles.LoginBean;

/**
 * fetching current day appointment details from database
 * 
 * @see DisplaytodayAppointmentDAO
 * @see DisplayTodayAppointmentDAO#todayAppointment()
 * @version 1.0
 * @author GR_TH3_03
 */
public class DisplayTodayAppointmentDAO implements
		DisplayTodayAppointmentInterface {

	/**
	 * fetches current day appointment details from database
	 * 
	 * @see TodayAppointment()
	 * @param LoginBean
	 *            user
	 * @exception SQLException
	 * @see displayTodayAppointmentDAO
	 * @version initial version
	 * @author GR_TH3_03
	 */
	public List<AppointmentBean> todayAppointment(LoginBean user) {
		// creating log object
		final Logger log = Logger.getLogger(DisplayTodayAppointmentDAO.class);
		List<AppointmentBean> appointmentList = new ArrayList<AppointmentBean>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		Calendar cal = Calendar.getInstance();
		Date currentDate = new java.sql.Date(cal.getTimeInMillis());
		int id = getDoctorId(user);

		try {// start try
				// establishing connection
			connection = ConnectionManager.getConnection();
			// writing query to fetch appointment details
			String query = "Select patient_name,date,timing from appointment_details where  doctor_id=? and date=? ";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			preparedStatement.setDate(2, currentDate);
			// executing query
			result = preparedStatement.executeQuery();

			while (result.next()) {// start while loop

				String patient_name = result.getString(1);
				Date date = result.getDate(2);
				Time time = result.getTime(3);

				AppointmentBean appointment = new AppointmentBean();

				appointment.setP_name(patient_name);
				appointment.setDate(date);
				appointment.setTime(time);

				appointmentList.add(appointment);
				log.info("appointment for current date is fetched from database successfully");
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

	public int getDoctorId(LoginBean user) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		int id = 0;
		long phone_number = user.getPhone_number();

		try {
			connection = ConnectionManager.getConnection();
			String Query = "select doctor_id from doctor_profile where phone_number=? ";
			preparedStatement = connection.prepareStatement(Query);
			preparedStatement.setLong(1, phone_number);
			result = preparedStatement.executeQuery();
			result.next();
			id = result.getInt(1);

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

		return id;
	}
}
