package com.efficaxbs.myreports.core.repository;


import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.efficaxbs.myreports.core.domain.Person;

public interface PersonRepository extends CrudRepository<Person, Long>, JpaSpecificationExecutor<Person> { 
	 @Query("from person a where a.objectid=:objectid")
	 public Iterable<Person> findByNpi(@Param(value = "objectid") String objectid); 

}
