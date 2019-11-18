package com.efficaxbs.myreports.core.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Component;

import com.efficaxbs.myreports.core.domain.Person;
 
@Component 
public interface PersonService {
	   
	public Person getDetailsById(Long id);
	public boolean addPerson(Person person);
	public List<Person> delete(Long id);  
	public List<Person> findAllPersons(); 
	public Person updatePerson(Long id,Person person);
 
}     