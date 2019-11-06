package com.efficaxbs.myreports.core.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.efficaxbs.myreports.core.domain.Role;
import com.efficaxbs.myreports.core.repository.RoleRepository;

@Component
public class RoleServiceImpl {
	
	@Autowired(required = false)
	RoleRepository roleRepository;
	
	
	public List<Role> findAll(){
		return (List<Role>) roleRepository.findAll();
		
	}
	 public Optional<Role> findById(Long id) {
		 return roleRepository.findById(id);
	 }

	 public Role save(Role role) {
		 return roleRepository.save(role);
	 }
	 
	 public Role deleteById(Long id) {
		 roleRepository.deleteById(id);
		return null; 
	 }
	 
}
