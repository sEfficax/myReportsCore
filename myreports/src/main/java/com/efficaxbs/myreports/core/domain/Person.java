package com.efficaxbs.myreports.core.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity(name = "person")
@Data
public class Person {

    @Id
    private Long objectid;
    private String Firstname;
    private String lastname;
    private String middlename;
    private String phonenumber;
    private Date DOB;
    private String email;
    private Long employeeid;
    private Long department_id;
    private String Username;


} 

