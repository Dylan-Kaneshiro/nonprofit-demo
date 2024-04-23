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


    public EventsVO getEventDetails(int id) {
        log.info("PoolBDaoImpl :: Calling mapper to get event details");
        return eventsMapper.getEventDetail(id);
    }

    public boolean addEvent(EventsVO event) {
        int rowsAffected = eventsMapper.addEvent(event);
        return rowsAffected > 0;

    }

    public List<EventsVO> getEventList() {
        log.info("EventsDaoImpl :: Fetching event list from mapper");
        return eventsMapper.getEventList();
    }

    public boolean deleteEvent(int id) {
        log.info("EventsDaoImpl :: Deleting event id: {}", id);
        int rowsAffected = eventsMapper.deleteEvent(id);
        return rowsAffected > 0;
    }

    public List<EventsVO> getEventsByName(String searchParam) {
        return eventsMapper.getEventsByName(searchParam);
    }

    public List<EventsVO> getEventsByOrganization(String searchParam) {
        return eventsMapper.getEventsByOrganization(searchParam);
    }

    public boolean transactDonation(EventDonationVO eventDonation, int id) {
        int rowsAffected = eventsMapper.transactDonation(eventDonation, id);
        return rowsAffected > 0;
    }
}
