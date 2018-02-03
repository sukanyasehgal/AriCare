/***********************************************************************
      
	  File Name	            :     AppointmentBean.java
	  Principal Author      	: GR_TH3_03
	  Subsystem Name        :
	  Module Name           	: Book appointment
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

import java.sql.Date;
import java.sql.Time;



/**
 *	containing getters and setters
 *	@see AppointmentBean
 *	@see AppointmentBean#getP_name(),setP_name(), getUser_number(), setUser_number(),getD_name(),setD_name(),
 *getDate(),setDate(),getTime(),setTime()
 *	@version 1.0
 *	@author GR_TH3_03
 */
public class AppointmentBean {

	//declaring variables necessary for taking appointment
	private long User_number;
	private String p_name;
	private String d_name;
	private Date date;
	private Time time;
	private int d_id;
	private int appointment_id;
	
	
	public int getD_id() {
		return d_id;
	}
	public void setD_id(int d_id) {
		this.d_id = d_id;
	}
	public int getAppointment_id() {
		return appointment_id;
	}
	public void setAppointment_id(int appointment_id) {
		this.appointment_id = appointment_id;
	}
	/**
	 * getting P_name 
	 *    @return P_name
	 *    @see AppointmentBean
	 *	@version initial version
	 *	@author GR_TH3_03
	 */
	public String getP_name() {
		return p_name;
	}
	/**
	 * setting P_name
	 * @param P_name
	 *    @see AppointmentBean
	 *	@version initial version
	 *	@author GR_TH3_03
	 */
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	/**
	 * getting User_number 
	 *    @return User_number
	 *    @see AppointmentBean
	 *	@version initial version
	 *	@author GR_TH3_03
	 */
	public long getUser_number() {
		return User_number;
	}
	/**
	 * setting User_number
	 * @param User_number
	 *    @see AppointmentBean
	 *	@version initial version
	 *	@author GR_TH3_03
	 */
	public void setUser_number(long user_number) {
		User_number = user_number;
	}
	/**
	 * getting D_name 
	 *    @return D_name
	 *    @see AppointmentBean
	 *	@version initial version
	 *	@author GR_TH3_03
	 */
	public String getD_name() {
		return d_name;
	}
	/**
	 * setting D_name
	 * @param D_name
	 *    @see AppointmentBean
	 *	@version initial version
	 *	@author GR_TH3_03
	 */
	public void setD_name(String d_name) {
		this.d_name = d_name;
	}
	
	/**
	 * getting Date 
	 *    @return date
	 *    @see AppointmentBean
	 *	@version initial version
	 *	@author GR_TH3_03
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * setting  Date
	 * @param Date
	 *    @see AppointmentBean
	 *	@version initial version
	 *	@author GR_TH3_03
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	
	/**
	 * getting time
	 *    @return time
	 *    @see AppointmentBean
	 *	@version initial version
	 *	@author GR_TH3_03
	 */
	public Time getTime() {
		return time;
	}
	/**
	 * setting time
	 * @param time
	 *    @see AppointmentBean
	 *	@version initial version
	 *	@author GR_TH3_03
	 */
	public void setTime(Time time) {
		this.time = time;
	}
	
	
}
