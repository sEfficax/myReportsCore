package com.efficax.myreports.core.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.efficax.myreports.core.domain.Person;

public interface PersonRepository extends CrudRepository<Person, Long>, JpaSpecificationExecutor<Person> { 
	 @Query("from Person a where a.objectid=:objectid")
	 public Iterable<Person> findByNpi(@Param(value = "objectid") String objectid); 

}
