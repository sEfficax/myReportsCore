package com.efficaxbs.myreports.core.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.efficaxbs.myreports.core.domain.Person;
import com.efficaxbs.myreports.core.domain.PersonRole;
import com.efficaxbs.myreports.core.repository.PersonRoleRepository;
import com.efficaxbs.myreports.core.service.PersonRoleService;


public class PersonRoleServiceImpl implements PersonRoleService{
	
	
	@Autowired(required = false)
	PersonRoleRepository pr;
	
	
    public  PersonRole getDetailsById(Long id) {
		Iterable<PersonRole> datas = pr.findByobjectId(id);
		Person dto = null;  
		return datas.iterator().next();     
	}  
	
  public PersonRole save(PersonRole personrole) {
	  return pr.save(personrole);
  }
	public PersonRole deleteById(Long id) {
		 pr.deleteById(id);
		return null;
	}

	@Override
	public List<PersonRole> findAll() {
		// TODO Auto-generated method stub
		return null;
	}


	

}
