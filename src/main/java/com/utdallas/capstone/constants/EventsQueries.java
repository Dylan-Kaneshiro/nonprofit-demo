package com.utdallas.capstone.constants;

public class EventsQueries {
    private EventsQueries () {}

    public final static String GET_EVENT_DETAILS_BY_ID = "SELECT * FROM EVENTS WHERE \n" +
            "id = #{id} AND event_status = 'A'";

    public final static String ADD_EVENT = "INSERT INTO EVENTS \n" +
            "(title, description, phone, author, address, email, event_status)\n" +
            "VALUES (#{title}, #{description}, #{phone}, #{author}, #{address}, #{email}, 'A')";

    public final static String GET_EVENT_LIST = "SELECT id, title, author FROM EVENTS where event_status = 'A'";

    public final static String REMOVE_EVENTS = "UPDATE events \n"
            + "SET event_status = 'I'\n" +
            "WHERE id = #{id}";

    public final static String GET_EVENTS_BY_NAME = "SELECT * FROM EVENTS WHERE title LIKE '%${searchParam}%' " +
            "and event_status = 'A'";

    public final static String GET_EVENTS_BY_ORGANIZATION = "SELECT * FROM EVENTS WHERE author LIKE '%${searchParam}%'";
}
