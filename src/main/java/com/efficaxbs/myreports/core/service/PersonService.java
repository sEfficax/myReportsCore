package com.efficaxbs.myreports.core.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Component;

import com.efficaxbs.myreports.core.domain.Person;

@Component
public interface PersonService {
 
	public Person getDetailsById(Long id);

	public List<Person> findAll(); 

	public Person deleteById(Long id);  

	public boolean save(Person person);
	
	 
 
 
} 
  