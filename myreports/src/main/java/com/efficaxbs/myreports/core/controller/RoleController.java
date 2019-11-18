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

import com.efficaxbs.myreports.core.domain.Role;
import com.efficaxbs.myreports.core.service.RoleService;

@RestController
@RequestMapping("/MyReports2")
public class RoleController {
	
	
	@Autowired
	RoleService roleService;
	
 
	
	

}
