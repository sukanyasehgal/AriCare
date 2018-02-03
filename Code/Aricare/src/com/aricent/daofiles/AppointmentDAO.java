/***********************************************************************
      
	  File Name	            :     AppointmentDAO.java
	  Principal Author      	: GR_TH3_03
	  Subsystem Name        :
	  Module Name           	: book Appointment
	  Date of First Release 	: 09-05-2016
	  Author			:          GR_TH3_03
	  Description           	:  class adding appointment details into database


	  Change History

	  Version      		:  1.0
	  Date(DD/MM/YYYY) 	:  09-05-2016
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

import com.aricent.configuration.ConnectionManager;
import com.aricent.daointerfaces.AppointmentInterface;
import com.aricent.pojofiles.AppointmentBean;

/**
 * adds appointment details into database
 * 
 * @see AppointmentDAO
 * @see AppointmentDAO#bookappointment(),availablilityCheck(),timeslotcheck()
 * @version 1.0
 * @author GR_TH3_03
 */
public class AppointmentDAO implements AppointmentInterface {

	Connection connection = null;
	ResultSet result = null;
	int id;
	int d_id;
	String name;
	String d_name;

	/**
	 * adds appointment details into database
	 * 
	 * @see bookAppointment()
	 * @param AppointmentBean
	 *            beanObject
	 * @exception SQLException
	 * @see AppointmentDAO
	 * @version initial version
	 * @author GR_TH3_03
	 */
	public void bookAppointment(AppointmentBean beanObject) {
		long User_number = beanObject.getUser_number();
		d_id = beanObject.getD_id();
		Date date = beanObject.getDate();
		Time time = beanObject.getTime();
		// establishing connection
		connection = ConnectionManager.getConnection();

		PreparedStatement firstStatement = null;
		PreparedStatement secondStatement = null;
		PreparedStatement thirdStatement = null;

		try {// start try

			// storing query into string variable
			String Query = "SELECT * FROM patient_profile WHERE phone_number= ?";
			firstStatement = connection.prepareStatement(Query);
			firstStatement.setLong(1, User_number);
			result = firstStatement.executeQuery();

			while (result.next()) {// start while loop
				id = result.getInt(1);
				name = result.getString(2);
			}// end while loop

			String query2 = "SELECT * FROM doctor_profile WHERE doctor_id=?";
			secondStatement = connection.prepareStatement(query2);
			secondStatement.setInt(1, d_id);
			// executing query
			result = secondStatement.executeQuery();
			while (result.next()) {// start while
				d_name = result.getString(2);

			}// end while

			String query3 = "INSERT INTO appointment_details(patient_id,doctor_id,patient_name,doctor_name,timing,date) "
					+ "VALUES(?,?,?,?,?,?)";
			thirdStatement = connection.prepareStatement(query3);
			thirdStatement.setInt(1, id);
			thirdStatement.setInt(2, d_id);
			thirdStatement.setString(3, name);
			thirdStatement.setString(4, d_name);
			thirdStatement.setTime(5, time);
			thirdStatement.setDate(6, date);

			thirdStatement.executeUpdate();
		}// end try
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {// start finally
			if (result != null) {
				try {
					result.close();
				} catch (Exception e) {
				}
				result = null;
			}

			if (firstStatement != null) {
				try {
					firstStatement.close();
				} catch (Exception e) {
				}
				firstStatement = null;
			}

			if (secondStatement != null) {
				try {
					secondStatement.close();
				} catch (Exception e) {
				}
				secondStatement = null;
			}

			if (thirdStatement != null) {
				try {
					thirdStatement.close();
				} catch (Exception e) {
				}
				thirdStatement = null;
			}

			if (connection != null) {
				try {
					connection.close();
				} catch (Exception e) {
				}

				connection = null;
			}
		}// end finally

	}

	/**
	 * checking from database whether doctor is available
	 * 
	 * @see AvailabilityCheck()
	 * @param AppointmentBean
	 *            beanObject
	 * @exception SQLException
	 * @see AppointmentDAO
	 * @version initial version
	 * @author GR_TH3_03
	 */

