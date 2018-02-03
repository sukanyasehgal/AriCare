/***********************************************************************
       
	  File Name	            :     PatientDetailsBean.java
	  Principal Author      	: GR_TH3_03
	  Subsystem Name        :
	  Module Name           	: Signup
	  Date of First Release 	: 13-05-2016
	  Author			:          GR_TH3_03
	  Description           	:  class containing all getters and setters


	  Change History

	  Version      		:  1.0
	  Date(DD/MM/YYYY) 	:  13-05-2016
	  Modified by		:  GR_TH3_03
	  Description of change : 

***********************************************************************/
package com.aricent.pojofiles;

/**
 *	containing getters and setters
 *	@see PatientDetailsBean
 *	@see PatientDetailsBean#setp_name(),getp_name(),setphone_number(),getPhone_number(),setaddress(),getaddress(),
 *  getpassword(),setPassword
 *	@version 1.0
 *	@author GR_TH3_03
 */
public class PatientDetailsBean {

	//declaring all variables necessary for signup
	private String p_name;
	private long phone_number;
	private String address;
	private String email_id;
	private String role;
	private String password;
	
	/**
	 * getting p_name
	 *    @return p_name
	 *    @see PatientDetailsBean
	 *	@version initial version
	 *	@author GR_TH3_03
	 */
	public String getP_name() {
		return p_name;
	}
	/**
	 * setting p_name
	 * @param p_name
	 *    @see PatientDetailsBean
	 *	@version initial version
	 *	@author GR_TH3_03
	 */
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	/**
	 * getting phone_number
	 *    @return phone_number
	 *    @see PatientDetailsBean
	 *	@version initial version
	 *	@author GR_TH3_03
	 */
	public long getPhone_number() {
		return phone_number;
	}
	/**
	 * setting phone_number
	 * @param phone_number
	 *    @see PatientDetailsBean
	 *	@version initial version
	 *	@author GR_TH3_03
	 */
	public void setPhone_number(long phone_number) {
		this.phone_number = phone_number;
	}
	/**
	 * getting address
	 *    @return address
	 *    @see PatientDetailsBean
	 *	@version initial version
	 *	@author GR_TH3_03
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * setting address
	 * @param address
	 *    @see PatientDetailsBean
	 *	@version initial version
	 *	@author GR_TH3_03
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * getting email_id
	 *    @return email_id
	 *    @see PatientDetailsBean
	 *	@version initial version
	 *	@author GR_TH3_03
	 */
	public String getEmail_id() {
		return email_id;
	}
	/**
	 * setting email_id
	 * @param email_id
	 *    @see PatientDetailsBean
	 *	@version initial version
	 *	@author GR_TH3_03
	 */
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	/**
	 * getting role
	 *    @return role
	 *    @see PatientDetailsBean
	 *	@version initial version
	 *	@author GR_TH3_03
	 */
	public String getRole() {
		return role;
	}
	/**
	 * setting role
	 * @param role
	 *    @see PatientDetailsBean
	 *	@version initial version
	 *	@author GR_TH3_03
	 */
	public void setRole(String role) {
		this.role = role;
	}
	/**
	 * getting password
	 *    @return password
	 *    @see PatientDetailsBean
	 *	@version initial version
	 *	@author GR_TH3_03
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * setting password
	 * @param password
	 *    @see PatientDetailsBean
	 *	@version initial version
	 *	@author GR_TH3_03
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
}
