/***********************************************************************
     
	  File Name	            	: MailListCreator.java
	  Principal Author      	: GR_TH3_03
	  Subsystem Name       	 	:
	  Module Name           	: mail list creator 
	  Date of First Release 	: 10-05-2016
	  Author					: GR_TH3_03
	  Description           	:  class for generation of recipient id list for 
	  							   initiation of mail services


	  Change History

	  Version      		:  1.0
	  Date(DD/MM/YYYY) 	:  10-05-2016
	  Modified by		:  GR_TH3_03
	  Description of change : 

 ***********************************************************************/

package com.aricent.idpasswordcommunicator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.aricent.configuration.ConnectionManager;
import com.aricent.pojofiles.AddDoctorBean;

/**
 * Class for the generation of list for initiating mail services.
 * 
 * @see MailListCreator
 * @see MailListCreator#getIdList(),setIdList(),ListCreator()
 * @version 1.0
 * @author GR_TH3_03
 */
public class MailListCreator {

	private String mailId;

	/**
	 * Method to get email id
	 * 
	 * @see MailListCreatorr#getMailId()
	 * @see MailListCreator
	 * @version 1.0
	 * @author GR_TH3_03
	 */
	public String getMailId() {
		return mailId;
	}

	/**
	 * Method to set email id
	 * 
	 * @see MailListCreatorr#setmailId(String id)
	 * @param idList
	 * @see MailListCreator
	 * @version 1.0
	 * @author GR_TH3_03
	 */
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	Connection connection = null;
	ResultSet result = null;
	PreparedStatement preparedStatement = null;
	PreparedStatement statement = null;

	/**
	 * Method to generate list of doctor
	 * 
	 * @see MailListCreator#ListCreator()
	 * @param AddDoctorBean
	 *            object
	 * @see MailListCreator
	 * @version 1.0
	 * @author GR_TH3_03
	 */
	public void ListCreator(AddDoctorBean bean) {
		// getting phone number of doctor
		long phone_number = bean.getContactNumber();

		try {
			// establishing connection
			connection = ConnectionManager.getConnection();
			// query to be executed
			String Query = "select email_id from doctor_profile where phone_number=?";
			preparedStatement = connection.prepareStatement(Query);
			preparedStatement.setLong(1, phone_number);
			result = preparedStatement.executeQuery();
			// while loop starts
			while (result.next()) {
				// getting email id of doctor to whom mail to be sent
				String email_id = result.getString(1);
				// setting mail id
				setMailId(email_id);
			}// while loop ends
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// closing resources
			if (result != null) {
				try {
					result.close();
				} catch (Exception e) {
				}
				result = null;
			}

			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (Exception e) {
				}
				preparedStatement = null;
			}

			if (connection != null) {
				try {
					connection.close();
				} catch (Exception e) {
					connection = null;
				}
			}
		}// finally block ends
	}

}
