/***********************************************************************

	  File Name	            	: MailSimulator.java
	  Principal Author      	: GR_TH3_03
	  Subsystem Name        	:
	  Module Name           	: mail simulator 
	  Date of First Release 	: 10-05-2016
	  Author					: GR_TH3_03
	  Description           	: Class to simulate mailsender functionality for newsletter.


	  Change History

	  Version      		:  1.0
	  Date(DD/MM/YYYY) 	:  10-05-2016
	  Modified by		:  GR_TH3_03
	  Description of change : 

 ***********************************************************************/
package com.aricent.newsletter;

import java.util.ArrayList;
import java.util.Iterator;

import com.aricent.configuration.MailSender;
import com.aricent.pojofiles.AddNewsBean;

/**
 * Class to simulate MailSender functionality.
 * 
 * @see MailSimulator
 * @see MailSimulator#mailCredentials()
 * @version 1.0
 * @author GR_TH3_03
 */
public class MailSimulator {

	private String subject;
	private String mailId;
	private String mailText;

	/**
	 * Method to simulate mail sender
	 * 
	 * @see MailSimulator#mailCredentials()
	 * @param AddNewsBean
	 *            object
	 * @see MailSimulator
	 * @version 1.0
	 * @author GR_TH3_03
	 */
	void mailCredentials(AddNewsBean bean) {
		subject = bean.getSubject();
		// creating instance of MailListCreator
		MailListCreator create = new MailListCreator();
		create.ListCreator();
		// getting id list
		ArrayList<String> mailList = create.getIdList();

		MailTextCreator textcreate = new MailTextCreator();
		textcreate.mailTextCreator(bean);
		// getting mail test
		mailText = textcreate.getMailText();

		// iterator to iterate id list
		Iterator<String> iterator = mailList.iterator();

		while (iterator.hasNext()) {
			mailId = iterator.next();
			MailSender send = new MailSender();
			// sending newsletter
			send.sendEmailMessage(mailId, mailText, subject);
		}
	}
}
