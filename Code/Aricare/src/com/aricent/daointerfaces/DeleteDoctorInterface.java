/***********************************************************************
   
	  File Name	            :     DeleteDoctorInterface.java
	  Principal Author      	: GR_TH3_03
	  Subsystem Name        :
	  Module Name           	: delete Doctor
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

import com.aricent.pojofiles.DeleteDoctorBean;

/**
 * containing methods for DeleteDoctorDAO class
 * @see DeleteDoctorInterface
 * @author GR_TH3_03
 *
 */
public interface DeleteDoctorInterface {

	public boolean deleteDoctor(DeleteDoctorBean deleteDoctorBean);
	public boolean doctorIsPresent(DeleteDoctorBean deleteDoctorBean);
}
