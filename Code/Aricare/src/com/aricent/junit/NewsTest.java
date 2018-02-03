/***********************************************************************
            
	  File Name	            :     NewsTest.java
	  Principal Author      	: GR_TH3_03
	  Subsystem Name        :
	  Module Name           	: test add news
	  Date of First Release 	: 23-05-2016
	  Author			:          GR_TH3_03
	  Description           	:  class testing add news functionalities


	  Change History

	  Version      		:  1.0
	  Date(DD/MM/YYYY) 	:  23-05-2016
	  Modified by		:  GR_TH3_03
	  Description of change : 

***********************************************************************/
package com.aricent.junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.aricent.daofiles.AddNewsDAO;
import com.aricent.pojofiles.AddNewsBean;

/**
 *	testing add news functionalities
 *	@see NewsTestTest
 *	@version 1.0
 *	@author GR_TH3_03
 */
public class NewsTest {

 private AddNewsBean newsBean;
 
 //initialize news to add newsletter
 @Before
 public void initializeNews()
 {
	 newsBean = new AddNewsBean();
	 newsBean.setSubject("abc");
	 newsBean.setContent("xyz");
 }
 //test whether newsletter has been added
 @Test
 public void checkNewsisAddedPositive()
 {
	 AddNewsDAO newsDAO = new AddNewsDAO();
	 newsDAO.addNewsLetter(newsBean);
	 assertEquals(true,newsBean.isValid());
 }
 
 //test whether news is properly initialized
 @Test
 
public void checkNewsAreInitialized()
 {
	 assertEquals("abc",newsBean.getSubject());
	 assertEquals("xyz",newsBean.getContent());
 }

}
