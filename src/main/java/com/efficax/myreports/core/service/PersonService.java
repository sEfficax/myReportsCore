package com.efficax.myreports.core.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efficax.myreports.core.domain.Person;
import com.efficax.myreports.core.repository.PersonRepository;

@Service 
public class PersonService {
	
	@Autowired
	PersonRepository personRepository;
	 
	
	public List<Person> findAll(){  
		return (List<Person>) personRepository.findAll();
	}

	public Optional<Person> findById(Long id) {
		return personRepository.findById(id);
		
	}
	
	public Person save(Person person) {
		return personRepository.save(person);
	}
	
	public Person deleteById(Long id) {
		personRepository.deleteById(id);
		return null;
	} 
}
