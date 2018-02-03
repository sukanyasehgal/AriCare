/***********************************************************************
             
	  File Name	            :     SignupInterface.java
	  Principal Author      	: GR_TH3_03
	  Subsystem Name        :
	  Module Name           	: Signup
	  Date of First Release 	: 20-05-2016
	  Author			:          GR_TH3_03
	  Description           	:  interface containing methods of dao class 

	  Change History

	  Version      		:  1.0
	  Date(DD/MM/YYYY) 	:  20-05-2016
	  Modified by		:  GR_TH3_03
	  Description of change : 

***********************************************************************/
package com.aricent.daointerfaces;

import com.aricent.pojofiles.PatientDetailsBean;

/**
 * containing methods for SignupDAO class
 * @see SignupInterface
 * @author GR_TH3_03
 *
 */
public interface SignupInterface {

	public boolean checkFordatabase(PatientDetailsBean beanObject);
	public void registserUser(PatientDetailsBean beanObject);
}
