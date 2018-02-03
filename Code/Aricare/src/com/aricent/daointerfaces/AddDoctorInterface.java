/***********************************************************************
   
	  File Name	            :     AddDoctorInterface.java
	  Principal Author      	: GR_TH3_03
	  Subsystem Name        :
	  Module Name           	: add doctor 
	  Date of First Release 	: 10-05-2016
	  Author			:          GR_TH3_03
	  Description           	:  interface containing methods of dao class 

	  Change History

	  Version      		:  1.0
	  Date(DD/MM/YYYY) 	:  10-05-2016
	  Modified by		:  GR_TH3_03
	  Description of change : 

***********************************************************************/
package com.aricent.daointerfaces;

import com.aricent.pojofiles.AddDoctorBean;

/**
 * containing methods for AddDoctorDAO class
 * @see AddDoctorInterface
 * @author GR_TH3_03
 *
 */
public interface AddDoctorInterface {
	
	public boolean checkFordatabase(AddDoctorBean beanObject);
	public void addDoctor(AddDoctorBean beanObject);
	public void addDoctorToLoginDetails(AddDoctorBean beanObject,String password);
	public void addDoctorToDoctorPofile(AddDoctorBean beanObject);

}
