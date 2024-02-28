package com.utdallas.capstone.service;

import com.utdallas.capstone.dao.IEventsDao;
import com.utdallas.capstone.vo.EventsVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EventsService {

    private final IEventsDao eventsDao;

    public EventsService(IEventsDao eventsDao) {
        this.eventsDao = eventsDao;
    }

    public EventsVO getEventDetails(int eventId) {
        log.info("EventsServiceImpl :: Calling eventsDao to fetch event details");
        EventsVO eventDetails = eventsDao.getEventDetails(1);
        log.info("Returned event details from DB: {}", eventDetails);
        return eventDetails;
    }

    public boolean addEvent(EventsVO event) {
        log.info("EventsService -> Calling EventsDAO to add");
        return eventsDao.addEvent(event);

    }
}
