/***********************************************************************
      
	  File Name	            :     CheckList.java
	  Principal Author      	: GR_TH3_03
	  Subsystem Name        :
	  Module Name           	: Check List 
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
 * @see CheckList
 * @see ServletContextListener#contextDestroyed(),contextInitialized()
 * @version 1.0
 * @author GR_TH3_03
 */
public class CheckList implements ServletContextListener {

	private ScheduledExecutorService scheduler;

	/**
	 * Method to shut down scheduler when server shut downs.
	 * 
	 * @see CheckList#contextDestroyed(ServletContextEvent arg0)
	 * @param arg0
	 * @see CheckList
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
	 * @see CheckList#contextInitialized(ServletContextEvent arg0)
	 * @param arg0
	 * @see CheckList
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

				SMSListCreator ListGenerator = new SMSListCreator();
				SMSTextCreator TextGenerator = new SMSTextCreator();
				ListGenerator.patientListCreator();
				TextGenerator.textGenerator(ListGenerator);

				ObjectSetter setter = new ObjectSetter();
				setter.setListCreator(ListGenerator);
				setter.setTextCreator(TextGenerator);
			}
		}, 0, 12, TimeUnit.HOURS);

	}

}
