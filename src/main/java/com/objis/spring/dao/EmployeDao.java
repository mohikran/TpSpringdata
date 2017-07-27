package com.objis.spring.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.objis.spring.domaine.Employe;

public interface EmployeDao extends JpaRepository<Employe, Integer>{
	
	public List<Employe> findByEmail(String email);

	public void deleteByLogin(String login);
	
	public void deleteByPassword(String login);

	
	public List<Employe> findByLogin(String login);
	
	public void deleteEmployeByid (int id);
}

