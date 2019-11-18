package com.efficaxbs.myreports.core.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.efficaxbs.myreports.core.domain.Role;

public interface RoleRepository extends CrudRepository<Role, Long >, JpaSpecificationExecutor<Role> {
	@Query ("from role  a where a.id=:objectid")
	
    public Iterable<Role> findByNpi(@Param(value = "objectid") String objectid);
}  