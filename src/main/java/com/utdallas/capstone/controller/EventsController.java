package com.utdallas.capstone.controller;

import com.utdallas.capstone.service.IEventsService;
import com.utdallas.capstone.vo.EventsVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@Slf4j
public class EventsController {

    private final IEventsService eventsService;

    public EventsController(IEventsService eventsService) {
        this.eventsService = eventsService;
    }


    @GetMapping(value = "blogs/list")
    public ResponseEntity<List<EventsVO>> getEventList() {
        List<EventsVO> eventList = eventsService.getEventList();
        log.info("Fetched {} records for eventList: {}", eventList.size(), eventList);
        return new ResponseEntity<>(eventList, HttpStatus.OK);
    }


    @GetMapping(value = "blogs/{blogId}")
    public ResponseEntity<EventsVO> getEventDetails(@PathVariable int blogId)  {
        log.info("EventsController :: Getting list of all blogs");
        EventsVO newEvent= eventsService.getEventDetails(blogId);
        log.info("EventsController :: getAllEvents() -> Returning response {}", newEvent);
        return new ResponseEntity<>(newEvent, HttpStatus.OK);
    }


    @PostMapping(value = "blogs/add")
    public ResponseEntity<EventsVO> addEvent(@RequestBody EventsVO event) {
        log.info("EventsController :: Adding new event: {}", event);
        eventsService.addEvent(event);
        return new ResponseEntity<>(event, HttpStatus.OK);
    }


    @DeleteMapping(value = "blogs/delete/{eventId}")
    public ResponseEntity<EventsVO> deleteEventRecord(@PathVariable int eventId) {
        log.info("EventsController :: Calling eventsService to delete event with id: {}", eventId);
        eventsService.deleteEvent(eventId);
        return new ResponseEntity<>(new EventsVO(), HttpStatus.OK);

    }


}
