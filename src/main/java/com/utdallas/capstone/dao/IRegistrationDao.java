package com.utdallas.capstone.dao;

import com.utdallas.capstone.vo.OrganizationVO;
import org.aspectj.weaver.ast.Or;

public interface IRegistrationDao {
    boolean addNewOrganization(OrganizationVO organization);
    String getOrganizationCodeByUserEmail(String userEmail);
}
