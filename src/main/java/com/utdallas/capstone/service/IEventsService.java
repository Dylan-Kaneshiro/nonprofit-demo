package com.utdallas.capstone.service;

import com.utdallas.capstone.vo.EventsVO;

import java.util.List;

public interface IEventsService {
    EventsVO getEventDetails(int id);
    List<EventsVO> getEventList();

    boolean addEvent(EventsVO event);
    boolean deleteEvent(int id);
}
