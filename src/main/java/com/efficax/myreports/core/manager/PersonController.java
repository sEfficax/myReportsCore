package com.efficax.myreports.core.manager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.efficax.myreports.core.domain.Person;
import com.efficax.myreports.core.repository.PersonRepository;

@Component
public class PersonController {  
	
	@Autowired
	PersonRepository personRepository;
    Logger logger = LoggerFactory.getLogger(PersonController.class);
    
      public Person getDetailsById( String num) {
    	   logger.debug("Started : getDetailsById :" + num);
    	    Iterable<Person> datas =personRepository.findByNpi(num);  
    	        Person dto=null;
    	        for (Person data : datas) { 
    	            logger.debug("data listed : getDetailsById :" + data.getUsername());
    	            System.out.println(data.getUsername());
    	            dto=data;
    	  
      }
    	        logger.debug("ended : getDetailsById :" +dto);
    	        return dto;
     }
}

