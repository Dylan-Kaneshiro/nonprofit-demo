package com.utdallas.capstone.mapper;

import com.utdallas.capstone.vo.OrganizationVO;
import org.apache.ibatis.annotations.*;

import java.util.List;

import static com.utdallas.capstone.constants.RegistrationQueries.*;

@Mapper
public interface RegistrationMapper {

    @Insert(ADD_NEW_ORGANIZATION)
    int addNewOrganization(@Param("organization")OrganizationVO organizationVO);

    @Select(GET_ORGANIZATION_BY_EMAIL)
    String getOrganizationCodeByUserEmail(@Param("userEmail") String userEmail);

    @Select(GET_AUTHORIZED_USER_EMAILS)
    List<String> getAuthorizedUsers();

    @Select(GET_USER_DETAILS_FROM_EMAIL)
    @Results({
            @Result(property = "code", column = "code"),
            @Result(property = "name", column = "name"),
            @Result(property = "email", column = "email")
})
    OrganizationVO getUserDetailsFromEmail(@Param("userEmail") String userEmail);

}
