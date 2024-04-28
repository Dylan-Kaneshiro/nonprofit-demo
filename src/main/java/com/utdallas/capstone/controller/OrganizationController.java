package com.utdallas.capstone.controller;

import com.utdallas.capstone.service.IEventsService;
import com.utdallas.capstone.service.UtilityService;
import com.utdallas.capstone.vo.EventsVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class OrganizationController {

    @Autowired
    private UtilityService utilityService;

    @Autowired
    private IEventsService eventsService;

    @GetMapping(value = "organizations/event-list/{userEmail}")
    public ResponseEntity<List<EventsVO>> getEventsBasedOnOrganization(@PathVariable("userEmail")
                                                                       String userEmail) {
        log.info("OrganizationController :: Getting events exclusive to: {}", userEmail);
        String organizationCode = utilityService.getOrganizationCodeByUserEmail(userEmail);
        List<EventsVO> eventList = eventsService.getExclusiveEvents(organizationCode);
        return new ResponseEntity<>(eventList, HttpStatus.OK);

    }
}
