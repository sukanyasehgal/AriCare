/***********************************************************************
      
	  File Name	            	: MailInvoker.java
	  Principal Author      	: GR_TH3_03
	  Subsystem Name        	:
	  Module Name           	: mail invoker 
	  Date of First Release 	: 10-05-2016
	  Author			:          GR_TH3_03
	  Description           	:  class to invoke the mail sending process


	  Change History

	  Version      		:  1.0
	  Date(DD/MM/YYYY) 	:  10-05-2016
	  Modified by		:  GR_TH3_03
	  Description of change : 

 ***********************************************************************/

package com.aricent.idpasswordcommunicator;

import com.aricent.pojofiles.AddDoctorBean;

/**
 * class to invoke the mail sending process.
 * 
 * @see MailInvoker
 * @see ServletContextListener#contextDestroyed(),contextInitialized()
 * @version 1.0
 * @author GR_TH3_03
 */
public class MailInvoker {

	/**
	 * invokes id and password comunicator when doctor is added
	 * 
	 * @see MailInvoker#mailInvoker(AddDoctorBean)
	 * @param AddDoctorbean
	 *            bean
	 * @see MailInvoker
	 * @version 1.0
	 * @author GR_TH3_03
	 */
	public void mailInvoker(AddDoctorBean bean) {
		MailSimulator send = new MailSimulator();
		// sending id password to doctor
		send.mailCredentials(bean);

	}

}