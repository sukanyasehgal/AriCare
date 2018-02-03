/***********************************************************************

	  File Name	            :     PillDetailsBean.java
	  Principal Author      	: GR_TH3_03
	  Subsystem Name        :
	  Module Name           	: display pill details
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
 *	@see PillDetailsBean
 *	@see PillDetailsBean#setpill_name(),getpill_name(),setStart_date(),getStart_date(),setend_date(),getEnd_Date(),
 * getDosage_time(), setDosage_time
 *	@version 1.0
 *	@author GR_TH3_03
 */
public class PillDetailBean {

	private String pill_name;
	private Date start_date;
	private Date end_date;
	private Time dosage_time;
	private int dosage;
	
	/**
	 * getting Pill_name
	 *    @return Pill_name
	 *    @see PillDetailBean
	 *	@version initial version
	 *	@author GR_TH3_03
	 */
	public String getPill_name() {
		return pill_name;
	}
	 /**
	 * setting pill_name 
	 * @param pill_name
	 *    @see PilldetailsBean
	 *	@version initial version
	 *	@author GR_TH3_03
	 */
	public void setPill_name(String pill_name) {
		this.pill_name = pill_name;
	}
	/**
	 * getting start_date
	 *    @return start_date
	 *    @see PillDetailBean
	 *	@version initial version
	 *	@author GR_TH3_03
	 */
	public Date getStart_date() {
		return start_date;
	}
	/**
	 * setting start_date
	 * @param start_date
	 *    @see PilldetailsBean
	 *	@version initial version
	 *	@author GR_TH3_03
	 */
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	/**
	 * getting end_date
	 *    @return endDate
	 *    @see PillDetailBean
	 *	@version initial version
	 *	@author GR_TH3_03
	 */
	public Date getEnd_date() {
		return end_date;
	}
	/**
	 * setting end_date
	 * @param end_date
	 *    @see PilldetailsBean
	 *	@version initial version
	 *	@author GR_TH3_03
	 */
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	/**
	 * getting dosageTime
	 *    @return dosageTime
	 *    @see PillDetailBean
	 *	@version initial version
	 *	@author GR_TH3_03
	 */
	public Time getDosage_time() {
		return dosage_time;
	}
	/**
	 * setting dosageTime
	 * @param dosageTime
	 *    @see PilldetailsBean
	 *	@version initial version
	 *	@author GR_TH3_03
	 */
	public void setDosage_time(Time dosage_time) {
		this.dosage_time = dosage_time;
	}
	/**
	 * getting dosage
	 *    @return dosage
	 *    @see PillDetailBean
	 *	@version initial version
	 *	@author GR_TH3_03
	 */
	public int getDosage() {
		return dosage;
	}
	/**
	 * setting dosage 
	 * @param dosage
	 *    @see PilldetailsBean
	 *	@version initial version
	 *	@author GR_TH3_03
	 */
	public void setDosage(int dosage) {
		this.dosage = dosage;
	}
	
	
	
}
