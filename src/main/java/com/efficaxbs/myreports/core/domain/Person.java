package com.efficaxbs.myreports.core.domain;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;

import lombok.Data;

@Data
@Entity (name = "person")

public class Person {
	 

	@Id 
	  @Email
      private Long    objectid;
	  private String  firstname; 
	  private String  lastname;
	  private String  middlename;
	  private String  phonenumber;
      private Date    dateOfBirth;    
	  private String  email;
	  private Long    employeeid;
	  private Long    departmentid;
	  private String  username; 

}
