/***********************************************************************
 
      File Name	            :     DeleteDoctorBean.java
	  Principal Author      	: GR_TH3_03
	  Subsystem Name        :
	  Module Name           	: delete doctor
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
 *	@see DeleteDoctorBean
 *	@see DeleteDoctorBean#setname(),getname(),setSpecialization(),getSpecialization(),setPhoneNumber(),getPhoneNumber()
 *	@version 1.0
 *	@author GR_TH3_03
 */
public class DeleteDoctorBean {

	private String name;
	private String specialization;
	private Long phoneNumber;
	private boolean valid;

	/**
	 * getting name
	 *    @return name
	 *    @see DeleteDoctorBean
	 *	@version initial version
	 *	@author GR_TH3_03
	 */
	public String getName() {
		return name;
	}

	 /**
	 * setting name
	 * @param name
	 *    @see DeleteDoctorBean
	 *	@version initial version
	 *	@author GR_TH3_03
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * getting specialization
	 *    @return specialization
	 *    @see DeleteDoctorBean
	 *	@version initial version
	 *	@author GR_TH3_03
	 */
	public String getSpecialization() {
		return specialization;
	}

	/**
	 * setting specialization
	 * @param specialization
	 *    @see DeleteDoctorBean
	 *	@version initial version
	 *	@author GR_TH3_03
	 */
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	/**
	 * getting phoneNumber
	 *    @return phoneNumber
	 *    @see DeleteDoctorBean
	 *	@version initial version
	 *	@author GR_TH3_03
	 */
	public Long getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * setting phoneNumber
	 * @param phoneNumber
	 *    @see DeleteDoctorBean
	 *	@version initial version
	 *	@author GR_TH3_03
	 */
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * getting valid
	 *    @return valid
	 *    @see DeleteDoctorBean
	 *	@version initial version
	 *	@author GR_TH3_03
	 */
	public boolean isValid() {
		return valid;
	}

	/**
	 * setting valid
	 * @param valid
	 *    @see DeleteDoctorBean
	 *	@version initial version
	 *	@author GR_TH3_03
	 */
	public void setValid(boolean valid) {
		this.valid = valid;
	}

}
