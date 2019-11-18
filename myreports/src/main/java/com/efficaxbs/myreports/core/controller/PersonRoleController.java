package com.efficaxbs.myreports.core.controller;


import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.efficaxbs.myreports.core.domain.Person;
import com.efficaxbs.myreports.core.domain.PersonRole;
import com.efficaxbs.myreports.core.service.PersonRoleService;
import com.efficaxbs.myreports.core.util.MyHttpResponse;

@RestController
@RequestMapping("/MyReports1")
public class PersonRoleController { 
	@Autowired(required = false)
	PersonRoleService  prService; 
	
	Logger logger = LoggerFactory.getLogger(PersonRoleController.class);
	
	@RequestMapping(value = "/api/id/{idNumber}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> validateByNPI(@PathVariable Long idNumber, HttpServletRequest request,
			HttpSession httpSession) {  
		logger.info("/api/npi/" + idNumber);
		logger.info("id : " + idNumber);
		logger.info("client ipAddress : " + request.getRemoteAddr());
		MyHttpResponse response = new MyHttpResponse(); 
		  
		 try { 
			 PersonRole person = prService.getDetailsById(idNumber);  
			response.setStatus("Success");   
			response.setData(person);  
			response.setMessage("text message");
  
		} catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage()); 
			// response = addErrorMessages(response, 7);
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
		

	}
	
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	
	@GetMapping ("/person/{id}")
	public Optional<PersonRole> findById(@PathVariable(value = "/id") Long id) {
		return personRoleService.findById(id);
		
	}
	
	@PostMapping ("/person")
	public PersonRole createPerson(@Valid @RequestBody PersonRole personrole) {
		return personRoleService.save(personrole);
	}
	
	@DeleteMapping ("person/{id}")
	public ResponseEntity<Person> deletePerson(@PathVariable(value = "/id") Long id){	
		Optional<PersonRole> person = personRoleService.findById(id);
		personRoleService.deleteById(id);
		return ResponseEntity.ok().build();
	}  */

}
