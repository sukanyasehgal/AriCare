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

package com.aricent.appointmentreminder;

import java.util.ArrayList;
import java.util.Iterator;
import org.apache.log4j.Logger;

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

	private String subject = "Reminder for your Appointment";
	private String mailId;
	private String mailtext;
	final Logger log = Logger.getLogger(MailSimulator.class);

	/**
	 * Method to simulate mail sender
	 * 
	 * @see MailSimulator#mailCredentials()
	 * @see MailSimulator
	 * @version 1.0
	 * @author GR_TH3_03
	 */
	void mailCredentials() {
		// creating instance of MailListCreator
		MailListCreator Id = new MailListCreator();
		Id.ListCreator();

		// creating instance of MailtextCreator
		MailTextCreator Text = new MailTextCreator();
		Text.textGenerator();

		// getting id list
		ArrayList<String> mailList = Id.getIdList();
		// getting mailtext list
		ArrayList<String> mailText = Text.getMessageList();

		// iterators to iterate both lists
		Iterator<String> iterator1 = mailList.iterator();
		Iterator<String> iterator2 = mailText.iterator();

		// while loop starts
		while (iterator1.hasNext() && iterator2.hasNext()) {
			// iterating list one by one
			mailId = iterator1.next();
			mailtext = iterator2.next();

			MailSender send = new MailSender();
			// sending mail
			send.sendEmailMessage(mailId, mailtext, subject);
			log.info("Appointment reminder mail sent");

		}// while loop ends
	}
}
