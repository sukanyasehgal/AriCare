/***********************************************************************
       
	  File Name	            :     PatientList.java
	  Principal Author      	: GR_TH3_03
	  Subsystem Name        :
	  Module Name           	: Patient List 
	  Date of First Release 	: 10-05-2016
	  Author			:          GR_TH3_03
	  Description           	:  class to invoke the sms sending process


	  Change History

	  Version      		:  1.0
	  Date(DD/MM/YYYY) 	:  10-05-2016
	  Modified by		:  GR_TH3_03
	  Description of change : 

 ***********************************************************************/
package com.aricent.pillremindersms;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

import com.aricent.configuration.ConnectionManager;

/**
 * class to invoke the sms sending process.
 * 
 * @see SMSListCreator
 * @see PatientList#getReminderText(),setReminderText(),getPillList(),
 *      setPillList(),getIdList(),setIdList(),getTimeList(),
 *      setTimeList(),patientListCreator(),textGenerator()
 * @version 1.0
 * @author GR_TH3_03
 */
public class SMSListCreator {

	private ArrayList<String> IdList = new ArrayList<String>();
	private ArrayList<String> PillList = new ArrayList<String>();
	private ArrayList<Time> TimeList = new ArrayList<Time>();
	private ArrayList<String> ReminderText = new ArrayList<String>();

	/**
	 * Method to shut down scheduler when server shut downs.
	 * 
	 * @see SMSListCreator#getReminderText()
	 * @return ReminderText of type ArrayList<String>
	 * @see SMSListCreator
	 * @version 1.0
	 * @author GR_TH3_03
	 */
	public ArrayList<String> getReminderText() {
		return ReminderText;
	}

	/**
	 * Method to shut down scheduler when server shut downs.
	 * 
	 * @see SMSListCreator#setReminderText
	 * @param reminderText
	 *            of type ArrayList<String>
	 * @see SMSListCreator
	 * @version 1.0
	 * @author GR_TH3_03
	 */
	public void setReminderText(ArrayList<String> reminderText) {
		ReminderText = reminderText;
	}

	/**
	 * Method to shut down scheduler when server shut downs.
	 * 
	 * @see SMSListCreator#getPillList
	 * @return PillList of type ArrayList<String>
	 * @see SMSListCreator
	 * @version 1.0
	 * @author GR_TH3_03
	 */
	public ArrayList<String> getPillList() {
		return PillList;
	}

	/**
	 * Method to shut down scheduler when server shut downs.
	 * 
	 * @see SMSListCreator#setPillList
	 * @param pillList
	 *            of type ArrayList<String>
	 * @see SMSListCreator
	 * @version 1.0
	 * @author GR_TH3_03
	 */
	public void setPillList(ArrayList<String> pillList) {
		PillList = pillList;
	}

	/**
	 * Method to shut down scheduler when server shut downs.
	 * 
	 * @see SMSListCreator#getIdList
	 * @return IdList of type ArrayList<String>
	 * @see SMSListCreator
	 * @version 1.0
	 * @author GR_TH3_03
	 */
	public ArrayList<String> getIdList() {
		return IdList;
	}

	/**
	 * Method to shut down scheduler when server shut downs.
	 * 
	 * @see SMSListCreator#setIdList
	 * @param idList
	 *            of type ArrayList<String>
	 * @see SMSListCreator
	 * @version 1.0
	 * @author GR_TH3_03
	 */
	public void setIdList(ArrayList<String> idList) {
		IdList = idList;
	}

	/**
	 * Method to shut down scheduler when server shut downs.
	 * 
	 * @see SMSListCreator#getTimeList
	 * @param TimeList
	 *            of type ArrayList<Time>
	 * @see SMSListCreator
	 * @version 1.0
	 * @author GR_TH3_03
	 */
	public ArrayList<Time> getTimeList() {
		return TimeList;
	}

	/**
	 * Method to shut down scheduler when server shut downs.
	 * 
	 * @see SMSListCreator#setTimeList
	 * @param timeList
	 *            of type ArrayList<Time>
	 * @see SMSListCreator
	 * @version 1.0
	 * @author GR_TH3_03
	 */
	public void setTimeList(ArrayList<Time> timeList) {
		TimeList = timeList;
	}

	Connection connection = null;
	ResultSet Idresult = null;
	ResultSet phone_Idresult = null;
	PreparedStatement preparedStatement = null;
	PreparedStatement statement = null;

	/**
	 * Method to shut down scheduler when server shut downs.
	 * 
	 * @see SMSListCreator#patientListCreator
	 * @see SMSListCreator
	 * @version 1.0
	 * @author GR_TH3_03
	 */
	void patientListCreator() {
		Calendar cal = Calendar.getInstance();
		Date currentDate = new java.sql.Date(cal.getTimeInMillis());
		connection = ConnectionManager.getConnection();

		try {

			String IdQuery = " select patient_id,pill_name,dosage_time from pill_details where end_date >= ?";
			preparedStatement = connection.prepareStatement(IdQuery);
			preparedStatement.setDate(1, currentDate);
			Idresult = preparedStatement.executeQuery();

			while (Idresult.next()) {
				int patient_id = Idresult.getInt("patient_id");

				String pill_name = Idresult.getString(2);
				PillList.add(pill_name);

				Time time = Idresult.getTime(3);
				TimeList.add(time);

				String mailIdQuery = " select phone_number from patient_profile where patient_id = ?";
				statement = connection.prepareStatement(mailIdQuery);
				statement.setInt(1, patient_id);
				phone_Idresult = statement.executeQuery();

				while (phone_Idresult.next()) {
					String phone_number = phone_Idresult.getString(1);
					IdList.add(phone_number);
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (Idresult != null) {
				try {
					Idresult.close();
				} catch (Exception e) {
				}
				Idresult = null;
			}

			if (phone_Idresult != null) {
				try {
					phone_Idresult.close();
				} catch (Exception e) {
				}
				phone_Idresult = null;
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

	/**
	 * Method to shut down scheduler when server shut downs.
	 * 
	 * @see SMSListCreator#textGenerator
	 * @see SMSListCreator
	 * @version 1.0
	 * @author GR_TH3_03
	 */
	void textGenerator() {

		Iterator<String> Pilliterator = PillList.iterator();

		Iterator<Time> Timeiterator = TimeList.iterator();

		while (Timeiterator.hasNext() && Pilliterator.hasNext()) {
			String message = "Plaese take your" + Pilliterator.next() + "at "
					+ Timeiterator.next();

			ReminderText.add(message);

		}
	}

}
