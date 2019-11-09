package com.efficaxbs.myreports.core.controller;

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
	private PersonService  ps;
	
	Logger logger = LoggerFactory.getLogger(PersonController.class);


	@RequestMapping(value = "/api/npi/{npiNumber}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> validateByNPI(@PathVariable String npiNumber, HttpServletRequest request,
			HttpSession httpSession) { 
		logger.info("/api/npi/" + npiNumber);
		logger.info("id : " + npiNumber);
		logger.info("client ipAddress : " + request.getRemoteAddr());
		MyHttpResponse response = new MyHttpResponse(); 
		   Person person = new Person();  
		 try { 
          
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
	 
	
	@RequestMapping(value = "/api/npi ", method =RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> save (@Valid @RequestBody Person person, HttpServletRequest request,
			HttpSession httpSession){
    
			logger.info("client ipAddress : "  + request.getRemoteAddr());
			MyHttpResponse response = new MyHttpResponse(); 
		    logger.info("inserting -> {} ",ps.insert(new Person()));
		     
			 try {    
				     boolean bool= ps.insert(person);
				 
		         	response.setStatus("Success"); 
			     	response.setData(person);  
				    response.setMessage("Person succesfully saved"); 

				} catch (Exception e) { 
					// TODO: handle exception
		 			logger.error(e.getMessage());  
		 			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

		 		}
		     		
		     	 return new ResponseEntity<>(response, HttpStatus.OK); 
				   
	      } 
	
	         
       @RequestMapping(value = "/api/npi/{npiNumber} ", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
       public ResponseEntity <?>deletePersonById(@PathVariable String npiNumber, HttpServletRequest request,
   			HttpSession httpSession) {
    		logger.info("deleting -> no of Rows deleted-{}", ps.deleteById(npiNumber));
    		MyHttpResponse response = new MyHttpResponse(); 
    	     Person person = new Person(); 

	     	 try {   

	         	response.setStatus("Success"); 
		     	response.setData(person);  
			    response.setMessage("Person succesfully saved");

			} catch (Exception e) { 
				// TODO: handle exception
	 			logger.error(e.getMessage());  
	 			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

	 		}
	     		
	     	 return new ResponseEntity<>(ps.save(person), HttpStatus.OK); 
			   
      }  
    	     
    	  
    	   
 }
	
	  
	

	
