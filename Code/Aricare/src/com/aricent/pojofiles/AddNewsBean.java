/***********************************************************************
     
	  File Name	            :     AddNewsBean.java
	  Principal Author      	: GR_TH3_03
	  Subsystem Name        :
	  Module Name           	: add news 
	  Date of First Release 	: 13-05-2016
	  Author			:          GR_TH3_03
	  Description           	:  class containing all getters and setters


	  Change History

	  Version      		:  1.0
	  Date(DD/MM/YYYY) 	:  13-05-2016
	  Modified by		:  GR_TH3_03
	  Description of change : 

***********************************************************************/
package com.aricent.pojofiles;

/**
 *	containing getters and setters
 *	@see AddNewsBean
 *	@see addNewsBean#setId(),getId(),setsubject(),getSubject(),setContent(),getContent()
 *	@version 1.0
 *	@author GR_TH3_03
 */
public class AddNewsBean {

	private String subject;
	private String content;
	private boolean isValid = false;
	private int id;
	
	/**
	 * getting id 
	 *    @return id
	 *    @see AddNewsBean
	 *	@version initial version
	 *	@author GR_TH3_03
	 */
	public int getId() {
		return id;
	}

	 /**
		 * setting id 
		 * @param id
		 *    @see AddNewsBean
		 *	@version initial version
		 *	@author GR_TH3_03
		 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * getting isValid 
	 *    @return isValid
	 *    @see AddNewsBean
	 *	@version initial version
	 *	@author GR_TH3_03
	 */
	public boolean isValid() {
		return isValid;
	}
	 /**
	 * setting valid 
	 * @param isValid
	 *    @see AddNewsBean
	 *	@version initial version
	 *	@author GR_TH3_03
	 */
	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
	/**
	 * getting subject 
	 *    @return subject
	 *    @see AddNewsBean
	 *	@version initial version
	 *	@author GR_TH3_03
	 */
	public String getSubject() {
		return subject;
	}
	
	 /**
	 * setting subject 
	 * @param subject
	 *    @see AddNewsBean
	 *	@version initial version
	 *	@author GR_TH3_03
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	/**
	 * getting content 
	 *    @return content
	 *    @see AddNewsBean
	 *	@version initial version
	 *	@author GR_TH3_03
	 */
	public String getContent() {
		return content;
	}
	
	 /**
	 * setting Content 
	 * @param content
	 *    @see AddNewsBean
	 *	@version initial version
	 *	@author GR_TH3_03
	 */
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
