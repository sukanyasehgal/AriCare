/***********************************************************************
        
	  File Name	            	: MailTextCreator.java
	  Principal Author      	: GR_TH3_03
	  Subsystem Name       	 	:
	  Module Name           	: mail text creator 
	  Date of First Release 	: 10-05-2016
	  Author					: GR_TH3_03
	  Description           	:  Class for the generation of text for mail service of pill reminder


	  Change History

	  Version      		:  1.0
	  Date(DD/MM/YYYY) 	:  10-05-2016
	  Modified by		:  GR_TH3_03
	  Description of change : 

 ***********************************************************************/
package com.aricent.pillreminder;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Class for the generation of text for mail service of pill reminder
 * 
 * @see MailTextCreator
 * @see MailTextCreator#getReminderText(),setReminderText(),textGenerator()
 * @version 1.0
 * @author GR_TH3_03
 */
public class MailTextCreator {

	private ArrayList<String> ReminderText = new ArrayList<String>();

	/**
	 * Method to get reminder text
	 * 
	 * @see MailTextCreator#getReminderText()
	 * @return ArrayList<String>
	 * @see MailTextCreator
	 * @version 1.0
	 * @author GR_TH3_03
	 */
	public ArrayList<String> getReminderText() {
		return ReminderText;
	}

	/**
	 * Method to set reminder text
	 * 
	 * @see MailTextCreator#setReminderText()
	 * @param remindertext
	 *            of type ArrayList<String>
	 * @see MailTextCreator
	 * @version 1.0
	 * @author GR_TH3_03
	 */
	public void setReminderText(ArrayList<String> reminderText) {
		ReminderText = reminderText;
	}

	/**
	 * Method to genrate reminder text
	 * 
	 * @see MailTextCreator#textGenerator()
	 * @param argDriver
	 *            of type MailListCreator
	 * @see MailTextCreator
	 * @version 1.0
	 * @author GR_TH3_03
	 */
	void textGenerator(MailListCreator argDriver) {
		Iterator<String> Pilliterator = (argDriver.getPillList()).iterator();

		Iterator<Time> Timeiterator = (argDriver.getTimeList()).iterator();

		while (Timeiterator.hasNext() && Pilliterator.hasNext()) {
			String message = "Please take your " + Pilliterator.next() + " at "
					+ Timeiterator.next();

			ReminderText.add(message);

		}
	}
}
