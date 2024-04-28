package com.utdallas.capstone.dao;

import com.utdallas.capstone.mapper.RegistrationMapper;
import com.utdallas.capstone.vo.OrganizationVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RegistrationDaoImpl implements IRegistrationDao {

    @Autowired
    RegistrationMapper registrationMapper;

    @Override
    public boolean addNewOrganization(OrganizationVO organization) {
        return registrationMapper.addNewOrganization(organization) > 0;
    }

    public String getOrganizationCodeByUserEmail(String userEmail) {
        return registrationMapper.getOrganizationCodeByUserEmail(userEmail);
    }
}
