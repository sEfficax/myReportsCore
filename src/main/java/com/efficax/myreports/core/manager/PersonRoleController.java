package com.efficax.myreports.core.manager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory; 
import org.springframework.beans.factory.annotation.Autowired;

import com.efficax.myreports.core.domain.PersonRole;
import com.efficax.myreports.core.repository.PersonRoleRepository;

public class PersonRoleController {
	@Autowired
	PersonRoleRepository personRoleRepository;
	Logger logger = LoggerFactory.getLogger(PersonRoleController.class);
	
	public 	PersonRole getDetailsById(String num) {
		logger.debug("started : getdeatilsById =:" +num);
		Iterable <PersonRole> datas = personRoleRepository.findByNpi(num);
		PersonRole dto = null;
		for (PersonRole data : datas) {
			logger.debug("data listed : getDetailsById =: " +data.getEmployeeid());
			System.out.println(data.getEmployeeid());
			dto = data;
		}
		logger.debug("ended : getDetailsById =: " +dto); 
		return dto;
	}

}
