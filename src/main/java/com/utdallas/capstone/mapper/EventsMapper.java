package com.utdallas.capstone.mapper;

import com.utdallas.capstone.vo.EventsVO;
import org.apache.ibatis.annotations.*;

import static com.utdallas.capstone.constants.EventsQueries.ADD_EVENT;
import static com.utdallas.capstone.constants.EventsQueries.GET_EVENT_DETAILS_BY_ID;

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
    public EventsVO getEventDetail(@Param("id") int id);

    @Insert(ADD_EVENT)
    public int addEvent(EventsVO event);
}
