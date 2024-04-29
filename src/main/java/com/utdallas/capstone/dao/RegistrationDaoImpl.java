package com.utdallas.capstone.dao;

import com.utdallas.capstone.mapper.RegistrationMapper;
import com.utdallas.capstone.vo.OrganizationVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RegistrationDaoImpl implements IRegistrationDao {

    @Autowired
    RegistrationMapper registrationMapper;

    @Override
    public boolean addNewOrganization(OrganizationVO organization) {
        return registrationMapper.addNewOrganization(organization) > 0;
    }

    @Override
    public String getOrganizationCodeByUserEmail(String userEmail) {
        return registrationMapper.getOrganizationCodeByUserEmail(userEmail);
    }

    @Override
    public List<String> getAuthorizedUsers() {
        return registrationMapper.getAuthorizedUsers();
    }

    @Override
    public OrganizationVO getUserDetailsFromEmail(String userEmail) {
        return registrationMapper.getUserDetailsFromEmail(userEmail);
    }
}
