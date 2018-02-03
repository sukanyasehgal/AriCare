/***********************************************************************
     
	  File Name	            :     smslistCreator.java
	  Principal Author      	: GR_TH3_03
	  Subsystem Name        :
	  Module Name           	: sms list creator 
	  Date of First Release 	: 10-05-2016
	  Author			:          GR_TH3_03
	  Description           	:  class for generation of recipient id list for 
	  							   initiation of sms services


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
 * Class for the generation of list for initiating sms services.
 * 
 * @see smslistCreator
 * @see smslistCreator#getIdList(),setIdList(),ListCreator()
 * @version 1.0
 * @author GR_TH3_03
 */
public class smslistCreator {
	// Creating a string type arraylist to store mobileIds
	private ArrayList<String> IdList = new ArrayList<String>();

	Connection connection = null;
	ResultSet result = null;
	PreparedStatement preparedStatement = null;
	PreparedStatement statement = null;

	/**
	 * Method to get Mobile ids list
	 * 
	 * @see smslistCreator#getIdList()
	 * @see smslistCreator
	 * @version 1.0
	 * @author GR_TH3_03
	 */
	public ArrayList<String> getIdList() {
		return IdList;
	}

	/**
	 * Method to set Mobile ids list
	 * 
	 * @see smslistCreator#setIdList(ArrayList<String> idList)
	 * @param idList
	 * @see smslistCreator
	 * @version 1.0
	 * @author GR_TH3_03
	 */
	public void setIdList(ArrayList<String> idList) {
		IdList = idList;
	}

	/**
	 * Method to generate list of patients for sending appointment reminders.
	 * 
	 * @see smslistCreator#ListCreator()
	 * @see smslistCreator
	 * @version 1.0
	 * @author GR_TH3_03
	 */
	public void ListCreator() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, +1);
		Date currentDate = new java.sql.Date(cal.getTimeInMillis());
		try {
			connection = ConnectionManager.getConnection();
			String Query = "select phone_number from patient_profile where patient_id in (select patient_id from appointment_details where date=?) ";
			preparedStatement = connection.prepareStatement(Query);
			preparedStatement.setDate(1, currentDate);
			result = preparedStatement.executeQuery();
			while (result.next()) {
				String phone_number = result.getString(1);
				IdList.add(phone_number);
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
					connection = null;
				}
			}
		}
	}

}