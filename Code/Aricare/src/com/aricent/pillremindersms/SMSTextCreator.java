/***********************************************************************
     
	  File Name	            :     ReminderText.java
	  Principal Author      	: GR_TH3_03
	  Subsystem Name        :
	  Module Name           	: Reminder Text 
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

import java.sql.Time;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * class to invoke the sms sending process.
 * 
 * @see SMSTextCreator
 * @see ReminderText#getReminderText(),setReminderText(),textGenerator()
 * @version 1.0
 * @author GR_TH3_03
 */
public class SMSTextCreator {

	private ArrayList<String> ReminderText = new ArrayList<String>();

	/**
	 * Method to shut down scheduler when server shut downs.
	 * 
	 * @see SMSTextCreator#getReminderText
	 * @return ReminderText of type ArrayList<String>
	 * @see SMSTextCreator
	 * @version 1.0
	 * @author GR_TH3_03
	 */
	public ArrayList<String> getReminderText() {
		return ReminderText;
	}

	/**
	 * Method to shut down scheduler when server shut downs.
	 * 
	 * @see SMSTextCreator#setReminderText
	 * @param reminderText
	 *            of type ArrayList<String>
	 * @see SMSTextCreator
	 * @version 1.0
	 * @author GR_TH3_03
	 */
	public void setReminderText(ArrayList<String> reminderText) {
		ReminderText = reminderText;
	}

	/**
	 * Method to shut down scheduler when server shut downs.
	 * 
	 * @see SMSTextCreator#textGenerator
	 * @param argDriver
	 *            of type PatientList
	 * @see SMSTextCreator
	 * @version 1.0
	 * @author GR_TH3_03
	 */
	void textGenerator(SMSListCreator argDriver) {

		Iterator<String> Pilliterator = (argDriver.getPillList()).iterator();

		Iterator<Time> Timeiterator = (argDriver.getTimeList()).iterator();

		while (Timeiterator.hasNext() && Pilliterator.hasNext()) {
			String message = "Please take your " + Pilliterator.next() + " at "
					+ Timeiterator.next();

			ReminderText.add(message);

		}
	}
}
