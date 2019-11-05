package com.efficax.myreports.core.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param; 
import com.efficax.myreports.core.domain.Role;

public interface RoleRepository extends CrudRepository<Role, Long >, JpaSpecificationExecutor<Role> {
	@Query ("from Role  a where a.objectid=:objectid")
	
    public Iterable<Role> findByNpi(@Param(value = "objectid") String objectid);
}  