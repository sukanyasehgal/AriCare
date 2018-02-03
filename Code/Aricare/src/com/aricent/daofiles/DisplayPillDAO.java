/***********************************************************************
      
	  File Name	            :     DisplayPillDAO.java
	  Principal Author      	: GR_TH3_03
	  Subsystem Name        :
	  Module Name           	: Display Pill details 
	  Date of First Release 	: 18-05-2016
	  Author			:          GR_TH3_03
	  Description           	:  class fetching pill details from database


	  Change History

	  Version      		:  1.0
	  Date(DD/MM/YYYY) 	:  18-05-2016
	  Modified by		:  GR_TH3_03
	  Description of change : 

 ***********************************************************************/
package com.aricent.daofiles;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.aricent.configuration.ConnectionManager;
import com.aricent.daointerfaces.DisplayPillInterface;
import com.aricent.pojofiles.LoginBean;
import com.aricent.pojofiles.PillDetailBean;

/**
 * fetching pill details from database
 * 
 * @see DisplayPillDAO
 * @see DisplayPillDAO#displayPillDetails()
 * @version 1.0
 * @author GR_TH3_03
 */
public class DisplayPillDAO implements DisplayPillInterface {
	/**
	 * fetches pill details from database
	 * 
	 * @see displayPillDetails()
	 * @param LoginBean
	 *            user
	 * @exception SQLException
	 * @see displaypillDAO
	 * @version initial version
	 * @author GR_TH3_03
	 */
	public List<PillDetailBean> displayPillDetails(LoginBean user) {
		// creating log object
		final Logger log = Logger.getLogger(DisplayPillDAO.class);
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		Connection connection = null;

		List<PillDetailBean> pillList = new ArrayList<PillDetailBean>();

		try {// start try
				// establishing connection
			connection = ConnectionManager.getConnection();
			long phone_number = user.getPhone_number();
			// writing query to fetch pill details
			preparedStatement = connection
					.prepareStatement("Select * from pill_details where patient_id = (select patient_id from patient_profile where phone_number=?)");
			preparedStatement.setLong(1, phone_number);
			// executing query
			result = preparedStatement.executeQuery();
			while (result.next()) {// start while loop
				PillDetailBean pill = new PillDetailBean();

				String pill_name = result.getString(4);
				Date start_date = result.getDate(5);
				Date end_date = result.getDate(6);
				Time dosage_time = result.getTime(7);
				int dosage = result.getInt(8);

				pill.setPill_name(pill_name);
				pill.setStart_date(start_date);
				pill.setEnd_date(end_date);
				pill.setDosage_time(dosage_time);
				pill.setDosage(dosage);

				pillList.add(pill);
				log.info("pill details are fetched from database successfully");
			}// end while loop
		}// end try
		catch (Exception ex) {

			ex.printStackTrace();
			log.error(ex.getMessage());
		}

		finally {
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
				}

				connection = null;
			}
		}
		return pillList;
	}
}
