/***********************************************************************
      
	  File Name	            :     SmsTextCreator.java
	  Principal Author      	: GR_TH3_03
	  Subsystem Name        :
	  Module Name           	: sms text creator
	  Date of First Release 	: 10-05-2016
	  Author			:          GR_TH3_03
	  Description           	:  class for the generation of text for initiating
	                               sms services.


	  Change History

	  Version      		:  1.0
	  Date(DD/MM/YYYY) 	:  10-05-2016
	  Modified by		:  GR_TH3_03
	  Description of change : 

 ***********************************************************************/
package com.aricent.appointmentsms;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import com.aricent.configuration.ConnectionManager;

/**
 * Class for the generation of text for initiating sms services.
 * 
 * @see SmsTextCreator
 * @see SmsTextCreator#textCreator(),setMessageList(ArrayList<String>),
 *      ArrayList<String> getMessageList()
 * @version 1.0
 * @author GR_TH3_03
 */
public class SmsTextCreator {
	private ArrayList<String> MessageList = new ArrayList<String>();
	Connection connection = null;
	ResultSet result = null;
	PreparedStatement preparedStatement = null;

	/**
	 * Method to get messagelist
	 * 
	 * @see SmsTextCreator#getMessageList()
	 * @return ArrayList<String>
	 * @see SmsTextCreator
	 * @version 1.0
	 * @author GR_TH3_03
	 */
	public ArrayList<String> getMessageList() {
		return MessageList;
	}

	/**
	 * Method to set messagelist
	 * 
	 * @see SmsTextCreator#setMessageList()
	 * @param messageList
	 *            of type ArrayList<String>
	 * @see SmsTextCreator
	 * @version 1.0
	 * @author GR_TH3_03
	 */
	public void setMessageList(ArrayList<String> messageList) {
		MessageList = messageList;
	}

	/**
	 * Method to generate texts for sending appointment reminders.
	 * 
	 * @see SmsTextCreator#textGenerator()
	 * @see SmsTextCreator
	 * @version 1.0
	 * @author GR_TH3_03
	 */
	void textGenerator() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, +1);
		Date currentDate = new java.sql.Date(cal.getTimeInMillis());

		try {
			connection = ConnectionManager.getConnection();
			String Query = "select * from appointment_details where date=?";
			preparedStatement = connection.prepareStatement(Query);
			preparedStatement.setDate(1, currentDate);
			result = preparedStatement.executeQuery();

			while (result.next()) {
				String patient_name = result.getString(4);
				String doctor_name = result.getString(5);
				String time = result.getString(6);
				String message = "Dear " + patient_name + "," + "\n"
						+ "Tomorrow you have an appointment with " + "Dr. "
						+ doctor_name + " at " + time;

				MessageList.add(message);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
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
	}
}
