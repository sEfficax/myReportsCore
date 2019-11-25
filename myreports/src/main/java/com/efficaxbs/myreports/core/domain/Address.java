package com.efficaxbs.myreports.core.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "UserAddress")
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long useraddressid;

    @ManyToOne
    @JoinColumn(name = "UserID", referencedColumnName = "UserID")
    @JsonIgnore
    private User user;

    private String address1;
    private String address2;
    private String city;
    private String region;
    private String zip;
    private String country;
    private Date createddate;
    private boolean defaultaddress;
    public Address(String country) {
        this.country = country;
        this.createddate = new Date();
    }

    public Address() {
        super();
        this.createddate = new Date();
    }
} 

