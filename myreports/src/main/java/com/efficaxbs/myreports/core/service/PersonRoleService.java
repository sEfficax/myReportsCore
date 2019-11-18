package com.efficaxbs.myreports.core.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.efficaxbs.myreports.core.domain.Person;
import com.efficaxbs.myreports.core.domain.PersonRole;
import com.efficaxbs.myreports.core.repository.PersonRoleRepository;

@Component
public interface PersonRoleService {

	public List<PersonRole> findAll();
	
	public PersonRole save(PersonRole personrole);

	public PersonRole deleteById(Long id);

	public PersonRole getDetailsById(Long idNumber);


}
