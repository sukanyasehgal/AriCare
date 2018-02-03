/***********************************************************************
     
	  File Name	            :     LoginBean.java
	  Principal Author      	: GR_TH3_03
	  Subsystem Name        :
	  Module Name           	: Login 
	  Date of First Release 	: 12-05-2016
	  Author			:          GR_TH3_03
	  Description           	:  class containing all getters and setters


	  Change History

	  Version      		:  1.0
	  Date(DD/MM/YYYY) 	:  12-05-2016
	  Modified by		:  GR_TH3_03
	  Description of change : 

***********************************************************************/
package com.aricent.pojofiles;

/**
 *	containing getters and setters
 *	@see LoginBean
 *	@see LoginBean#setphone_number(),getphone_number(),setpassword(),getpassword(),setvalid(),isValid()
 *	@version 1.0
 *	@author GR_TH3_03
 */
public class LoginBean {

	//declaring variables required for login process
	private long phone_number;
	private String password;
	public boolean isValid;
	

	/**
	 * getting phone_number
	 *    @return phone_number
	 *    @see LoginBean
	 *	@version initial version
	 *	@author GR_TH3_03
	 */
	public long getPhone_number() {
		return phone_number;
	}
	/**
	 * setting phone_number
	 * @param phone_number
	 *    @see LoginBean
	 *	@version initial version
	 *	@author GR_TH3_03
	 */
	public void setPhone_number(long phone_number) {
		this.phone_number = phone_number;
	}
	/**
	 * getting password
	 *    @return password
	 *    @see LoginBean
	 *	@version initial version
	 *	@author GR_TH3_03
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * setting password
	 * @param password
	 *    @see LoginBean
	 *	@version initial version
	 *	@author GR_TH3_03
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * getting valid
	 *    @return valid
	 *    @see LoginBean
	 *	@version initial version
	 *	@author GR_TH3_03
	 */
	public boolean isValid() {
		return isValid;
	}
	/**
	 * setting valid
	 * @param valid
	 *    @see LoginBean
	 *	@version initial version
	 *	@author GR_TH3_03
	 */
	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
		
}
