package com.efficaxbs.myreports.core.domain;

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
	  private String phonenumber;
      private  Date  dateOfBirth;    
	  private String email;
	  private Long employee_id;
	  private Long department_id;
	  private String username;
	public Long getObjectid() {
		return objectid;
	}
	public void setObjectid(Long objectid) {
		this.objectid = objectid;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getMiddlename() {
		return middlename;
	}
	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(Long employee_id) {
		this.employee_id = employee_id;
	}
	public Long getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(Long department_id) {
		this.department_id = department_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	  
	  
	  
	

}
