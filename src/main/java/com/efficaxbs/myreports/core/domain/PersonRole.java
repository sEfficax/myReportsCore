package com.efficaxbs.myreports.core.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data; 
@Data
@Entity (name = "personrole") 
public class PersonRole {
	
	@Id
	private Long objectid;
	private Long employeeid;
	private Long roleid;
	
	

}
