package com.efficaxbs.myreports.core.repository;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.efficaxbs.myreports.core.domain.Person;

 

public interface PersonRepository extends CrudRepository<Person, Long>, JpaSpecificationExecutor<Person> {
 
	 @Query("from person a where a.objectid=:objectid")
	 public Iterable<Person> findByobjectId(@PathVariable(value = "objectid") Long objectid); 
    
}    
 
 