/***********************************************************************
     
	  File Name	            :     smsutility.java
	  Principal Author      	: GR_TH3_03
	  Subsystem Name        :
	  Module Name           	: sms utility 
	  Date of First Release 	: 10-05-2016
	  Author			:          GR_TH3_03
	  Description           	:  SMS Service implementation class smsutility


	  Change History

	  Version      		:  1.0
	  Date(DD/MM/YYYY) 	:  10-05-2016
	  Modified by		:  GR_TH3_03
	  Description of change : 

 ***********************************************************************/
package com.aricent.configuration;

import java.util.LinkedHashMap;
import com.plivo.helper.api.client.RestAPI;
import com.plivo.helper.api.response.message.MessageResponse;
import com.plivo.helper.exception.PlivoException;

/**
 * SMS Service implementation class smsutility
 * 
 * @see smsutility
 * @see smsutility#sendMessageAlert()
 * @version 1.0
 * @author GR_TH3_03
 */
public class smsutility {
	/**
	 * @see smsutility#sendMessageAlert(String toNumber, String msg)
	 * @exception PlivoException
	 * @see smsutility
	 * @version 1.0
	 * @author GR_TH3_03
	 */
	public static void sendMessageAlert(String toNumber, String msg)
			throws PlivoException {
		// initialization of the authentication variables provided by our pvilo
		// account
		String authId = "MAMGJKZTM4MWZHZWFMOW";
		String authToken = "MGU3OWVhM2RjNWVhMDEyMWNiYmRjYTVjZDg3YTA2";
		// Creation of api object and invocation of RestAPI constructor by
		// sending the authentication values as parameters
		RestAPI api = new RestAPI(authId, authToken, "v1");

		// Creation of a linkedhashmap parameters
		LinkedHashMap<String, String> parameters = new LinkedHashMap<String, String>();

		// putting key value pairs in linkedHashmap
		parameters.put("src", "+14154847489"); // Sender's phone number with
												// country code
		parameters.put("dst", toNumber); // toNumber contains Receiver's phone
											// number with country code
		parameters.put("text", msg); // msg contains the SMS text message to be
										// sent

		parameters.put("url", "http://example.com/report/"); // The URL to which
																// with the
																// status of the
																// message is
																// sent
		parameters.put("method", "GET"); // The method used to call the url

		// Send the message
		MessageResponse msgResponse = api.sendMessage(parameters);

		if (msgResponse.serverCode == 202) {
			// Print the Message UUID
			System.out.println("Message UUID : "
					+ msgResponse.messageUuids.get(0).toString());
		} else {
			System.out.println(msgResponse.error);
		}
	}
}