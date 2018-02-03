/***********************************************************************
        
	  File Name	            	: ObjectSetter.java
	  Principal Author      	: GR_TH3_03
	  Subsystem Name        	:
	  Module Name           	: Object Setter 
	  Date of First Release 	: 10-05-2016
	  Author			:          GR_TH3_03
	  Description           	:  Class containing getters and setters for MailList and TextList objects


	  Change History

	  Version      		:  1.0
	  Date(DD/MM/YYYY) 	:  10-05-2016
	  Modified by		:  GR_TH3_03
	  Description of change : 

 ***********************************************************************/
package com.aricent.pillreminder;

/**
 * class to invoke the mailtext and maillist generation process for pill
 * reminder
 * 
 * @see ObjectSetter
 * @see ObjectSetter#getListCreator()
 *      ,setListCreator(),getTextCreator(),setTextCreator
 * @version 1.0
 * @author GR_TH3_03
 */
public class ObjectSetter {

	static MailListCreator ListCreator;
	static MailTextCreator TextCreator;

	// getters and setters
	public MailListCreator getListCreator() {
		return ListCreator;
	}

	public void setListCreator(MailListCreator listCreator) {
		ListCreator = listCreator;
	}

	public MailTextCreator getTextCreator() {
		return TextCreator;
	}

	public void setTextCreator(MailTextCreator textCreator) {
		TextCreator = textCreator;
	}

}
