package com.efficaxbs.myreports.core.repository;

import com.efficaxbs.myreports.core.domain.User;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.PathVariable;


public interface UserRepository extends CrudRepository<User, Long>, JpaSpecificationExecutor<User> {
 
	 @Query("from User a where a.userid=:id")
	 public Iterable<User> findDistinctByUserId(@PathVariable(value = "id") Long id);
    
}    
 
