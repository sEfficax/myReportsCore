package com.efficax.myreports.core.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efficax.myreports.core.domain.PersonRole;
import com.efficax.myreports.core.repository.PersonRoleRepository;

@Service
public class PersonRoleService {
	
	
	@Autowired
	PersonRoleRepository pr;
	
	public List<PersonRole> findAll(){
		return (List<PersonRole>) pr.findAll();
	}
	
	public Optional<PersonRole> findById(Long id) {
		return pr.findById(id);
	}
	
  public PersonRole save(PersonRole personrole) {
	  return pr.save(personrole);
  }
	public PersonRole deleteById(Long id) {
		 pr.deleteById(id);
		return null;
	} 
	

}
