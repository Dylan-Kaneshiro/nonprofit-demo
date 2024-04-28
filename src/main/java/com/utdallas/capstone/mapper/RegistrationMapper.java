package com.utdallas.capstone.mapper;

import com.utdallas.capstone.vo.OrganizationVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import static com.utdallas.capstone.constants.RegistrationQueries.*;

@Mapper
public interface RegistrationMapper {

    @Insert(ADD_NEW_ORGANIZATION)
    int addNewOrganization(@Param("organization")OrganizationVO organizationVO);

    @Select(GET_ORGANIZATION_BY_EMAIL)
    String getOrganizationCodeByUserEmail(@Param("userEmail") String userEmail);
}
