/***********************************************************************
      
	  File Name	            	: MailTextCreator.java
	  Principal Author      	: GR_TH3_03
	  Subsystem Name        :
	  Module Name           	: mail text creator
	  Date of First Release 	: 10-05-2016
	  Author			:          GR_TH3_03
	  Description           	:  class for the generation of text for initiating
	                               mail services.


	  Change History

	  Version      		:  1.0
	  Date(DD/MM/YYYY) 	:  10-05-2016
	  Modified by		:  GR_TH3_03
	  Description of change : 

 ***********************************************************************/

package com.aricent.idpasswordcommunicator;

import com.aricent.configuration.PasswordGenerator;
import com.aricent.pojofiles.AddDoctorBean;

/**
 * Class for the generation of text for initiating sms services.
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
	 * Method to generate texts for sending id password
	 * 
	 * @see MailTextCreator#mailTextGenerator()
	 * @see MailTextCreator
	 * @version 1.0
	 * @author GR_TH3_03
	 */
	void mailTextCreator(AddDoctorBean bean) {

		PasswordGenerator generate = new PasswordGenerator();
		// generating password using doctor credentials
		generate.generatePassword(bean);
		// getting generated password
		String password = generate.getPassword();
		long Username = bean.getContactNumber();
		// creating mail text
		mailText = "Welcome to AriCare family!" + "\n" + "Your login details :"
				+ "\n" + "Username :" + Username + "\n" + "Password :"
				+ password;
	}
}
