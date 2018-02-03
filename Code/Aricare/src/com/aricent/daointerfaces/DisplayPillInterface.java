/***********************************************************************
    
	  File Name	            :     DisplayPillInterface.java
	  Principal Author      	: GR_TH3_03
	  Subsystem Name        :
	  Module Name           	: display Pill details
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

import java.util.List;

import com.aricent.pojofiles.LoginBean;
import com.aricent.pojofiles.PillDetailBean;

/**
 * containing methods for DisplayPillDetailsDAO class
 * @see DisplayPillInterface
 * @author GR_TH3_03
 *
 */
public interface DisplayPillInterface {

	public List<PillDetailBean> displayPillDetails(LoginBean user);
}
