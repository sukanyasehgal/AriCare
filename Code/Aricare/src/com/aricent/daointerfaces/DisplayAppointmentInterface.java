/***********************************************************************
  
	  File Name	            :     DisplayAppointmentInterface.java
	  Principal Author      	: GR_TH3_03
	  Subsystem Name        :
	  Module Name           	: display appointment
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

import java.util.List;

import com.aricent.pojofiles.AppointmentBean;
import com.aricent.pojofiles.LoginBean;
/**
 * containing methods for displayAppoitnmentDAO class
 * @see DisplayAppointmentInterface
 * @author GR_TH3_03
 *
 */
public interface DisplayAppointmentInterface {

	public List<AppointmentBean> displayAppointmentDetails(LoginBean user);
}