	public boolean AvailabilityCheck(AppointmentBean beanObject) {

		Date appointment_date = beanObject.getDate();
		int doctor_id = beanObject.getD_id();
		int maximumAppointments = 15;
		int count;
		PreparedStatement preparedStatement = null;

		try {// start try

			// establishing connection
			connection = ConnectionManager.getConnection();
			// storing query into string variable
			String Query = "SELECT count(*) FROM appointment_details where doctor_id=? and date=?";
			preparedStatement = connection.prepareStatement(Query);
			preparedStatement.setInt(1, doctor_id);
			preparedStatement.setDate(2, appointment_date);
			// executing query
			result = preparedStatement.executeQuery();
			result.next();
			count = result.getInt(1);
			if (count == maximumAppointments) {

				return false;

			} else {
				return true;
			}

		}// end try
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {// start finally
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
		}// end finally

		return false;
	}

	/**
	 * checking from database whether there is already that time slot
	 * 
	 * @see timeslotCheck()
	 * @param AppointmentBean
	 *            beanObject
	 * @exception SQLException
	 * @see AppointmentDAO
	 * @version initial version
	 * @author GR_TH3_03
	 */
	public boolean TimeSlotCheck(AppointmentBean beanObject) {

		Date appointment_date = beanObject.getDate();
		Time appointment_time = beanObject.getTime();
		int doctor_id = beanObject.getD_id();
		int count;
		PreparedStatement preparedStatement = null;

		try {// start try
				// establishing connection
			connection = ConnectionManager.getConnection();
			// storing query into string variable
			String Query = "SELECT count(*) FROM appointment_details where doctor_id=? and date=? and timing=?";
			preparedStatement = connection.prepareStatement(Query);
			preparedStatement.setInt(1, doctor_id);
			preparedStatement.setDate(2, appointment_date);
			preparedStatement.setTime(3, appointment_time);
			// executing query
			result = preparedStatement.executeQuery();
			result.next();
			count = result.getInt(1);
			if (count == 1) {
				return false;
			} else {
				return true;
			}

		}// end try
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {// start finally
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
		}// end finally
		return false;
	}

	public boolean duplicateAppointmentCheck(AppointmentBean beanObject) {
		Date appointment_date = beanObject.getDate();
		Time appointment_time = beanObject.getTime();
		PreparedStatement firstStatement = null;
		PreparedStatement secondStatement = null;
		int count;
		long User_number = beanObject.getUser_number();
		// executing query
		try {
			connection = ConnectionManager.getConnection();
			String Query1 = "SELECT * FROM patient_profile WHERE phone_number= ?";
			firstStatement = connection.prepareStatement(Query1);
			firstStatement.setLong(1, User_number);
			result = firstStatement.executeQuery();

			while (result.next()) {// start while loop
				id = result.getInt(1);
			}

			String Query = "SELECT count(*) FROM appointment_details WHERE patient_id= ? and date = ? and timing = ?";
			secondStatement = connection.prepareStatement(Query);
			secondStatement.setInt(1, id);
			secondStatement.setDate(2, appointment_date);
			secondStatement.setTime(3, appointment_time);
			result = secondStatement.executeQuery();
			result.next();
			count = result.getInt(1);

			if (count == 1) {
				return true;
			} else {
				return false;
			}
		}// end try
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {// start finally
			if (result != null) {
				try {
					result.close();
				} catch (Exception e) {
				}
				result = null;
			}

			if (firstStatement != null) {
				try {
					firstStatement.close();
				} catch (Exception e) {
				}
				firstStatement = null;
			}

			if (secondStatement != null) {
				try {
					secondStatement.close();
				} catch (Exception e) {
				}
				secondStatement = null;
			}

			if (connection != null) {
				try {
					connection.close();
				} catch (Exception e) {
				}

				connection = null;
			}
		}// end finally

		return true;
	}
}
