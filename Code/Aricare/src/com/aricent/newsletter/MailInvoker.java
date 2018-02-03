/***********************************************************************
           
	  File Name	            	: MailInvoker.java
	  Principal Author      	: GR_TH3_03
	  Subsystem Name        	:
	  Module Name           	: mail invoker 
	  Date of First Release 	: 10-05-2016
	  Author			:          GR_TH3_03
	  Description           	:  class to invoke the mail sending process for news letter


	  Change History

	  Version      		:  1.0
	  Date(DD/MM/YYYY) 	:  10-05-2016
	  Modified by		:  GR_TH3_03
	  Description of change : 

 ***********************************************************************/

package com.aricent.newsletter;

import com.aricent.pojofiles.AddDoctorBean;
import com.aricent.pojofiles.AddNewsBean;

/**
 * class to invoke the mail sending process when admin adds news letter
 * 
 * @see MailInvoker
 * @see ServletContextListener#contextDestroyed(),contextInitialized()
 * @version 1.0
 * @author GR_TH3_03
 */
public class MailInvoker {

	/**
	 * invokes newsletter when news is added by admin
	 * 
	 * @see MailInvoker#mailInvoker(AddDoctorBean)
	 * @param AddDoctorbean
	 *            bean
	 * @see MailInvoker
	 * @version 1.0
	 * @author GR_TH3_03
	 */
	public void invokeNewsletter(AddNewsBean bean) {
		MailSimulator send = new MailSimulator();
		// sending newsletter
		send.mailCredentials(bean);
	}
}
