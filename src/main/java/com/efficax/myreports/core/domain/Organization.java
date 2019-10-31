package com.efficax.myreports.core.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity(name = "organization")
public class Organization {

    @Id
    private Long objectid;
    private String type;
    private String orgname;
    private Long parent;
    private String status;

}
