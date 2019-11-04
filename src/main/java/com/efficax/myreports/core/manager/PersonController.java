 package com.efficax.myreports.core.manager;
 
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

@RestController
public class PersonController {  
	
	@Autowired 
	PersonRepository personRepository;
	
	@GetMapping("/users")
	public Iterable<Person> findAllUsers() {
		return  personRepository.findAll(); 
	}
 
	@GetMapping 
	public Optional<Person> findById(@PathVariable(value = "objectid") Long objectId) {
		return personRepository.findById(objectId);
		
	}
	
	@PostMapping ("/users")
	public Person createPerson(@Valid @RequestBody Person person) {
		return personRepository.save(person);
	}
	
	@DeleteMapping ("users/{id}")
	public ResponseEntity<Person> deletePerson(@PathVariable(value = "objectid") Long objectId){	
		Optional<Person> person = personRepository.findById(objectId);
		personRepository.deleteById(objectId);
		return ResponseEntity.ok().build();
	} 

}

