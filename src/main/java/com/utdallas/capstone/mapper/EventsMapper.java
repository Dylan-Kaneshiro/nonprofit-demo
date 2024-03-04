package com.utdallas.capstone.mapper;

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

    @Update(REMOVE_EVENTS)
    public int deleteEvent(@Param("id") int id);
}