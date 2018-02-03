/***********************************************************************
           
	  File Name	            :     LoginTest.java
	  Principal Author      	: GR_TH3_03
	  Subsystem Name        :
	  Module Name           	: test Login
	  Date of First Release 	: 23-05-2016
	  Author			:          GR_TH3_03
	  Description           	:  class testing login functionalities


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

import com.aricent.daofiles.LoginDAO;
import com.aricent.pojofiles.LoginBean;

/**
 *	testing login functionalities
 *	@see LoginTest
 *	@version 1.0
 *	@author GR_TH3_03
 */
public class LoginTest {

	private LoginBean loginBean;
	
	//initializing user for login
	@Before
	public void initializeLoginCredentials()
	{
		loginBean = new LoginBean();
		loginBean.setPhone_number(Long.parseLong("7344335768"));
		loginBean.setPassword("12345678");
	}
	//check for authentication of user
	@Test
	public void AuthenticateUserPositive()
	{
		LoginDAO login = new LoginDAO();
		login.login(loginBean);
		assertEquals(true,loginBean.isValid());
	}

}
