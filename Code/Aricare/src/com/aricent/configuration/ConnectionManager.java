/***********************************************************************
      
	  File Name	            	: ConnectionManager.java
	  Principal Author      	: GR_TH3_03
	  Subsystem Name        	:
	  Module Name           	: connection manager
	  Date of First Release 	: 10-05-2016
	  Author					: GR_TH3_03
	  Description           	: loading database properties and forming a connection with mysql database  

	  Change History

	  Version      		:  1.0
	  Date(DD/MM/YYYY) 	:  10-05-2016
	  Modified by		:  GR_TH3_03
	  Description of change : 

 ***********************************************************************/
package com.aricent.configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * form connection with database
 * 
 * @see ConnectionManager
 * @see ConnectionManager#getConnection()
 * @version 1.0
 * @author GR_TH3_03
 */
public class ConnectionManager {
	// connection variable
	static Connection connection = null;

	/**
	 * loading database properties and forming conection
	 * 
	 * @see getConnection()
	 * @exception SQLException
	 *                ,IOException
	 * @see ConnectionManager
	 * @version initial version
	 * @author GR_TH3_03
	 */
	public static Connection getConnection() {
		try {
			// creating properties class instance
			Properties properties = new Properties();
			// creating inputstream instance for reading the database property
			// file
			InputStream inputStream = new FileInputStream(
					"C:/Users/gur44671/Documents/workspace-sts-3.7.1.RELEASE/Aricare/db.properties");
			// loading properties from the properties file
			properties.load(inputStream);
			// getting storing values from property file
			String driver = properties.getProperty("driver");
			String url = properties.getProperty("url");
			String username = properties.getProperty("username");
			String password = properties.getProperty("password");
			// loading driver class
			Class.forName(driver);
			// establishing connection
			connection = DriverManager.getConnection(url, username, password);

		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}
		// returning connection instance
		return connection;
	}
}
