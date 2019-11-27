package com.efficaxbs.myreports.core.domain;

import com.efficaxbs.myreports.core.security.PBE;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "Password")
@Data
public class Password {

    @Autowired
    @JsonIgnore
    @Transient
    private Environment env;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long passwordid;

    @JsonIgnore
    @OneToOne(mappedBy = "password", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private User user;

    //@ColumnTransformer(read = "PBE.decrypt(password, 'env.getProperty(\"private.key\")')", write = "PBE.encrypt(?, 'env.getProperty(\"private.key\")')")
    private String password;

    /*public String getPassword() {
        if(password==null)
            return password;
        return PBE.decrypt(password,env.getProperty("private.key"));
    }

    public void setPassword(String password) {
        this.password = PBE.encrypt(password,env.getProperty("private.key"));
    }*/

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

