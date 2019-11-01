package com.efficax.myreports.core.manager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.efficax.myreports.core.domain.Role;
import com.efficax.myreports.core.repository.RoleRepository;

@Component
public class RoleController { 
	
	@Autowired
    RoleRepository roleRepository;
    Logger logger = LoggerFactory.getLogger(RoleController.class);
     
    public Role getDetailsById(String num) {
    	logger.debug("started : getDetailsById :" +num);
    	Iterable<Role> datas = roleRepository.findByNpi(num);
    	Role dto = null;
    	for (Role data : datas) {
    		logger.debug("data listed : getDetailsById : " +data.getRolename());
    		System.out.println(data.getRolename());
    		dto = data;
    	}
    	logger.debug("ended : getDetailsById : " +dto);
    	return dto;
    }
}
