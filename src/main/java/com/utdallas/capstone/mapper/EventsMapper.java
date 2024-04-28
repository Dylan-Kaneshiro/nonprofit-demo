package com.utdallas.capstone.mapper;

import com.utdallas.capstone.vo.EventDonationVO;
import com.utdallas.capstone.vo.EventsVO;
import org.apache.ibatis.annotations.*;

import java.util.List;

import static com.utdallas.capstone.constants.EventsQueries.*;

@Mapper
public interface EventsMapper {
    @Select(GET_EVENT_DETAILS_BY_ID)
    @Results({
            @Result(property = "title", column = "title"),
            @Result(property = "description", column = "description"),
            @Result(property = "author", column = "author"),
            @Result(property = "address", column = "address"),
            @Result(property = "phone", column = "phone"),
            @Result(property = "hours", column = "hours"),
            @Result(property = "email", column = "email"),
            @Result(property = "id", column = "id")
    })
    EventsVO getEventDetail(@Param("id") int id);

    @Insert(ADD_EVENT)
    int addEvent(EventsVO event);

    @Select(GET_EVENT_LIST)
    @Results({
            @Result(property = "title", column = "title"),
            @Result(property = "description", column = "description"),
            @Result(property = "author", column = "author"),
            @Result(property = "address", column = "address"),
            @Result(property = "phone", column = "phone"),
            @Result(property = "hours", column = "hours"),
            @Result(property = "email", column = "email"),
            @Result(property = "id", column = "id")
    })
    List<EventsVO> getEventList();

    @Select(GET_EVENTS_BY_NAME)
    @Results({
            @Result(property = "title", column = "title"),
            @Result(property = "description", column = "description"),
            @Result(property = "author", column = "author"),
            @Result(property = "address", column = "address"),
            @Result(property = "phone", column = "phone"),
            @Result(property = "hours", column = "hours"),
            @Result(property = "email", column = "email"),
            @Result(property = "id", column = "id")
    })
    List<EventsVO> getEventsByName(@Param("searchParam") String searchParam);

    @Select(GET_EVENTS_BY_ORGANIZATION)
    @Results({
            @Result(property = "title", column = "title"),
            @Result(property = "description", column = "description"),
            @Result(property = "author", column = "author"),
            @Result(property = "address", column = "address"),
            @Result(property = "phone", column = "phone"),
            @Result(property = "hours", column = "hours"),
            @Result(property = "email", column = "email"),
            @Result(property = "id", column = "id")
    })
    List<EventsVO> getEventsByOrganization(@Param("searchParam") String searchParam);

    @Select(GET_FILTERED_EVENTS)
    @Results({
            @Result(property = "title", column = "title"),
            @Result(property = "description", column = "description"),
            @Result(property = "author", column = "author"),
            @Result(property = "address", column = "address"),
            @Result(property = "phone", column = "phone"),
            @Result(property = "hours", column = "hours"),
            @Result(property = "email", column = "email"),
            @Result(property = "id", column = "id"),
            @Result(property = "city", column = "city")
    })
    List<EventsVO> getFilteredEvents(@Param("searchParam") String searchParam,
                                     @Param("citySearchParam") String citySearchParam,
                                     @Param("sortParam") String sortParam);

    @Select(GET_ORGANIZATION_EXCLUSIVE_EVENTS)
    @Results({
            @Result(property = "title", column = "title"),
            @Result(property = "description", column = "description"),
            @Result(property = "author", column = "author"),
            @Result(property = "address", column = "address"),
            @Result(property = "phone", column = "phone"),
            @Result(property = "hours", column = "hours"),
            @Result(property = "email", column = "email"),
            @Result(property = "id", column = "id"),
            @Result(property = "city", column = "city"),
            @Result(property = "code", column = "code")
    })
    List<EventsVO> getExclusiveEvents(@Param("organizationCode") String organizationCode);



    @Update(REMOVE_EVENTS)
     int deleteEvent(@Param("id") int id);

    @Update(INCREMENT_EVENT_COUNT_BY_ID)
    int incrementEventCountById(@Param("id") int id);

    @Insert(RECORD_DONATION_BY_EVENT_ID)
    int transactDonation(@Param("eventDonation") EventDonationVO eventDonation, @Param("id") int id);

    @Select(GET_TOTAL_DONATIONS_BY_EVENT_ID)
    int getTotalDonationsBasedOnEventId(@Param("event_id") int id);

}
