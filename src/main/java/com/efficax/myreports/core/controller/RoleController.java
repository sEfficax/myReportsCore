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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.efficax.myreports.core.domain.Role;
import com.efficax.myreports.core.service.RoleService;

@RestController
@RequestMapping("/MyReports2")
public class RoleController {
	
	
	@Autowired
	RoleService roleService;
	
	@GetMapping("/persons")
	public List<Role> findAll() {
		return  roleService.findAll(); 
	}
  
	@GetMapping ("/person/{id}")
	public Optional<Role> findById(@PathVariable(value = "/id") Long id) {
		return roleService.findById(id);
		
	} 
	 
	@PostMapping ("/person")
	public Role createPerson(@Valid @RequestBody Role role) {
		return roleService.save(role);
	}
	 
	@DeleteMapping ("person/{id}")
	public ResponseEntity<Role> deletePerson(@PathVariable(value = "/id") Long id){	
		Optional<Role> role = roleService.findById(id);
		roleService.deleteById(id);
		return ResponseEntity.ok().build();
	} 
	
	

}
