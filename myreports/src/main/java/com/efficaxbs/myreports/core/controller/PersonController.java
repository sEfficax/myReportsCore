package com.efficaxbs.myreports.core.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;
import com.efficaxbs.myreports.core.domain.Person; 
import com.efficaxbs.myreports.core.service.PersonService;
import com.efficaxbs.myreports.core.util.MyHttpResponse;


@RequestMapping("/MyReportsPerson")
@RestController  
public class PersonController {
   
	@Autowired    
	private PersonService  personService;
	
	Logger logger = LoggerFactory.getLogger(PersonController.class);


	@RequestMapping(value = "/api/id/{idNumber}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> validateById(@PathVariable Long idNumber, HttpServletRequest request,
			HttpSession httpSession) {  
		logger.info("/api/npi/" + idNumber);
		logger.info("id : " + idNumber);
		logger.info("client ipAddress : " + request.getRemoteAddr());
		MyHttpResponse response = new MyHttpResponse(); 
		 try { 
			Person person = personService.getDetailsById(idNumber); 
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
	
	@RequestMapping (value = "/api/id/{idNumber}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> deleteById(@PathVariable Long idNumber, HttpServletRequest request, HttpSession session){
		logger.info("/api/id/" +idNumber);
		logger.info("id :" +idNumber);
		MyHttpResponse response = new MyHttpResponse();
		try { 
			List<Person> person = personService.delete(idNumber);  
			response.setStatus("success");  
			response.setData(person);
			response.setMessage("deleted");     
  
	 	}catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	@RequestMapping (value = "/api/id", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?>  addPerson(@Valid @RequestBody Person person, HttpServletRequest request, HttpSession session){

		MyHttpResponse response = new MyHttpResponse();
		 
		try {  
			boolean bool = personService.addPerson(person);
		         
		    response.setStatus("success"); 
			response.setData(bool);       
			response.setMessage("successfully saved");       
	   
		}catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(response,HttpStatus.OK); 
	}

	@RequestMapping (value = "/api/id/persons", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAllPersons( HttpServletRequest request, HttpSession session){
 
		MyHttpResponse response = new MyHttpResponse();
		
		try {  
			List<Person> person = personService.findAllPersons(); 
		 	personService.findAllPersons();  
			response.setStatus("success");   
			response.setData(person);   
			response.setMessage("text message");   
		} catch (Exception e) { 
			logger.error(e.getMessage());
			return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
		}
			return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@RequestMapping (value = "/api/id/{idNumber}",method = RequestMethod.PUT , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updatePerson (@PathVariable Long idNumber,@Valid @RequestBody Person person, HttpServletRequest request,HttpSession session){
				logger.info("/api/id/" +idNumber);
				logger.info("id :" +idNumber);
			MyHttpResponse response = new MyHttpResponse(); 
			 
		try {
	 	    Person newPerson = personService.updatePerson(idNumber, person); 
			response.setStatus("success"); 
			response.setData(newPerson); 
			response.setMessage("text message");		   
		}catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
 	   
 }
	
	  
	

	
