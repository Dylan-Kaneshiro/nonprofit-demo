package com.utdallas.capstone.dao;

import com.utdallas.capstone.vo.EventsVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.utdallas.capstone.mapper.EventsMapper;

@Repository
@Slf4j
public class EventsDaoImpl implements IEventsDao {

    private final EventsMapper eventsMapper;
    public EventsDaoImpl(EventsMapper eventsMapper) {
        this.eventsMapper = eventsMapper;
    }


    public EventsVO getEventDetails(int id) {
        log.info("PoolBDaoImpl :: Calling mapper to get event details");
        return eventsMapper.getEventDetail(1);
    }

    public boolean addEvent(EventsVO event) {
        int rowsAffected = eventsMapper.addEvent(event);
        return rowsAffected > 0;

    }
}
