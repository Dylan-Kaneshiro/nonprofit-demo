package com.utdallas.capstone.dao;

import com.utdallas.capstone.vo.EventsVO;

import java.util.List;

public interface IEventsDao {
    EventsVO getEventDetails(int id);
    boolean addEvent(EventsVO event);
    List<EventsVO> getEventList();
    List<EventsVO> getEventsByName(String searchParam);
    List<EventsVO> getEventsByOrganization(String searchParam);
    boolean deleteEvent(int id);

}