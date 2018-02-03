/***********************************************************************
    
      File Name	            	:	MailSimulator.java
	  Principal Author      	: GR_TH3_03
	  Subsystem Name        	:
	  Module Name           	: mail simulator 
	  Date of First Release 	: 10-05-2016
	  Author					: GR_TH3_03
	  Description           	:  Class to simulate mailsender functionality for id password communicator


	  Change History

	  Version      		:  1.0
	  Date(DD/MM/YYYY) 	:  10-05-2016
	  Modified by		:  GR_TH3_03
	  Description of change : 

 ***********************************************************************/

package com.aricent.idpasswordcommunicator;

import com.aricent.configuration.MailSender;
import com.aricent.pojofiles.AddDoctorBean;

/**
 * Class to simulate MailSender functionality.
 * 
 * @see MailSimulator
 * @see MailSimulator#mailCredentials()
 * @version 1.0
 * @author GR_TH3_03
 */
public class MailSimulator {

	private String subject = "Your account ID and Password";
	private String mailId;
	private String mailText;

	/**
	 * Method to simulate mail sender
	 * 
	 * @see MailSimulator#mailCredentials()
	 * @param AddDoctorBean
	 *            Object
	 * @see MailSimulator
	 * @version 1.0
	 * @author GR_TH3_03
	 */
	void mailCredentials(AddDoctorBean bean) {
		// creating instance of MailListCreator
		MailListCreator create = new MailListCreator();
		create.ListCreator(bean);
		// getting mail id list
		mailId = create.getMailId();

		MailTextCreator textcreate = new MailTextCreator();
		textcreate.mailTextCreator(bean);
		// getting mail text list
		mailText = textcreate.getMailText();

		MailSender send = new MailSender();
		// sending mail
		send.sendEmailMessage(mailId, mailText, subject);

	}
}
