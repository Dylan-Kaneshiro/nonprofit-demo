package com.utdallas.capstone.constants;

public class EventsQueries {
    private EventsQueries () {}

    public final static String GET_EVENT_DETAILS_BY_ID = "SELECT * FROM EVENTS WHERE \n" +
            "id = #{id} AND event_status = 'A'";

    public final static String ADD_EVENT = "INSERT INTO EVENTS \n" +
            "(title, description, phone, author, address, city, email, code, event_status)\n" +
            "VALUES (#{title}, #{description}, #{phone}, #{author}, #{address}, #{city}, #{email}, #{organizationCode}, 'A')";

    public final static String GET_EVENT_LIST = "SELECT id, title, author FROM EVENTS where event_status = 'A'";

    public final static String REMOVE_EVENTS = "UPDATE events \n"
            + "SET event_status = 'I'\n" +
            "WHERE id = #{id}";

    public final static String GET_EVENTS_BY_NAME = "SELECT * FROM EVENTS WHERE title LIKE '%${searchParam}%' " +
            "and event_status = 'A'";

    public final static String GET_EVENTS_BY_ORGANIZATION = "SELECT * FROM EVENTS WHERE author LIKE '%${searchParam}%'" +
            "and event_status = 'A'";

    public final static String RECORD_DONATION_BY_EVENT_ID = "INSERT INTO donations (event_id, card_number, " +
            "cardholder_name, cvv, expiration_date, donation_amount)\n" +
            "VALUES (#{id}, #{eventDonation.cardNumber}, #{eventDonation.cardHolder}, #{eventDonation.cvv},\n" +
            "#{eventDonation.expiryDate}, #{eventDonation.amount})";

    public final static String GET_FILTERED_EVENTS =
            "<script> \n" +
            "SELECT * from events where \n" +
                    "case when title like '%${searchParam}%' and city like '%${citySearchParam}%' then 1 \n" +
                    "when author like '%${searchParam}%' and city like '%${citySearchParam}%' then 1 \n" +
                    "else 0 end = 1 and event_status = 'A' \n " +
                    "<if test='sortParam != \"none\"'>ORDER BY ${sortParam} DESC</if>\n" +
                    "</script>";

    public final static String GET_ORGANIZATION_EXCLUSIVE_EVENTS = "SELECT * FROM EVENTS WHERE code = #{organizationCode}";

    public final static String INCREMENT_EVENT_COUNT_BY_ID = "UPDATE events SET view_count = view_count + 1\n" +
            "where id = #{id}";

    public final static String GET_TOTAL_DONATIONS_BY_EVENT_ID = "SELECT COALESCE(SUM(donation_amount), 0) from donations where \n" +
            "event_id = #{event_id}";
    public final static String SET_EVENT_STATUS_TO_ACTIVE = "UPDATE events SET event_status = 'A' where id = #{id}";

}
