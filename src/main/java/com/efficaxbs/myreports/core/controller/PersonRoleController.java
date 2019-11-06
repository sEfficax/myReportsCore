package com.efficaxbs.myreports.core.controller;


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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.efficaxbs.myreports.core.domain.Person;
import com.efficaxbs.myreports.core.domain.PersonRole;
import com.efficaxbs.myreports.core.service.PersonRoleService;

@RestController
@RequestMapping("/MyReports1")
public class PersonRoleController {
	@Autowired
	PersonRoleService  prService; 
	
	
	@GetMapping("/persons")
	public List<PersonRole> findAll() {
		return  prService.findAll(); 
	}
  
	@GetMapping ("/person/{id}")
	public Optional<PersonRole> findById(@PathVariable(value = "/id") Long id) {
		return prService.findById(id);
		
	}
	
	@PostMapping ("/person")
	public PersonRole createPerson(@Valid @RequestBody PersonRole personrole) {
		return prService.save(personrole);
	}
	
	@DeleteMapping ("person/{id}")
	public ResponseEntity<Person> deletePerson(@PathVariable(value = "/id") Long id){	
		Optional<PersonRole> person = prService.findById(id);
		prService.deleteById(id);
		return ResponseEntity.ok().build();
	}  

}
