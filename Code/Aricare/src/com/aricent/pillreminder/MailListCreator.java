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

package com.aricent.pillreminder;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
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
	private ArrayList<String> PillList = new ArrayList<String>();
	private ArrayList<Time> TimeList = new ArrayList<Time>();
	private ArrayList<String> ReminderText = new ArrayList<String>();

	/**
	 * Method to get pill list
	 * 
	 * @see MailListCreator#getReminderText()
	 * @see MailListCreator
	 * @version 1.0
	 * @author GR_TH3_03
	 */
	public ArrayList<String> getReminderText() {
		return ReminderText;
	}

	/**
	 * Method to set pill list
	 * 
	 * @see MailListCreator#setReminderText()
	 * @see MailListCreator
	 * @version 1.0
	 * @author GR_TH3_03
	 */
	public void setReminderText(ArrayList<String> reminderText) {
		ReminderText = reminderText;
	}

	/**
	 * Method to get pill list
	 * 
	 * @see MailListCreator#getPillList()
	 * @see MailListCreator
	 * @version 1.0
	 * @author GR_TH3_03
	 */
	public ArrayList<String> getPillList() {
		return PillList;
	}

	/**
	 * Method to set pill list
	 * 
	 * @see MailListCreator#setPillList()
	 * @see MailListCreator
	 * @version 1.0
	 * @author GR_TH3_03
	 */
	public void setPillList(ArrayList<String> pillList) {
		PillList = pillList;
	}

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
	 * Method to get time list
	 * 
	 * @see MailListCreator#getTimeList()
	 * @see MailListCreator
	 * @version 1.0
	 * @author GR_TH3_03
	 */
	public ArrayList<Time> getTimeList() {
		return TimeList;
	}

	/**
	 * Method to set time list
	 * 
	 * @see MailListCreator#setTimeList()
	 * @see MailListCreator
	 * @version 1.0
	 * @author GR_TH3_03
	 */
	public void setTimeList(ArrayList<Time> timeList) {
		TimeList = timeList;
	}

	Connection connection = null;
	ResultSet Idresult = null;
	ResultSet emailIdresult = null;
	PreparedStatement preparedStatement = null;
	PreparedStatement statement = null;

	/**
	 * Method to create patient list
	 * 
	 * @see MailListCreator#patientListCreator()
	 * @see MailListCreator
	 * @version 1.0
	 * @author GR_TH3_03
	 */
	void patientListCreator() {
		// getting current date from calendar
		Calendar cal = Calendar.getInstance();
		// storing current date
		Date currentDate = new java.sql.Date(cal.getTimeInMillis());
		// establishing connection
		connection = ConnectionManager.getConnection();

		try {
			// query to be executed to get pill details
			String IdQuery = " select patient_id,pill_name,dosage_time from pill_details where end_date >= ?";
			preparedStatement = connection.prepareStatement(IdQuery);
			preparedStatement.setDate(1, currentDate);
			Idresult = preparedStatement.executeQuery();
			// loop for iteration of resultset for patientId
			while (Idresult.next()) {
				// retreiving patient id
				int patient_id = Idresult.getInt("patient_id");
				// retreiving pill_name
				String pill_name = Idresult.getString(2);
				// adding pill name to the list
				PillList.add(pill_name);
				// adding time to the list
				Time time = Idresult.getTime(3);
				TimeList.add(time);
				// query to get mail is of patients
				String mailIdQuery = " select email_id from patient_profile where patient_id = ?";
				statement = connection.prepareStatement(mailIdQuery);
				statement.setInt(1, patient_id);
				emailIdresult = statement.executeQuery();
				// loop to get email ids from resultset
				while (emailIdresult.next()) {
					String email_id = emailIdresult.getString(1);
					// adding ids to the list
					IdList.add(email_id);
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// Closing resources
			if (Idresult != null) {
				try {
					Idresult.close();
				} catch (Exception e) {
				}
				Idresult = null;
			}

			if (emailIdresult != null) {
				try {
					emailIdresult.close();
				} catch (Exception e) {
				}
				emailIdresult = null;
			}

			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (Exception e) {
				}
				preparedStatement = null;
			}

			if (statement != null) {
				try {
					statement.close();
				} catch (Exception e) {
				}
				statement = null;
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
