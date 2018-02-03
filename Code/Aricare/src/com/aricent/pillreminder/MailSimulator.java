/***********************************************************************
          
	  File Name	            	:	MailSimulator.java
	  Principal Author      	: GR_TH3_03
	  Subsystem Name        	:
	  Module Name           	: mail simulator 
	  Date of First Release 	: 10-05-2016
	  Author					: GR_TH3_03
	  Description           	:  Class to simulate mailsender functionality.


	  Change History

	  Version      		:  1.0
	  Date(DD/MM/YYYY) 	:  10-05-2016
	  Modified by		:  GR_TH3_03
	  Description of change : 

 ***********************************************************************/
package com.aricent.pillreminder;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

import com.aricent.configuration.MailSender;

/**
 * Class to simulate MailSender functionality.
 * 
 * @see MailSimulator
 * @see MailSimulator#mailCredentials()
 * @version 1.0
 * @author GR_TH3_03
 */
public class MailSimulator {

	private String subject = "Reminder for your pill";
	private String mailId;
	private String mailtext;
	private Time pillTime;

	/**
	 * Method to simulate mail sender
	 * 
	 * @see MailSimulator#mailCredentials()
	 * @see MailSimulator
	 * @version 1.0
	 * @author GR_TH3_03
	 */
	void mailCredentials() {
		// fetching current date from calendar
		Calendar cal = Calendar.getInstance();
		// formatting date
		SimpleDateFormat formater = new SimpleDateFormat("HH:mm:ss");
		java.util.Date date = new Date();
		cal.setTime(date);
		// incrementing current time by 1
		cal.add(Calendar.HOUR, +1);
		cal.set(Calendar.SECOND, 0);
		String time = formater.format(cal.getTime());
		// getting value of current sql time
		Time Time = java.sql.Time.valueOf(time);

		// object creation for accessing idlist and text list
		ObjectSetter getter = new ObjectSetter();
		MailListCreator ListGenerator = getter.getListCreator();
		MailTextCreator TextGenerator = getter.getTextCreator();
		// getting required maillist,mailtext and time
		ArrayList<String> mailList = ListGenerator.getIdList();
		ArrayList<String> mailText = TextGenerator.getReminderText();
		ArrayList<Time> timeList = ListGenerator.getTimeList();
		// Iterator to go through list
		Iterator<String> Iditerator = mailList.iterator();
		Iterator<String> Textiterator = mailText.iterator();
		Iterator<Time> Timeiterator = (timeList).iterator();

		// loop to iterate the list elements one by one
		while (Iditerator.hasNext() && Textiterator.hasNext()
				&& Timeiterator.hasNext()) {
			pillTime = Timeiterator.next();
			mailId = Iditerator.next();
			mailtext = Textiterator.next();
			// to check pill time with current time
			if (pillTime.compareTo(Time) == 0) {
				// creation of mailsender object
				MailSender send = new MailSender();
				// sending pill reminder
				send.sendEmailMessage(mailId, mailtext, subject);
			}
		}
	}

}
