package com.efficax.myreports.core.manager;

import com.efficax.myreports.core.domain.Organization;
import com.efficax.myreports.core.repository.OrganizationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyReportsManager {
    @Autowired
    OrganizationRepository organizationRepository;
    Logger logger = LoggerFactory.getLogger(MyReportsManager.class);
    public Organization getDetailsById(String num) {
        logger.debug("Started : getDetailsById :" + num);
        Iterable<Organization> datas = organizationRepository.findByNpi(num);
        Organization dto=null;
        for (Organization data : datas) {
            logger.debug("data listed : getDetailsById :" + data.getOrgname());
            System.out.println(data.getOrgname());
            dto=data;
        }
        logger.debug("ended : getDetailsById :" +dto);
        return dto;
    }
}
