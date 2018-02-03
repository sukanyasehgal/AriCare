/***********************************************************************
          
	  File Name	            :     SignupTest.java
	  Principal Author      	: GR_TH3_03
	  Subsystem Name        :
	  Module Name           	: test Signup
	  Date of First Release 	: 23-05-2016
	  Author			:          GR_TH3_03
	  Description           	:  class testing Signup functionalities


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

import com.aricent.daofiles.SignupDAO;
import com.aricent.pojofiles.PatientDetailsBean;
/**
 *	testing Signup functionalities
 *	@see SignupTest
 *	@version 1.0
 *	@author GR_TH3_03
 */
public class SignUpTest {

	private PatientDetailsBean bean;
	
	@Before
	public void setUp()
	{
		bean = new PatientDetailsBean();
		bean.setPhone_number(Long.parseLong("7896533631"));
	}
	//check whether user already exists
	@Test
	public void checkWhetherUserisAlreadyRegistered()
	{
		SignupDAO signup = new SignupDAO();
		assertEquals(true,signup.checkFordatabase(bean));
	}

}
