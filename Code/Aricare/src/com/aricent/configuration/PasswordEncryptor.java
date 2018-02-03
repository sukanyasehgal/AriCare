/***********************************************************************
      
	  File Name	            	: PasswordEncryptor.java
	  Principal Author      	: GR_TH3_03
	  Subsystem Name        	:
	  Module Name           	: password encryptor
	  Date of First Release 	: 10-05-2016
	  Author					: GR_TH3_03
	  Description           	: encrypting the password  

	  Change History

	  Version      		:  1.0
	  Date(DD/MM/YYYY) 	:  10-05-2016
	  Modified by		:  GR_TH3_03
	  Description of change : 

 ***********************************************************************/

package com.aricent.configuration;

import org.mindrot.jbcrypt.BCrypt;

/**
 * encrypting password
 * 
 * @see PasswordEncryptor
 * @see PasswordEncryptor#encryptPassword(String),matchPassword(String,String)
 * @version 1.0
 * @author GR_TH3_03
 */
public class PasswordEncryptor {

	/**
	 * returning the encrypted password
	 * 
	 * @return encryted password
	 * @see PasswordEncryptor
	 * @version initial version
	 * @author GR_TH3_03
	 */
	public String encryptPassword(String password) {
		String encryptedString = BCrypt.hashpw(password, BCrypt.gensalt());
		return encryptedString;
	}

	/**
	 * match the normal password and encrypted password
	 * 
	 * @return status- boolean value to depict that password matches or not
	 * @see PasswordEncryptor
	 * @version initial version
	 * @author GR_TH3_03
	 */
	public boolean matchPassword(String orignalPassword, String encryptPassword) {
		boolean status = BCrypt.checkpw(orignalPassword, encryptPassword);
		return status;
	}
}
