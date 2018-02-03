/***********************************************************************
  
	  File Name	            	: MailListCreator.java
	  Principal Author      	: GR_TH3_03
	  Subsystem Name       	 	:
	  Module Name           	: mail list creator 
	  Date of First Release 	: 10-05-2016
	  Author					: GR_TH3_03
	  Description           	:  class for generation of recipient id list for 
	  							   initiation of mail services


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
 * Class for the generation of list for initiating mail services.
 * 
 * @see MailListCreator
 * @see MailListCreator#getIdList(),setIdList(),ListCreator()
 * @version 1.0
 * @author GR_TH3_03
 */
public class MailListCreator {

	private ArrayList<String> IdList = new ArrayList<String>();

	Connection connection = null;
	ResultSet result = null;
	PreparedStatement preparedStatement = null;

	/**
	 * Method to get email ids list
	 * 
	 * @see MailListCreator#getIdList()
	 * @see MailListCreator
	 * @version 1.0
	 * @author GR_TH3_03
	 */
	public ArrayList<String> getIdList() {
		return IdList;
	}

	/**
	 * Method to set email ids list
	 * 
	 * @see MailListCreator#setIdList(ArrayList<String> idList)
	 * @param idList
	 * @see MailListCreator
	 * @version 1.0
	 * @author GR_TH3_03
	 */
	public void setIdList(ArrayList<String> idList) {
		IdList = idList;
	}

	/**
	 * Method to generate list of patients for sending appointment reminders.
	 * 
	 * @see MailListCreator#ListCreator()
	 * @see MailListCreator
	 * @version 1.0
	 * @author GR_TH3_03
	 */
	public void ListCreator() {
		// getting current date through calander instance
		Calendar cal = Calendar.getInstance();
		// incrementing current date to 1
		cal.add(Calendar.DATE, +1);
		// storing current date in form of sql date
		Date currentDate = new java.sql.Date(cal.getTimeInMillis());

		try {// try start

			// establishing connection
			connection = ConnectionManager.getConnection();
			// query to be executed
			String Query = "select email_id from patient_profile where patient_id in(select patient_id from appointment_details where date=?)";
			// creating prepared statement
			preparedStatement = connection.prepareStatement(Query);
			preparedStatement.setDate(1, currentDate);
			result = preparedStatement.executeQuery();
			// while loop start
			while (result.next()) {
				String email_id = result.getString(1);
				// adding email id to id list
				IdList.add(email_id);
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
					connection = null;
				}
			}
		}// finally block ends
	}
}