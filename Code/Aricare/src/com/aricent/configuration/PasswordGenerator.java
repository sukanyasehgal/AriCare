/***********************************************************************
     
	  File Name	            	: PasswordEncryptor.java
	  Principal Author      	: GR_TH3_03
	  Subsystem Name        	:
	  Module Name           	: password generator
	  Date of First Release 	: 10-05-2016
	  Author					: GR_TH3_03
	  Description           	: generate the password with user name and numeric digits combination 

	  Change History

	  Version      		:  1.0
	  Date(DD/MM/YYYY) 	:  10-05-2016
	  Modified by		:  GR_TH3_03
	  Description of change : 

 ***********************************************************************/

package com.aricent.configuration;

import com.aricent.pojofiles.AddDoctorBean;

/**
 * generate password of 8 characters
 * 
 * @see PasswordGenerator
 * @see PasswordGenerator#generatePassword(AddDoctorBean)
 * @version 1.0
 * @author GR_TH3_03
 */
public class PasswordGenerator {

	// variable to store generated password
	private String password;

	// getters and setters
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * generating password from doctor name and different numeric combinations
	 * 
	 * @param adddoctor
	 *            bean object to get doctor name
	 * @see PasswordGenerator
	 * @version initial version
	 * @author GR_TH3_03
	 */
	public void generatePassword(AddDoctorBean bean) {
		// getting doctor name
		String doctor_name = bean.getName();
		// generating and storing password
		password = doctor_name.substring(0, 4) + (int) (Math.random() * 9999);
	}
}
