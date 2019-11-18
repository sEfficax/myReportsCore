package com.efficaxbs.myreports.core.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.efficaxbs.myreports.core.domain.Person;
import com.efficaxbs.myreports.core.repository.PersonRepository;
import com.efficaxbs.myreports.core.service.PersonService;


@Component 
public class PersonServiceImpl implements PersonService { 
	
       @Autowired(required = false)   
      PersonRepository personRepository;   
    
       public  Person getDetailsById(Long id) {
		Iterable<Person> datas = personRepository.findByobjectId(id);
		Person dto = null;  
		return datas.iterator().next();      
	}
       public List<Person> delete(Long id) {  
  		 personRepository.deleteById(id);
  		 return null; 		 
  	 } 	  
  	  public boolean addPerson(Person person) {
  			  personRepository.save(person);
			return true;
  			   
  		}    
     
   
  	  public List<Person> findAllPersons(){
  		  List<Person> person = new ArrayList<>();
  		  personRepository.findAll().forEach(person::add);
  		  return person; 
      	
  	  }    
  	
      public Person updatePerson(Long id,Person person) {
  	 Person person1 = personRepository.save(person);
  	 return person1;
  	 
   }


}
