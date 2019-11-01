package com.efficax.myreports.core.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor; 
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.efficax.myreports.core.domain.PersonRole;

public interface PersonRoleRepository extends CrudRepository<PersonRole, Long>,JpaSpecificationExecutor<PersonRole> {
	@Query ("from PersonRole a where a.objectid =:objectid")
	
	public Iterable<PersonRole> findByNpi (@Param (value = "objectid") String objectid);

}
