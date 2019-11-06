package com.efficaxbs.myreports.core.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
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
import com.efficaxbs.myreports.core.service.PersonService;
import com.efficaxbs.myreports.core.util.MyHttpResponse;
 

@RequestMapping("/MyReports")
@RestController
public class PersonController {
	
	@Autowired
    private Environment env;
    Logger logger = LoggerFactory.getLogger(PersonController.class);

    @RequestMapping(value = "/api/npi/{npiNumber}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> validateByNPI(@PathVariable String npiNumber, HttpServletRequest request, HttpSession httpSession) {
        logger.info("/api/npi/" + npiNumber);
        logger.info("id : " + npiNumber);
        logger.info("client ipAddress : " + request.getRemoteAddr());
        MyHttpResponse response = new MyHttpResponse();
        try {
           
                
                response.setStatus("Success");
                response.setData(null);
                response.setMessage("Test Message from serverf");
                
        } catch (Exception e) {
            // TODO: handle exception
            logger.error(e.getMessage());
            //response = addErrorMessages(response, 7);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

	
	@Autowired 
   private PersonService personService;
	  
	@GetMapping("/persons")
	public List<Person> findAll() {
		return  personService.findAll(); 
	} 
  
	@GetMapping ("/person/{id}")
	public Optional<Person> findById(@PathVariable(value = "id") Long id) {
		return personService.findById(id);
		
	}
	
	@PostMapping ("/person")
	public Person createPerson(@Valid @RequestBody Person person) {
		return personService.save(person);
	}
	
	@DeleteMapping ("person/{id}")
	public ResponseEntity<Person> deletePerson(@PathVariable(value = "/id") Long id){	
		Optional<Person> person = personService.findById(id);
		personService.deleteById(id);
		return ResponseEntity.ok().build();
	} 
}
