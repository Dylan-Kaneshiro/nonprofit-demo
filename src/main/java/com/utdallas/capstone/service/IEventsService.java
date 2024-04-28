package com.utdallas.capstone.service;

import com.utdallas.capstone.vo.EventDonationVO;
import com.utdallas.capstone.vo.EventsVO;

import java.util.List;

public interface IEventsService {
    EventsVO getEventDetails(int id) throws Exception;
    List<EventsVO> getEventList();
    List<EventsVO> getFilteredEvents(String searchParam, String citySearchParam, String sortParam);

    /*
    * This method will get the events that are exclusive to a certain organization based ont the code.
    * */
    List<EventsVO> getExclusiveEvents(String organizationCode);

    boolean transactDonation(EventDonationVO eventDonation, int id);

    boolean addEvent(EventsVO event);
    boolean deleteEvent(int id);


}
