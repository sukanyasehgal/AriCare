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

package com.aricent.appointmentreminder;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.apache.log4j.Logger;

/**
 * class to invoke the mail sending process.
 * 
 * @see MailInvoker
 * @see ServletContextListener#contextDestroyed(),contextInitialized()
 * @version 1.0
 * @author GR_TH3_03
 */
public class MailInvoker implements ServletContextListener {

	final Logger log = Logger.getLogger(MailInvoker.class);
	private ScheduledExecutorService scheduler;

	/**
	 * Method to shutdown scheduler when server shutdowns.
	 * 
	 * @see MailInvoker#contextDestroyed(ServletContextEvent arg0)
	 * @param arg0
	 * @see MailInvoker
	 * @version 1.0
	 * @author GR_TH3_03
	 */
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		// scheduler shutdown when server closes
		scheduler.shutdownNow();
	}

	/**
	 * Scheduler invoking mail sending process after 12 hours.
	 * 
	 * @see MailInvoker#contextInitialized(ServletContextEvent arg0)
	 * @param arg0
	 * @see MailInvoker
	 * @version 1.0
	 * @author GR_TH3_03
	 */
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

		scheduler = Executors.newSingleThreadScheduledExecutor();
		scheduler.scheduleAtFixedRate(new Runnable() {

			@Override
			public void run() {
				log.info("Appointment Reminder invoked");
				// creating instance of mail simulator
				MailSimulator send = new MailSimulator();
				// invoking the mail sending function
				send.mailCredentials();

			}
		}, 0, 12, TimeUnit.HOURS);
	}
}
