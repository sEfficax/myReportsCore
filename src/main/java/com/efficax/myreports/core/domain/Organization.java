package com.efficax.myreports.core.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;
import lombok.Getter; 
 
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
