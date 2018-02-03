/***********************************************************************
     
	  File Name	            :     SMSsimulator.java
	  Principal Author      	: GR_TH3_03
	  Subsystem Name        :
	  Module Name           	: SMS simulator 
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

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

import com.aricent.configuration.smsutility;
import com.plivo.helper.exception.PlivoException;

/**
 * class to invoke the sms sending process.
 * 
 * @see SMSsimulator
 * @see SMSsimulator#smsCredentials()
 * @version 1.0
 * @author GR_TH3_03
 */
public class SMSsimulator {

	private String smsId;
	private String smstext;
	private Time pillTime;

	/**
	 * Method to shut down scheduler when server shut downs.
	 * 
	 * @see SMSsimulator#smsCredentials
	 * @see SMSsimulator
	 * @version 1.0
	 * @author GR_TH3_03
	 */
	void smsCredentials() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("HH:mm:ss");
		java.util.Date date = new Date();
		cal.setTime(date);
		cal.add(Calendar.HOUR, +1);
		cal.set(Calendar.SECOND, 0);
		String time = formater.format(cal.getTime());
		Time currentTime = java.sql.Time.valueOf(time);

		ObjectSetter getter = new ObjectSetter();
		SMSListCreator ListGenerator = getter.getListCreator();
		SMSTextCreator TextGenerator = getter.getTextCreator();

		ArrayList<String> smsList = ListGenerator.getIdList();
		ArrayList<String> smsText = TextGenerator.getReminderText();
		ArrayList<Time> timeList = ListGenerator.getTimeList();

		Iterator<String> Iditerator = smsList.iterator();
		Iterator<String> Textiterator = smsText.iterator();
		Iterator<Time> Timeiterator = (timeList).iterator();

		while (Iditerator.hasNext() && Textiterator.hasNext()
				&& Timeiterator.hasNext()) {
			pillTime = Timeiterator.next();
			smsId = "+91" + Iditerator.next();
			smstext = Textiterator.next();

			if (pillTime.compareTo(currentTime) == 0) {
				try {
					smsutility.sendMessageAlert(smsId, smstext);
				} catch (PlivoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
