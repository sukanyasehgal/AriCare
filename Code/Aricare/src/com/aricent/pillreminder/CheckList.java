/***********************************************************************
         
	  File Name	            	: CheckList.java
	  Principal Author      	: GR_TH3_03
	  Subsystem Name        	:
	  Module Name           	: check list 
	  Date of First Release 	: 10-05-2016
	  Author			:          GR_TH3_03
	  Description           	:  class to invoke the mailtext and maillist generation process for pill reminder


	  Change History

	  Version      		:  1.0
	  Date(DD/MM/YYYY) 	:  10-05-2016
	  Modified by		:  GR_TH3_03
	  Description of change : 

 ***********************************************************************/
package com.aricent.pillreminder;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * class to invoke the mailtext and maillist generation process for pill
 * reminder
 * 
 * @see CheckList
 * @see ServletContextListener#contextDestroyed(),contextInitialized()
 * @version 1.0
 * @author GR_TH3_03
 */
public class CheckList implements ServletContextListener {

	private ScheduledExecutorService scheduler;

	/**
	 * Method to shutdown scheduler when server shutdowns.
	 * 
	 * @see CheckList#contextDestroyed(ServletContextEvent arg0)
	 * @param arg0
	 * @see CheckList
	 * @version 1.0
	 * @author GR_TH3_03
	 */
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// shutting down scheduler when server closes
		scheduler.shutdownNow();

	}

	/**
	 * Scheduler invoking mail sending process after 12 hours.
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

		// scheduler thread executor
		scheduler = Executors.newSingleThreadScheduledExecutor();
		scheduler.scheduleAtFixedRate(new Runnable() {

			@Override
			public void run() {

				MailListCreator ListGenerator = new MailListCreator();
				MailTextCreator TextGenerator = new MailTextCreator();
				// Creating Patient List
				ListGenerator.patientListCreator();
				// Creating Mail Text List
				TextGenerator.textGenerator(ListGenerator);

				// setting objects for maillist and textcontent
				ObjectSetter setter = new ObjectSetter();
				setter.setListCreator(ListGenerator);
				setter.setTextCreator(TextGenerator);
			}
		}, 0, 12, TimeUnit.HOURS);

	}

}
