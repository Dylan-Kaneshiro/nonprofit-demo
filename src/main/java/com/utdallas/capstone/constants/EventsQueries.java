package com.utdallas.capstone.constants;

public class EventsQueries {
    private EventsQueries () {}

    public final static String GET_EVENT_DETAILS_BY_ID = "SELECT * FROM EVENTS WHERE \n" +
            "id = #{id}";

    public final static String ADD_EVENT = "INSERT INTO EVENTS \n" +
            "(title, description, phone, author, address, email)\n" +
            "VALUES (#{title}, #{description}, #{phone}, #{author}, #{address}, #{email})";
}
