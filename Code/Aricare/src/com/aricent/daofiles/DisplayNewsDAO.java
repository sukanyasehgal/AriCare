/***********************************************************************
     
	  File Name	            :     DisplayNewsDAO.java
	  Principal Author      	: GR_TH3_03
	  Subsystem Name        :
	  Module Name           	: Display News 
	  Date of First Release 	: 18-05-2016
	  Author			:          GR_TH3_03
	  Description           	:  class fetching newsletters from database


	  Change History

	  Version      		:  1.0
	  Date(DD/MM/YYYY) 	:  18-05-2016
	  Modified by		:  GR_TH3_03
	  Description of change : 

 ***********************************************************************/
package com.aricent.daofiles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.aricent.configuration.ConnectionManager;
import com.aricent.pojofiles.AddNewsBean;

/**
 * fetching newsletter from database
 * 
 * @see DisplayNewsDAO
 * @see DisplayNewsDAO#displayNews()
 * @version 1.0
 * @author GR_TH3_03
 */
public class DisplayNewsDAO {
	/**
	 * fetches newsletter from database
	 * 
	 * @see displayNews()
	 * @exception SQLException
	 * @see displayNewsDAO
	 * @version initial version
	 * @author GR_TH3_03
	 */
	public List<AddNewsBean> displayNews() {
		// creating log object
		final Logger log = Logger.getLogger(DisplayNewsDAO.class);
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		Connection connection = null;

		List<AddNewsBean> newsList = new ArrayList<>();

		try {// start try
				// establishing connection
			connection = ConnectionManager.getConnection();
			// writing query to fetch newsletter
			preparedStatement = connection
					.prepareStatement("Select * from newsletter");
			// executing query
			result = preparedStatement.executeQuery();
			while (result.next()) {
				// start while loop
				log.info("news fetched from database successfully");
				AddNewsBean news = new AddNewsBean();

				int id = result.getInt(1);
				String subject = result.getString(2);
				String content = result.getString(3);
				news.setId(id);
				news.setContent(content);
				news.setSubject(subject);
				newsList.add(news);
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
		return newsList;
	}

}
