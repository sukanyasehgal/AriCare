/***********************************************************************
   
	  File Name	            	: MailSender.java
	  Principal Author      	: GR_TH3_03
	  Subsystem Name        	:
	  Module Name           	: Mail sender
	  Date of First Release 	: 10-05-2016
	  Author					: GR_TH3_03
	  Description           	: sending the mail through smtp protocol  

	  Change History

	  Version      		:  1.0
	  Date(DD/MM/YYYY) 	:  10-05-2016
	  Modified by		:  GR_TH3_03
	  Description of change : 

 ***********************************************************************/

package com.aricent.configuration;

import java.sql.SQLException;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * sending mail
 * 
 * @see MailSender
 * @see MailSender#getPropertiesForMailer(),getSessionObject(),
 *      sendEmailMessage(String,String,String),sendMail(MimeMessage)
 * @version 1.0
 * @author GR_TH3_03
 */
public class MailSender {

	private final static String senderEmailID = "aricarehospital@gmail.com"; // the
																				// admin's
																				// email
																				// id
	private final static String password = "aricare11";// admin mail password
	private final static String host = "smtp.gmail.com";// smtp host id

	/**
	 * returning properties object after setting the required properties
	 * 
	 * @see getConnection()
	 * @return properties object after setting the required properties
	 * @exception SQLException
	 *                ,IOException
	 * @see ConnectionManager
	 * @version initial version
	 * @author GR_TH3_03
	 */
	private static Properties getPropertiesForMailer() {

		Properties properties = new Properties();
		properties.put("mail.smtp.host", host);
		properties.put("mail.transport.protocol", "smtp");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.user", senderEmailID);
		properties.put("mail.password", password);
		properties.put("mail.port", "587");

		return properties;
	}

	/**
	 * creating mail session
	 * 
	 * @see getSessionObject()
	 * @param session
	 *            object after sucessful authentication
	 * @see MailSender
	 * @version initial version
	 * @author GR_TH3_03
	 */
	public static Session getSessionObject() {

		Properties properties = getPropertiesForMailer();
		Session session = Session.getDefaultInstance(properties,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(senderEmailID,
								password);// change accordingly
					}
				});

		return session;
	}

	/**
	 * setting mime message values and passing to the sendMail function
	 * 
	 * @exception MessagingException
	 * @param mailId
	 *            -email id of recipient ,mailText-body of the
	 *            mail,subject-subject of the mail
	 * @see MailSender
	 * @version initial version
	 * @author GR_TH3_03
	 */
	public void sendEmailMessage(String mailId, String mailText, String subject) {

		try {
			// getting session object
			Session session = getSessionObject();
			// establishing mime message instance
			MimeMessage message = new MimeMessage(session);
			// seting sender address
			message.setFrom(new InternetAddress(senderEmailID));
			// seting email subject
			message.setSubject(subject);
			// seting recipient address
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(
					mailId));
			// seting email body
			message.setText(mailText);
			// saving changes
			message.saveChanges();
			// passing mime message to mail sending function
			sendMail(message);

		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	/**
	 * sends mail
	 * 
	 * @exception MessagingException
	 * @param argMessage
	 *            - mime message will all required email details
	 * @see MailSender
	 * @version initial version
	 * @author GR_TH3_03
	 */
	private void sendMail(MimeMessage argMessage) {
		try {

			Transport.send(argMessage);

		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
