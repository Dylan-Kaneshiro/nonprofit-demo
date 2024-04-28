package com.utdallas.capstone.constants;

public class RegistrationQueries {

    public final static String ADD_NEW_ORGANIZATION = "INSERT INTO ORGANIZATIONS (name, code, email)\n" +
            "VALUES (#{organization.name}, #{organization.code}, #{organization.email})";

    public final static String GET_ORGANIZATION_BY_EMAIL = "SELECT code from organizations where \n" +
            "email = #{userEmail}";

    public final static String GET_AUTHORIZED_USER_EMAILS = "SELECT email from organizations";

    public RegistrationQueries() {}
}
