package com.efficaxbs.myreports.core.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "password")
@Data
public class Password {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long passwordid;

    @OneToOne(mappedBy = "password")
    private User user;

    private String password;
    private String passwordquestion;
    private String passwordanswer;
    private char active;
    private String createdbyuserid;
    private Date createddate;

    public Password(String password) {
        this.password = password;
    }
} 

