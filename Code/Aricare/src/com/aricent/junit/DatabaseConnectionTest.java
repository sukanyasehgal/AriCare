/***********************************************************************
         
	  File Name	            :     DatabaseConnectionTest.java
	  Principal Author      	: GR_TH3_03
	  Subsystem Name        :
	  Module Name           	: test Connection with db
	  Date of First Release 	: 23-05-2016
	  Author			:          GR_TH3_03
	  Description           	:  class testing connection with database


	  Change History

	  Version      		:  1.0
	  Date(DD/MM/YYYY) 	:  23-05-2016
	  Modified by		:  GR_TH3_03
	  Description of change : 

***********************************************************************/
package com.aricent.junit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import com.aricent.configuration.ConnectionManager;

/**
 *	testing connection with db
 *	@see DatabaseConnectionTest
 *	@version 1.0
 *	@author GR_TH3_03
 */
public class DatabaseConnectionTest {

	
	private Connection connection;

	@Before
	public void setUp() throws ClassNotFoundException, SQLException {
		//establishing connection with db
		connection = ConnectionManager.getConnection();
	}
	
	//to test whether connection has been established
	@Test
public void testGetConnection() throws SQLException {
		
		assertFalse(connection.isClosed());
	}
	
   //to test whether connection has been closed	
	@Test
	public void testCloseConnection() throws SQLException {
		connection.close();
		assertTrue(connection.isClosed());
	} 
}
