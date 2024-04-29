package com.utdallas.capstone.constants;

public class RegistrationQueries {

    public final static String ADD_NEW_ORGANIZATION = "INSERT INTO ORGANIZATIONS (name, code, email)\n" +
            "VALUES (#{organization.name}, #{organization.code}, #{organization.email})";

    public final static String GET_ORGANIZATION_BY_EMAIL = "SELECT code from organizations where \n" +
            "email = #{userEmail}";

    public final static String GET_AUTHORIZED_USER_EMAILS = "SELECT email from organizations";

    public final static String GET_USER_DETAILS_FROM_EMAIL = "SELECT * from organizations where email = #{userEmail}";

    public RegistrationQueries() {}
}
