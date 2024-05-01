package com.utdallas.capstone.dao;

import com.utdallas.capstone.vo.EventDonationVO;
import com.utdallas.capstone.vo.EventsVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.utdallas.capstone.mapper.EventsMapper;

import java.util.List;

@Repository
@Slf4j
public class EventsDaoImpl implements IEventsDao {

    private final EventsMapper eventsMapper;
    public EventsDaoImpl(EventsMapper eventsMapper) {
        this.eventsMapper = eventsMapper;
    }

    @Override
    public EventsVO getEventDetails(int id) {
        log.info("PoolBDaoImpl :: Calling mapper to get event details");
        return eventsMapper.getEventDetail(id);
    }

    @Override
    public boolean addEvent(EventsVO event) {
        int rowsAffected = eventsMapper.addEvent(event);
        return rowsAffected > 0;

    }

    @Override
    public List<EventsVO> getEventList() {
        log.info("EventsDaoImpl :: Fetching event list from mapper");
        return eventsMapper.getEventList();
    }

    @Override
    public List<EventsVO> getExclusiveEvents(String organizationCode) {
        log.info("EventsDaoImpl :: Fetching events from mapper based on org code: {}", organizationCode);
        return eventsMapper.getExclusiveEvents(organizationCode);
    }

    @Override
    public boolean deleteEvent(int id) {
        log.info("EventsDaoImpl :: Deleting event id: {}", id);
        int rowsAffected = eventsMapper.deleteEvent(id);
        return rowsAffected > 0;
    }

    @Override
    public List<EventsVO> getFilteredEvents(String searchParam, String citySearchParam, String sortParam) {
        return eventsMapper.getFilteredEvents(searchParam, citySearchParam, sortParam);
    }

    @Override
    public boolean transactDonation(EventDonationVO eventDonation, int id) {

        int rowsAffected = eventsMapper.transactDonation(eventDonation, id);
        return rowsAffected > 0;
    }

    @Override
    public boolean incrementViewCountById(int id) {
        int rowsAffected = eventsMapper.incrementEventCountById(id);
        return rowsAffected > 0;
    }

    @Override
    public int getTotalDonationsBasedOnEventId(int id) {
        return eventsMapper.getTotalDonationsBasedOnEventId(id);
    }

    @Override
    public boolean reInstateEventToActive(int id) {
        int rowsAffected = eventsMapper.reInstateEventToActive(id);
        return rowsAffected > 0;
    }
}
