/***********************************************************************
        
	  File Name	            :     DoctorUpdationsTest.java
	  Principal Author      	: GR_TH3_03
	  Subsystem Name        :
	  Module Name           	: test operations on doctor
	  Date of First Release 	: 23-05-2016
	  Author			:          GR_TH3_03
	  Description           	:  class testing operations on doctor


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

import com.aricent.daofiles.AddDoctorDAO;
import com.aricent.daofiles.DeleteDoctorDAO;
import com.aricent.pojofiles.AddDoctorBean;
import com.aricent.pojofiles.DeleteDoctorBean;
/**
 *	testing operations on doctor
 *	@see DoctorUpdationsTest
 *	@version 1.0
 *	@author GR_TH3_03
 */
public class DoctorUpdationsTest {

	private AddDoctorBean addDoctor;
	private DeleteDoctorBean deleteDoctor;
	
	//initializeDoctor to add doctor and delete doctor
	@Before
	public void initializeDoctor()
	{
		addDoctor = new AddDoctorBean();
		addDoctor.setContactNumber(Long.parseLong("9090909090"));
		
		
		deleteDoctor = new DeleteDoctorBean();
		deleteDoctor.setName("Mihir");
		deleteDoctor.setPhoneNumber(Long.parseLong("9080789678"));
		deleteDoctor.setSpecialization("cardiology");
		
	}
	//check whether phone number already exists
	@Test
	public void checkWhetherPhoneNumberAlreadyExists()
	{
		AddDoctorDAO addDAO = new AddDoctorDAO();
		assertEquals(false,addDAO.checkFordatabase(addDoctor));
	}
	
	//check whether doctor to be deleted exists
	@Test
	public void checkDoctortobeDeletedExistsPositive()
	{
		DeleteDoctorDAO deleteDao = new DeleteDoctorDAO();
		assertEquals(true,deleteDao.doctorIsPresent(deleteDoctor));
	}
	//check whether doctor is deleted
	@Test
	public void checkDoctorIsDeletedPositive()
	{
		DeleteDoctorDAO deleteDao = new DeleteDoctorDAO();
		assertEquals(true,deleteDao.deleteDoctor(deleteDoctor));
	}
	

}
