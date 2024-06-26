package com.utdallas.capstone.controller;

import com.utdallas.capstone.service.IEventsService;
import com.utdallas.capstone.vo.EventDonationVO;
import com.utdallas.capstone.vo.EventsVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.annotation.Repeatable;
import java.util.List;
@Api
@RestController
@Slf4j
public class EventsController {

    private final IEventsService eventsService;

    @Autowired

    public EventsController(IEventsService eventsService) {
        this.eventsService = eventsService;
    }



    @ApiOperation("Gets details for a specific blog with the ID provided")
    @GetMapping(value = "blogs/{blogId}")
    public ResponseEntity<EventsVO> getEventDetails(@ApiParam(value = "blogId", example = "1")
                                                    @PathVariable int blogId) throws Exception {
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

    @ApiOperation(value = "Gets filtered results based on events or organization")
    @GetMapping(value = "blogs/search")
    @ResponseBody
    public ResponseEntity<List<EventsVO>> getFilteredEventsOnNameOrOrganization(
           @ApiParam(value = "searchParam", example = "Event Name")
           @RequestParam(name = "searchParam", required = false) String searchParam,
           @ApiParam(value = "citySearchParam", example = "Richardson")
           @RequestParam(name = "city", required = false) String citySearchParam,
           @ApiParam(name = "sortBy") @RequestParam(value = "sortBy", required = false) String sortParam
    ) {
        log.info("EventsController :: Getting filtered results for search param: {}", searchParam);
        List<EventsVO> eventList;
            eventList = eventsService.getFilteredEvents(searchParam, citySearchParam, sortParam);
        return new ResponseEntity<>(eventList, HttpStatus.OK);
    }


    @PostMapping(value = "blogs/donate")
    public ResponseEntity<EventDonationVO> donateToEvent(@RequestBody EventDonationVO eventDonation) {
        log.info("EventsController :: Donation recorded for event ID: {}", eventDonation.getBlogID());
        eventsService.transactDonation(eventDonation, eventDonation.getBlogID());
        return new ResponseEntity<>(eventDonation, HttpStatus.OK);
    }

    @ApiOperation(value = "API to reinstate an inactive event to active")
    @PostMapping(value = "blogs/{id}/reactivate")
    public ResponseEntity<String> reInstateEventToActive(
            @PathVariable("id") int id) {
        log.info("EventsController :: Reinstating event with id {} to active", id);
        eventsService.reInstateEventToActive(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
