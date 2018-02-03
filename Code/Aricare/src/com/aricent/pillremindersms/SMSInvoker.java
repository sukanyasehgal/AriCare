/***********************************************************************
       
	  File Name	            :     SMSInvoker.java
	  Principal Author      	: GR_TH3_03
	  Subsystem Name        :
	  Module Name           	: SMS Invoker 
	  Date of First Release 	: 10-05-2016
	  Author			:          GR_TH3_03
	  Description           	:  class to invoke the sms sending process


	  Change History

	  Version      		:  1.0
	  Date(DD/MM/YYYY) 	:  10-05-2016
	  Modified by		:  GR_TH3_03
	  Description of change : 

 ***********************************************************************/
package com.aricent.pillremindersms;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * class to invoke the sms sending process.
 * 
 * @see SMSInvoker
 * @see ServletContextListener#contextDestroyed(),contextInitialized()
 * @version 1.0
 * @author GR_TH3_03
 */
public class SMSInvoker implements ServletContextListener {

	private ScheduledExecutorService scheduler;

	/**
	 * Method to shut down scheduler when server shut downs.
	 * 
	 * @see SMSInvoker#contextDestroyed(ServletContextEvent arg0)
	 * @param arg0
	 * @see SMSInvoker
	 * @version 1.0
	 * @author GR_TH3_03
	 */
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

		scheduler.shutdownNow();

	}

	/**
	 * Method to shut down scheduler when server shut downs.
	 * 
	 * @see SMSInvoker#contextDestroyed(ServletContextEvent arg0)
	 * @param arg0
	 * @see SMSInvoker
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

				SMSsimulator send = new SMSsimulator();
				send.smsCredentials();

			}
		}, 1, 1, TimeUnit.MINUTES);

	}

}
