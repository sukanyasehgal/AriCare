/***********************************************************************
     
	  File Name	            :     ObjectSetter.java
	  Principal Author      	: GR_TH3_03
	  Subsystem Name        :
	  Module Name           	: Object Setter 
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

/**
 * class to invoke the sms sending process.
 * 
 * @see ObjectSetter
 * @see ServletContextListener#contextDestroyed(),contextInitialized()
 * @version 1.0
 * @author GR_TH3_03
 */
public class ObjectSetter {

	static SMSListCreator ListCreator;
	static SMSTextCreator TextCreator;

	/**
	 * Method to shut down scheduler when server shut downs.
	 * 
	 * @see ObjectSetter#contextDestroyed(ServletContextEvent arg0)
	 * @param arg0
	 * @see ObjectSetter
	 * @version 1.0
	 * @author GR_TH3_03
	 */
	public SMSListCreator getListCreator() {
		return ListCreator;
	}

	/**
	 * Method to shut down scheduler when server shut downs.
	 * 
	 * @see ObjectSetter#contextDestroyed(ServletContextEvent arg0)
	 * @param arg0
	 * @see ObjectSetter
	 * @version 1.0
	 * @author GR_TH3_03
	 */
	public void setListCreator(SMSListCreator listCreator) {
		ListCreator = listCreator;
	}

	/**
	 * Method to shut down scheduler when server shut downs.
	 * 
	 * @see ObjectSetter#contextDestroyed(ServletContextEvent arg0)
	 * @param arg0
	 * @see ObjectSetter
	 * @version 1.0
	 * @author GR_TH3_03
	 */
	public SMSTextCreator getTextCreator() {
		return TextCreator;
	}

	/**
	 * Method to shut down scheduler when server shut downs.
	 * 
	 * @see ObjectSetter#contextDestroyed(ServletContextEvent arg0)
	 * @param arg0
	 * @see ObjectSetter
	 * @version 1.0
	 * @author GR_TH3_03
	 */
	public void setTextCreator(SMSTextCreator textCreator) {
		TextCreator = textCreator;
	}

}
