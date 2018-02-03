/***********************************************************************
      
	  File Name	            :     SMSSimulator.java
	  Principal Author      	: GR_TH3_03
	  Subsystem Name        :
	  Module Name           	: sms simulator 
	  Date of First Release 	: 10-05-2016
	  Author			:          GR_TH3_03
	  Description           	:  Class to simulate messagesender functionality.


	  Change History

	  Version      		:  1.0
	  Date(DD/MM/YYYY) 	:  10-05-2016
	  Modified by		:  GR_TH3_03
	  Description of change : 

 ***********************************************************************/
package com.aricent.appointmentsms;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.log4j.Logger;

import com.aricent.configuration.smsutility;
import com.plivo.helper.exception.PlivoException;


/**
 * Class to simulate messagesender functionality.
 * 
 * @see SMSsimulator
 * @see SMSsimulator#smsCredentials()
 * @version 1.0
 * @author GR_TH3_03
 */
public class SMSsimulator {

	private String smsId;
	private String smstext;
	final Logger log = Logger.getLogger(SMSsimulator.class);
	/**
	 * Method to simulate text message sender
	 * 
	 * @see SMSsimulator#smsCredentials()
	 * @exception PlivoException
	 * @see SMSsimulator
	 * @version 1.0
	 * @author GR_TH3_03
	 */
	void smsCredentials() {
		smslistCreator Id = new smslistCreator();
		Id.ListCreator();

		SmsTextCreator Text = new SmsTextCreator();
		Text.textGenerator();

		ArrayList<String> smsList = Id.getIdList();
		ArrayList<String> smsText = Text.getMessageList();
		Iterator<String> iterator1 = smsList.iterator();
		Iterator<String> iterator2 = smsText.iterator();

		while (iterator1.hasNext() && iterator2.hasNext()) {
			smsId = "+91" + iterator1.next();
			smstext = iterator2.next();

			try {
				smsutility.sendMessageAlert(smsId, smstext);
				log.info("appointment sms sent ");
			} catch (PlivoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}
