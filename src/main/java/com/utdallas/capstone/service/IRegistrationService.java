package com.utdallas.capstone.service;

import com.utdallas.capstone.vo.OrganizationVO;

public interface IRegistrationService {

    boolean addNewOrganization(OrganizationVO organization);
    String getOrganizationCodeByUserEmail(String userEmail);

    String getAuthorizationCookie(String userEmail);

    OrganizationVO getUserDetailsFromEmail(String userEmail);
}
