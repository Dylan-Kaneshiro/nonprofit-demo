package com.utdallas.capstone.service;


import com.utdallas.capstone.constants.WebConstants;
import com.utdallas.capstone.dao.IRegistrationDao;
import com.utdallas.capstone.vo.OrganizationVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public OrganizationVO getUserDetailsFromEmail(String userEmail) {
        log.info("RegistrationService :: Getting user information based on email: {}", userEmail);
        OrganizationVO organizationVO = registrationDao.getUserDetailsFromEmail(userEmail);
        if(organizationVO == null) {
            organizationVO = new OrganizationVO(userEmail, this.getAuthorizationCookie(userEmail));
        }
        organizationVO.setAuthorizationCookie(this.getAuthorizationCookie(userEmail));
        return organizationVO;
    }


    @Override
    public String getAuthorizationCookie(String userEmail) {
        List<String> authorizedUserEmails = registrationDao.getAuthorizedUsers();
        boolean isAuthorized = authorizedUserEmails.contains(userEmail.toLowerCase());
        String cookieValue;
        if(isAuthorized) {
            cookieValue = WebConstants.AUTHORIZED_COOKIE;
            log.info("User: {} is an authorized organization. Building cookie with value: {}", userEmail, cookieValue);
        } else {
            cookieValue = WebConstants.NOT_AUTHORIZED_COOKIE;
            log.info("User: {} is not an authorized organization. Building cookie value with: {}", userEmail, cookieValue);
        }
        return cookieValue;
    }
}
