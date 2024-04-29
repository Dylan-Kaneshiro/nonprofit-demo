package com.utdallas.capstone.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor

@Data
public class OrganizationVO {
    private String email;
    private String name;
    private String code;
    private String authorizationCookie;

    public OrganizationVO(String userEmail, String authorizationCookie) {
        this.email = userEmail;
        this.authorizationCookie = authorizationCookie;
    }
}
