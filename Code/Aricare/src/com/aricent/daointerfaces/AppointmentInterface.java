/***********************************************************************
     
	  File Name	            :     AppointmentInterface.java
	  Principal Author      	: GR_TH3_03
	  Subsystem Name        :
	  Module Name           	: book appointment
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

import com.aricent.pojofiles.AppointmentBean;

/**
 * containing methods for bookAppointmentDAO class
 * @see AppointmentInterface
 * @author GR_TH3_03
 *
 */
public interface AppointmentInterface {
	
	public void bookAppointment(AppointmentBean beanObject);
	public boolean AvailabilityCheck(AppointmentBean beanObject);
	 public boolean TimeSlotCheck(AppointmentBean beanObject);
	 public boolean duplicateAppointmentCheck(AppointmentBean beanObject);

}
