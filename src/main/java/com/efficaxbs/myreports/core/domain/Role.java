package com.efficaxbs.myreports.core.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity (name = "role")
public class Role {
	 
	@Id 
	private Long id;
	private String rolename;
	private String description;

}
