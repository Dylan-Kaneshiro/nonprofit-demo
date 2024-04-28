package com.utdallas.capstone.service;

import com.utdallas.capstone.dao.IRegistrationDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UtilityService {

    @Autowired
    IRegistrationDao registrationDao;

    public String getOrganizationCodeByUserEmail(String userEmail) {
        log.info("UtilityService :: Fetching organization code based on user email: {}", userEmail);
        return registrationDao.getOrganizationCodeByUserEmail(userEmail);
    }
}
