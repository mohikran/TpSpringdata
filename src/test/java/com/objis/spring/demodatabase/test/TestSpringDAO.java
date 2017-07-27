package com.objis.spring.demodatabase.test;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.objis.spring.dao.EmployeDao;
import com.objis.spring.domaine.Employe;

import junit.framework.TestCase;

public class TestSpringDAO extends TestCase {

	private Employe emp, emp2;
	private EmployeDao springDao;
	private ClassPathXmlApplicationContext appContext;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		emp = new Employe( "douglas", "mdpdoug", "Douglas", "MBIANDOU", "douglas.mbiandou@objis.com", "employe");
		
		emp2= new Employe("charles","alex","charles","alex","charles","alex");
		appContext = new ClassPathXmlApplicationContext("spring-data.xml");

		springDao = (EmployeDao) appContext.getBean("employeDao");
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		emp = null;
		appContext = null;
		springDao = null;
	}

	public void testSaveEmploye() {
		springDao.save(emp);
		springDao.save(emp2);
	}

	public void testDeleteById() {
		springDao.deleteEmployeByid(5);
	}
	public void testDeleteByPassword() {
		springDao.deleteByPassword("alexpassword");
	}
	public void testFindByEmail() {
		List<Employe> employe = springDao.findByEmail(emp.getEmail());
		for(Employe e : employe) {
			System.out.println(e.getEmail());
		}
		assertNotNull(employe);
	}
	
	public void testFindBylogin() {
		List<Employe> employe = springDao.findByLogin("logintest");
		System.out.println("Voici le fin by long" + employe);
		assertNotNull(employe);
	}
	
	public void testFindAll() {
		
		List<Employe> employe2 = springDao.findAll();
		System.out.println(employe2);
		assertNotNull(employe2);
	}
}
