package com.efficaxbs.myreports.core.domain;

import lombok.Data;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity(name = "user")
@Data
public class User {

    @Id
    /*@GeneratedValue(strategy= GenerationType.AUTO)*/
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;
    private String middlename;
    private String phonenumber;
    private String email;
    private String username;
    private String password;
    private Date createddate;
    private Date updateddate;
} 

