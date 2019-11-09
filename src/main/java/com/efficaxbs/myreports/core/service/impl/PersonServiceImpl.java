package com.efficaxbs.myreports.core.service.impl;

import java.util.Iterator; 
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.efficaxbs.myreports.core.domain.Person;
import com.efficaxbs.myreports.core.repository.PersonRepository;
import com.efficaxbs.myreports.core.service.PersonService;

@Component
public  class PersonServiceImpl implements PersonService{
 
	@Autowired(required = false) 
	
	private PersonRepository personRepository;  
 
	public Optional<Person> getDetailsBYId(Long id) {  

		return personRepository.findById(id);
		
	} 

	public List<Person> findAll() {
		return (List<Person>) personRepository.findAll();
	}
 

	public boolean save(Person person) {
		Person newperson = personRepository.save(person);
		return newperson != null;
	       
	} 


	public Person deleteById(Long id) {
		personRepository.deleteById(id);
		return null;
	}

	

	@Override
	public Person getDetailsById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}
