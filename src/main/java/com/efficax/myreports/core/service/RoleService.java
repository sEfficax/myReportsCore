package com.efficax.myreports.core.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.efficax.myreports.core.domain.Role;
import com.efficax.myreports.core.repository.RoleRepository;

@Component
public class RoleService {
	
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
