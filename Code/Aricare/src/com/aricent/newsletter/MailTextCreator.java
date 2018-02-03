/***********************************************************************
             
	  File Name	            	: MailTextCreator.java
	  Principal Author      	: GR_TH3_03
	  Subsystem Name        :
	  Module Name           	: mail text creator
	  Date of First Release 	: 10-05-2016
	  Author			:          GR_TH3_03
	  Description           	:  class for the generation of text for initiating
	                               mail services for newsletter.


	  Change History

	  Version      		:  1.0
	  Date(DD/MM/YYYY) 	:  10-05-2016
	  Modified by		:  GR_TH3_03
	  Description of change : 

 ***********************************************************************/

package com.aricent.newsletter;

import com.aricent.pojofiles.AddNewsBean;

/**
 * Class for the generation of text for initiating mail services.
 * 
 * @see MailTextCreator
 * @see MailTextCreator#textCreator(),setMessageList(ArrayList<String>),
 *      ArrayList<String> getMessageList()
 * @version 1.0
 * @author GR_TH3_03
 */
public class MailTextCreator {

	private String mailText;

	/**
	 * Method to get mail text
	 * 
	 * @see MailTextCreator#getMailTextt()
	 * @return MailText
	 * @see MailTextCreator
	 * @version 1.0
	 * @author GR_TH3_03
	 */
	public String getMailText() {
		return mailText;
	}

	/**
	 * Method to set mail text
	 * 
	 * @see MailTextCreator#setmailText()
	 * @param String
	 *            mailText
	 * @see MailTextCreator
	 * @version 1.0
	 * @author GR_TH3_03
	 */
	public void setMailText(String mailText) {
		this.mailText = mailText;
	}

	/**
	 * Method to generate texts for sending newsletter
	 * 
	 * @see MailTextCreator#mailTextGenerator()
	 * @see MailTextCreator
	 * @version 1.0
	 * @author GR_TH3_03
	 */
	void mailTextCreator(AddNewsBean bean) {
		// getting subject and content of mail
		String subject = bean.getSubject();
		String content = bean.getContent();
		// forming mail text
		mailText = subject + "\n" + content;
	}
}
