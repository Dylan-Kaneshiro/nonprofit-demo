package com.utdallas.capstone.controller;

import com.utdallas.capstone.service.EventsService;
import com.utdallas.capstone.vo.EventsVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class EventsController {

    @Autowired
    private final EventsService eventsService;

    public EventsController(EventsService eventsService) {
        this.eventsService = eventsService;
    }

    @GetMapping(value = "blogs/1")
    public ResponseEntity<EventsVO> getAllEvents() {
        log.info("EventsController :: Getting list of all blogs");
        EventsVO newEvent= eventsService.getEventDetails(1);
        log.info("EventsController :: getAllEvents() -> Returning response {}", newEvent);
        return new ResponseEntity<>(newEvent, HttpStatus.OK);
    }

    @PostMapping(value = "blogs/add")
    public ResponseEntity<EventsVO> addEvent(@RequestBody EventsVO event) {
        log.info("EventsController :: Adding new event: {}", event);
        eventsService.addEvent(event);
        return new ResponseEntity<>(event, HttpStatus.OK);
    }

    @GetMapping(value = "api/v1/newapi/{id}")
    public ResponseEntity<String> randomMethod(@PathVariable int id) {
        log.info("EventsController :: Printing id: {}", id);
        return new ResponseEntity<>(new String("SJKLGJSKLG"), HttpStatus.OK);
    }


}
