package com.efficaxbs.myreports.core.repository;
  
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.efficaxbs.myreports.core.domain.Organization;
 
public interface OrganizationRepository extends CrudRepository<Organization, Long>, JpaSpecificationExecutor<Organization> {
    @Query("from organization a where a.objectid=:objectid")
    public Iterable<Organization> findByNpi(@Param(value = "objectid") String objectid); 
}   
           