package com.utdallas.capstone.service;

import com.utdallas.capstone.dao.IEventsDao;
import com.utdallas.capstone.vo.EventDonationVO;
import com.utdallas.capstone.vo.EventsVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EventsServiceImpl implements IEventsService {

    private final IEventsDao eventsDao;

    public EventsServiceImpl(IEventsDao eventsDao) {
        this.eventsDao = eventsDao;
    }
    @Override
    public EventsVO getEventDetails(int eventId) {
        log.info("EventsServiceImpl :: Calling eventsDao to fetch event details");
        EventsVO eventDetails = eventsDao.getEventDetails(eventId);
        log.info("Returned event details from DB: {}", eventDetails);
        return eventDetails;
    }

    @Override
    public boolean addEvent(EventsVO event) {
        log.info("EventsService -> Calling EventsDAO to add");
        return eventsDao.addEvent(event);

    }

    @Override
    public List<EventsVO> getEventList() {
        log.info("EventsService :: Calling EventsDAO to fetch event list");
        return eventsDao.getEventList();
    }

    @Override
    public boolean deleteEvent(int id) {
        return eventsDao.deleteEvent(id);
    }

    @Override
    public List<EventsVO> getFilteredEvents(String searchParam, String citySearchParam) {
        List<EventsVO> eventList = eventsDao.getFilteredEvents(searchParam, citySearchParam);
        if(!eventList.isEmpty()) {
            return eventList;
        }
        return null;
    }

    @Override
    public boolean transactDonation(EventDonationVO eventDonation, int id) {
        log.info("Posting donation details for event ID: {} - {}", id, eventDonation);
        return eventsDao.transactDonation(eventDonation, id);
    }
}
