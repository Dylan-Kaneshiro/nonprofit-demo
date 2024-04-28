package com.utdallas.capstone.dao;

import com.utdallas.capstone.vo.OrganizationVO;
import org.aspectj.weaver.ast.Or;

import java.util.List;

public interface IRegistrationDao {
    boolean addNewOrganization(OrganizationVO organization);
    String getOrganizationCodeByUserEmail(String userEmail);
    List<String> getAuthorizedUsers();
}
