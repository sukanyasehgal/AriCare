/***********************************************************************
         
	  File Name	            :     UpdatePillDetailsBean.java
	  Principal Author      	: GR_TH3_03
	  Subsystem Name        :
	  Module Name           	: add pill details into db
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
 *	@see UpdatePillDetailsBean
 *	@see UpdatePillDetailsBean#getDoctorName(),setDoctorName(),getDoctorNumber(),setDoctorNumber(),getPatientName(),
 *  setPatientName(),getPatientNumber(),setPatientNumber(),getPillName(),setPillName(),getStartDate(),setStartDate(),
 *  getendDate(),setendDate(),setTiming(),getTiming(),getDosage(),setDosage()
 *	@version 1.0
 *	@author GR_TH3_03
 */
public class UpdatePillDetailsBean {
	
	//declaring necessary variables for pill details
	private String doctorName;
	private long doctorNumber;
	private String patientName; 
	private long patientNumber; 
	private String pillName; 
	private String startDate; 
	private String endDate; 
	private String timing; 
	private int dosage;
	/**
	 * getting doctorName
	 *    @return doctorName
	 *    @see UpdatePillDetailsBean
	 *	@version initial version
	 *	@author GR_TH3_03
	 */
	public String getDoctorName() {
		return doctorName;
	}
	 /**
	 * setting doctorName
	 * @param doctorName
	 *    @see UpdatePillDetailsBean
	 *	@version initial version
	 *	@author GR_TH3_03
	 */
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	/**
	 * getting doctorNumber
	 *    @return doctorNumber
	 *    @see UpdatePillDetailsBean
	 *	@version initial version
	 *	@author GR_TH3_03
	 */
	public long getDoctorNumber() {
		return doctorNumber;
	}
	/**
	 * setting doctorNumber
	 * @param doctorNumber
	 *    @see UpdatePillDetailsBean
	 *	@version initial version
	 *	@author GR_TH3_03
	 */
	public void setDoctorNumber(long doctorNumber) {
		this.doctorNumber = doctorNumber;
	}
	/**
	 * getting PatientName
	 *    @return PatientName
	 *    @see UpdatePillDetailsBean
	 *	@version initial version
	 *	@author GR_TH3_03
	 */
	public String getPatientName() {
		return patientName;
	}
	/**
	 * setting PatientName
	 * @param PatientName
	 *    @see UpdatePillDetailsBean
	 *	@version initial version
	 *	@author GR_TH3_03
	 */
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	/**
	 * getting PatientNumber
	 *    @return PatientNumber
	 *    @see UpdatePillDetailsBean
	 *	@version initial version
	 *	@author GR_TH3_03
	 */
	public long getPatientNumber() {
		return patientNumber;
	}
	/**
	 * setting PatientNumber
	 * @param patientNumber
	 *    @see UpdatePillDetailsBean
	 *	@version initial version
	 *	@author GR_TH3_03
	 */
	public void setPatientNumber(long patientNumber) {
		this.patientNumber = patientNumber;
	}
	/**
	 * getting PillName
	 *    @return PillName
	 *    @see UpdatePillDetailsBean
	 *	@version initial version
	 *	@author GR_TH3_03
	 */
	public String getPillName() {
		return pillName;
	}
	/**
	 * setting PillName
	 * @param PillName
	 *    @see UpdatePillDetailsBean
	 *	@version initial version
	 *	@author GR_TH3_03
	 */
	public void setPillName(String pillName) {
		this.pillName = pillName;
	}
	/**
	 * getting start_date
	 *    @return start_date
	 *    @see UpdatePillDetailsBean
	 *	@version initial version
	 *	@author GR_TH3_03
	 */
	public String getStartDate() {
		return startDate;
	}
	/**
	 * setting startDate
	 * @param startDate
	 *    @see UpdatePillDetailsBean
	 *	@version initial version
	 *	@author GR_TH3_03
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	/**
	 * getting EndDate
	 *    @return EndDate
	 *    @see UpdatePillDetailsBean
	 *	@version initial version
	 *	@author GR_TH3_03
	 */
	public String getEndDate() {
		return endDate;
	}
	/**
	 * setting endDate
	 * @param endDate
	 *    @see UpdatePillDetailsBean
	 *	@version initial version
	 *	@author GR_TH3_03
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	/**
	 * getting Timing
	 *    @return Timing
	 *    @see UpdatePillDetailsBean
	 *	@version initial version
	 *	@author GR_TH3_03
	 */
	public String getTiming() {
		return timing;
	}
	/**
	 * setting Timing
	 * @param Timing
	 *    @see UpdatePillDetailsBean
	 *	@version initial version
	 *	@author GR_TH3_03
	 */
	public void setTiming(String timing) {
		this.timing = timing;
	}
	/**
	 * getting dosage
	 *    @return dosage
	 *    @see UpdatePillDetailsBean
	 *	@version initial version
	 *	@author GR_TH3_03
	 */
	public int getDosage() {
		return dosage;
	}
	/**
	 * setting dosage
	 * @param dosage
	 *    @see UpdatePillDetailsBean
	 *	@version initial version
	 *	@author GR_TH3_03
	 */
	public void setDosage(int dosage) {
		this.dosage = dosage;
	}
	
	

}
