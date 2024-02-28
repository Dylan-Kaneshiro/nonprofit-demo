package com.utdallas.capstone.dao;

import com.utdallas.capstone.vo.EventsVO;

public interface IEventsDao {
    EventsVO getEventDetails(int id);
    boolean addEvent(EventsVO event);
}
