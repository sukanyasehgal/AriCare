/***********************************************************************
    
	  File Name	            :     smsInvoker.java
	  Principal Author      	: GR_TH3_03
	  Subsystem Name        :
	  Module Name           	: sms invoker 
	  Date of First Release 	: 10-05-2016
	  Author			:          GR_TH3_03
	  Description           	:  class to invoke the sms sending process


	  Change History

	  Version      		:  1.0
	  Date(DD/MM/YYYY) 	:  10-05-2016
	  Modified by		:  GR_TH3_03
	  Description of change : 

 ***********************************************************************/
package com.aricent.appointmentsms;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.apache.log4j.Logger;

/**
 * class to invoke the sms sending process.
 * 
 * @see smsInvoker
 * @see ServletContextListener#contextDestroyed(),contextInitialized()
 * @version 1.0
 * @author GR_TH3_03
 */
public class smsInvoker implements ServletContextListener {
	private ScheduledExecutorService scheduler;
	final Logger log = Logger.getLogger(smsInvoker.class);

	/**
	 * Method to shutdown scheduler when server shutdowns.
	 * 
	 * @see smsInvoker#contextDestroyed(ServletContextEvent arg0)
	 * @param arg0
	 * @see smsInvoker
	 * @version 1.0
	 * @author GR_TH3_03
	 */
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		scheduler.shutdownNow();
	}

	/**
	 * Scheduler invoking sms sending process after 12 hours.
	 * 
	 * @see smsInvoker#contextInitialized(ServletContextEvent arg0)
	 * @param arg0
	 * @see smsInvoker
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
				log.info("appointment reminder sms invoked");
				SMSsimulator send = new SMSsimulator();
				send.smsCredentials();

			}
		}, 0, 12, TimeUnit.HOURS);
	}
}
