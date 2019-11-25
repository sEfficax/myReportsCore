package com.efficaxbs.myreports.core.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "Password")
@Data
public class Password {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long passwordid;

    @JsonIgnore
    @OneToOne(mappedBy = "password", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private User user;

    private String password;
    private String passwordquestion;
    private String passwordanswer;
    private boolean active;
    private String createdbyuserid;
    private Date createddate;

    public Password(String password) {
        this.password = password;
        this.createddate = new Date();
    }

    public Password() {
        super();
        this.createddate = new Date();
    }
} 

