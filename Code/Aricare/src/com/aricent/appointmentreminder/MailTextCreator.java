/***********************************************************************
    
	  File Name	            	: MailTextCreator.java
	  Principal Author      	: GR_TH3_03
	  Subsystem Name        :
	  Module Name           	: mail text creator
	  Date of First Release 	: 10-05-2016
	  Author			:          GR_TH3_03
	  Description           	:  class for the generation of text for initiating
	                               mail services.


	  Change History

	  Version      		:  1.0
	  Date(DD/MM/YYYY) 	:  10-05-2016
	  Modified by		:  GR_TH3_03
	  Description of change : 

 ***********************************************************************/

package com.aricent.appointmentreminder;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import com.aricent.configuration.ConnectionManager;

/**
 * Class for the generation of text for initiating mail services.
 * 
 * @see MailTextCreator
 * @see MailTextCreator#textCreator(),setMessageList(ArrayList<String>),
 *      ArrayList<String> getMessageList()
 * @version 1.0
 * @author GR_TH3_03
 */
public class MailTextCreator {

	private ArrayList<String> MessageList = new ArrayList<String>();
	Connection connection = null;
	ResultSet result = null;
	PreparedStatement preparedStatement = null;

	/**
	 * Method to get messagelist
	 * 
	 * @see MailTextCreator#getMessageList()
	 * @return ArrayList<String>
	 * @see MailTextCreator
	 * @version 1.0
	 * @author GR_TH3_03
	 */
	public ArrayList<String> getMessageList() {
		return MessageList;
	}

	/**
	 * Method to set messagelist
	 * 
	 * @see MailTextCreator#setMessageList()
	 * @param messageList
	 *            of type ArrayList<String>
	 * @see MailTextCreator
	 * @version 1.0
	 * @author GR_TH3_03
	 */
	public void setMessageList(ArrayList<String> messageList) {
		MessageList = messageList;
	}

	/**
	 * Method to generate texts for sending appointment reminders.
	 * 
	 * @see MailTextCreator#textGenerator()
	 * @see MailTextCreator
	 * @version 1.0
	 * @author GR_TH3_03
	 */
	void textGenerator() {

		// getting current date from
		Calendar cal = Calendar.getInstance();
		// incrementing date to 1
		cal.add(Calendar.DATE, +1);
		// storing date
		Date currentDate = new java.sql.Date(cal.getTimeInMillis());

		try {

			// establishing connection with database
			connection = ConnectionManager.getConnection();
			// query to be executed
			String Query = "select * from appointment_details where date=?";
			// preparing prepared statement
			preparedStatement = connection.prepareStatement(Query);
			// setting date in query to current date
			preparedStatement.setDate(1, currentDate);
			// exectuting the query
			result = preparedStatement.executeQuery();

			// while loop starts
			while (result.next()) {
				// getting required data from Resultset of query
				String patient_name = result.getString(4);
				String doctor_name = result.getString(5);
				String time = result.getString(6);
				// forming the message
				String message = "Dear " + patient_name + "," + "\n"
						+ "Tomorrow you have an appointment " + "Dr. "
						+ doctor_name + " at " + time;

				// adding message to message list
				MessageList.add(message);
			}// while loop ends

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// closing resources
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
		}// finally blosk ends
	}// method ends
}
