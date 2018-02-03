/***********************************************************************
      
	  File Name	            :     AddNewsDAO.java
	  Principal Author      	: GR_TH3_03
	  Subsystem Name        :
	  Module Name           	: add news 
	  Date of First Release 	: 13-05-2016
	  Author			:          GR_TH3_03
	  Description           	:  class adding newsLetter into database


	  Change History

	  Version      		:  1.0
	  Date(DD/MM/YYYY) 	:  13-05-2016
	  Modified by		:  GR_TH3_03
	  Description of change : 

 ***********************************************************************/
package com.aricent.daofiles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.aricent.configuration.ConnectionManager;
import com.aricent.daointerfaces.AddNewsInterface;
import com.aricent.pojofiles.AddNewsBean;

/**
 * adds newsLetter into database
 * 
 * @see AddNewsDAO
 * @see addNewsDAO#checkFordatabase(),addNewsLetter()
 * @version 1.0
 * @author GR_TH3_03
 */
public class AddNewsDAO implements AddNewsInterface {

	Connection connection = null;
	PreparedStatement preparedStatement = null;

	/**
	 * @see addNewsLetter()
	 * @param AddNewsBean
	 *            beanObject
	 * @exception SQLException
	 * @see AddNewsDAO
	 * @version initial version
	 * @author GR_TH3_03
	 */
	public void addNewsLetter(AddNewsBean beanObject) {
		// establishing connection
		connection = ConnectionManager.getConnection();

		try {// start try

			// storing query into string variable
			String query = "insert into newsletter(subject,content)values(?,?)";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, beanObject.getSubject());
			preparedStatement.setString(2, beanObject.getContent());
			// executing query
			int i = preparedStatement.executeUpdate();
			// if any row is affected set valid to true else false
			if (i == 0)
				beanObject.setValid(false);
			else {

				beanObject.setValid(true);
			}

			preparedStatement.close();
			connection.close();
		}// end try
		catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
