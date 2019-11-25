package com.efficaxbs.myreports.core.domain;

import lombok.Data;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.Date;

@Entity(name = "user")
@Data
public class User {

    @Id
    /*@GeneratedValue(strategy= GenerationType.AUTO)*/
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userid;
    private Long supervisoruserid;
    private Long usergenderid;

    private String accountname;
    private String commonname;
    private String givenname;//firstname
    private String fullname;
    private String familyname; //lastname
    private String middlename;
    private String phonenumber;
    private String email;
    private String username;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PasswordID", referencedColumnName = "PasswordID")
    private Password password;

    private Date createddate;
    private Date updateddate;
    private char active;
    private String createdbyuserid;
    private String modifiedbyuserid;

    public User(String name, Password password) {
        this.accountname = name;
        this.password = password;
        this.password.setUser(this);
    }
} 

