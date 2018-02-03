/***********************************************************************
            
	  File Name	            :     UpdatePillDetailsInterface.java
	  Principal Author      	: GR_TH3_03
	  Subsystem Name        :
	  Module Name           	: Update Pill Details
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

import com.aricent.pojofiles.UpdatePillDetailsBean;

/**
 * containing methods for  UpdatePillDetailsDAO class
 * @see  UpdatePillDetailsInterface
 * @author GR_TH3_03
 *
 */
public interface UpdatePillDetailsInterface {

	public void updatePillDetails(UpdatePillDetailsBean beanObject);
	public boolean validateEntries(UpdatePillDetailsBean beanObject);
}
