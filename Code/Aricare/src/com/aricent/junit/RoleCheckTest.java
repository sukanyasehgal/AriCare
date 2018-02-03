/***********************************************************************

	  File Name	            :     RoleCheckTest.java
	  Principal Author      	: GR_TH3_03
	  Subsystem Name        :
	  Module Name           	: test RoleCheckDAO
	  Date of First Release 	: 23-05-2016
	  Author			:          GR_TH3_03
	  Description           	:  class testing RoleCheckDAO functionalities


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

import com.aricent.daofiles.RoleCheckDAO;
import com.aricent.pojofiles.LoginBean;

/**
 *	testing RoleCheckDAO functionalities
 *	@see RoleCheckTest
 *	@version 1.0
 *	@author GR_TH3_03
 */
public class RoleCheckTest {

private LoginBean loginBean;
	//initializing login credentials
	@Before
	public void initializeLoginCredentials()
	{
		loginBean = new LoginBean();
		loginBean.setPhone_number(Long.parseLong("7344335768"));
		loginBean.setPassword("12345678");
	}
	//test checkRole function
	@Test
	public void checkRole()
	{
		RoleCheckDAO roleDAO = new RoleCheckDAO();
		assertEquals("patient",roleDAO.checkRole(loginBean));
		
	}
	//test username function
	@Test
	public void checkUserName()
	{
		RoleCheckDAO roleDAO = new RoleCheckDAO();
		assertEquals("Ritesh",roleDAO.getUserName("patient",loginBean));
		
	}
	

}
