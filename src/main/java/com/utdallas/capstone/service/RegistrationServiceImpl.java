package com.utdallas.capstone.service;


import com.utdallas.capstone.dao.IRegistrationDao;
import com.utdallas.capstone.vo.OrganizationVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RegistrationServiceImpl implements IRegistrationService {

    @Autowired
    IRegistrationDao registrationDao;

    @Override
    public boolean addNewOrganization(OrganizationVO organization) {
        log.info("Calling RegistrationService to add new user to DB");
        return registrationDao.addNewOrganization(organization);
    }

    public String getOrganizationCodeByUserEmail(String userEmail) {
        return registrationDao.getOrganizationCodeByUserEmail(userEmail);
    }
}
