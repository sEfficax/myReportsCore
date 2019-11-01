package com.efficax.myreports.core.repository;
 
import com.efficax.myreports.core.domain.Organization;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
 
public interface OrganizationRepository extends CrudRepository<Organization, Long>, JpaSpecificationExecutor<Organization> {
    @Query("from Organization a where a.objectid=:objectid")
    public Iterable<Organization> findByNpi(@Param(value = "objectid") String objectid); 
}   
   