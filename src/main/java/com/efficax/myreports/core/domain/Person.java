package com.efficax.myreports.core.domain;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity (name = "person")

public class Person {
	 
	  @Id
      private Long objectid;
	  private String firstname; 
	  private String lastname;
	  private String middlename;
	  private  Long  phonenumber;
      private  Date  dateOfBirth;   
	  private String email;
	  private Long employee_id;
	  private Long department_id;
	  private String username;
	  
	  
	  
	

}
