package com.utdallas.capstone.dao;

import com.utdallas.capstone.vo.EventDonationVO;
import com.utdallas.capstone.vo.EventsVO;

import java.util.List;

public interface IEventsDao {
    EventsVO getEventDetails(int id);
    boolean addEvent(EventsVO event);
    List<EventsVO> getEventList();
    boolean deleteEvent(int id);

    List<EventsVO> getFilteredEvents(String searchParam, String citySearchParam);

    boolean transactDonation(EventDonationVO eventDonation, int id);

}
