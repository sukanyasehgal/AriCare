/***********************************************************************
      
	  File Name	            :     AddNewsInterface.java
	  Principal Author      	: GR_TH3_03
	  Subsystem Name        :
	  Module Name           	: add news 
	  Date of First Release 	: 13-05-2016
	  Author			:          GR_TH3_03
	  Description           	:  interface containing methods of dao class 

	  Change History

	  Version      		:  1.0
	  Date(DD/MM/YYYY) 	:  10-05-2016
	  Modified by		:  GR_TH3_03
	  Description of change : 

***********************************************************************/
package com.aricent.daointerfaces;

import com.aricent.pojofiles.AddNewsBean;

/**
 * containing methods for AddNewsDAO class
 * @see AddNewsInterface
 * @author GR_TH3_03
 *
 */
public interface AddNewsInterface {

	public void addNewsLetter(AddNewsBean beanObject);
}
