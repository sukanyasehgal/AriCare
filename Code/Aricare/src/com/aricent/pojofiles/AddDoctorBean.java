/***********************************************************************
    
	  File Name	            :     AddDoctorBean.java
	  Principal Author      	: GR_TH3_03
	  Subsystem Name        :
	  Module Name           	: add doctor 
	  Date of First Release 	: 10-05-2016
	  Author			:          GR_TH3_03
	  Description           	:  class containing all getters and setters


	  Change History

	  Version      		:  1.0
	  Date(DD/MM/YYYY) 	:  10-05-2016
	  Modified by		:  GR_TH3_03
	  Description of change : 

***********************************************************************/

package com.aricent.pojofiles;

/**
 *	containing getters and setters
 *	@see AddDoctorBean
 *	@see addDoctorBean#setId(),getId(),setName(),getName(),setImage(),getImage(),setQualification(),
 *  getQualification(),setspecialization(),getSpecialization(),getTimimgToMeet(),setTimingToMeet(),setContactNumber(),
 *  getContactNumber(),getAddress(),setAddress(),getEmail(),setEmail()
 *	@version 1.0
 *	@author GR_TH3_03
 */

public class AddDoctorBean {

	//declaring id of doctor
	private int id;
	//declaring name of doctor
	private String name;
	//declaring image of doctor in the form of url
	private String image;
	//declaring qualification
	private String qualification;
	//declaring specialization
	private String specialization;
	//declaring timing of doctor
	private String timingToMeet;
	//declaring contact Number
	private long contactNumber;
	//declaring address
	private String address;
	//declaring email
	private String email;
	
	
	/**
	 * getting id of doctor
	 *    @return id
	 *    @see AddDoctorBean
	 *	@version initial version
	 *	@author GR_TH3_03
	 */
	 public int getId() {
		return id;
	}
	 
	 /**
		 * setting id of doctor
		 * @param id
		 *    @see AddDoctorBean
		 *	@version initial version
		 *	@author GR_TH3_03
		 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * getting email id of doctor
	 *    @return email
	 *    @see AddDoctorBean
	 *	@version initial version
	 *	@author GR_TH3_03
	 */
	public String getEmail() {
		return email;
	}
	
	 /**
	 * setting email of doctor
	 * @param email
	 *    @see AddDoctorBean
	 *	@version initial version
	 *	@author GR_TH3_03
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * getting name of doctor
	 *    @return name
	 *    @see AddDoctorBean
	 *	@version initial version
	 *	@author GR_TH3_03
	 */
	public String getName() {
		return name;
	}
	
	 /**
	 * setting name of doctor
	 * @param name
	 *    @see AddDoctorBean
	 *	@version initial version
	 *	@author GR_TH3_03
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * getting image of doctor
	 *    @return image
	 *    @see AddDoctorBean
	 *	@version initial version
	 *	@author GR_TH3_03
	 */
	public String getImage() {
		return image;
	}
	
	 /**
	 * setting image of doctor
	 * @param image
	 *    @see AddDoctorBean
	 *	@version initial version
	 *	@author GR_TH3_03
	 */
	public void setImage(String image) {
		this.image = image;
	}
	
	/**
	 * getting qualification of doctor
	 *    @return qualification
	 *    @see AddDoctorBean
	 *	@version initial version
	 *	@author GR_TH3_03
	 */
	public String getQualification() {
		return qualification;
	}
	
	 /**
	 * setting qualification of doctor
	 * @param qualification
	 *    @see AddDoctorBean
	 *	@version initial version
	 *	@author GR_TH3_03
	 */
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	
	/**
	 * getting specialization of doctor
	 *    @return specialization
	 *    @see AddDoctorBean
	 *	@version initial version
	 *	@author GR_TH3_03
	 */
	public String getSpecialization() {
		return specialization;
	}
	
	 /**
	 * setting specialization of doctor
	 * @param specialization
	 *    @see AddDoctorBean
	 *	@version initial version
	 *	@author GR_TH3_03
	 */
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	
	/**
	 * getting Timing of doctor
	 *    @return timiningToMeet
	 *    @see AddDoctorBean
	 *	@version initial version
	 *	@author GR_TH3_03
	 */
	public String getTimingToMeet() {
		return timingToMeet;
	}
	
	 /**
	 * setting Timing of doctor
	 * @param timingToMeet
	 *    @see AddDoctorBean
	 *	@version initial version
	 *	@author GR_TH3_03
	 */
	public void setTimingToMeet(String timingToMeet) {
		this.timingToMeet = timingToMeet;
	}
	
	/**
	 * getting contact Number of doctor
	 *    @return contactNumber
	 *    @see AddDoctorBean
	 *	@version initial version
	 *	@author GR_TH3_03
	 */
	public long getContactNumber() {
		return contactNumber;
	}
	
	 /**
	 * setting ContactNumber of doctor
	 * @param contactNumber
	 *    @see AddDoctorBean
	 *	@version initial version
	 *	@author GR_TH3_03
	 */
	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	/**
	 * getting address of doctor
	 *    @return address
	 *    @see AddDoctorBean
	 *	@version initial version
	 *	@author GR_TH3_03
	 */
	public String getAddress() {
		return address;
	}
	
	 /**
	 * setting address of doctor
	 * @param address
	 *    @see AddDoctorBean
	 *	@version initial version
	 *	@author GR_TH3_03
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	

}
