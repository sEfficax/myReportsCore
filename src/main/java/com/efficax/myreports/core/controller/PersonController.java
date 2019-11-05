package com.efficax.myreports.core.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.efficax.myreports.core.domain.Person;
import com.efficax.myreports.core.repository.PersonRepository;
import com.efficax.myreports.core.service.PersonService;
 
@RestController
public class PersonController {  
	
	@Autowired 
   PersonService personService;
	  
	@GetMapping("/persons")
	public List<Person> findAll() {
		return  personService.findAll(); 
	} 
  
	@GetMapping ("/person/{id}")
	public Optional<Person> findById(@PathVariable(value = "/id") Long id) {
		return personService.findById(id);
		
	}
	
	@PostMapping ("/person")
	public Person createPerson(@Valid @RequestBody Person person) {
		return personService.save(person);
	}
	
	@DeleteMapping ("person/{id}")
	public ResponseEntity<Person> deletePerson(@PathVariable(value = "/id") Long id){	
		Optional<Person> person = personService.findById(id);
		personService.deleteById(id);
		return ResponseEntity.ok().build();
	} 
}
