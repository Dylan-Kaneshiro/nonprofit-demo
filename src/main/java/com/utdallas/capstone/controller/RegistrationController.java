package com.utdallas.capstone.controller;

import com.utdallas.capstone.props.CapstoneEnvironmentProp;
import com.utdallas.capstone.service.IRegistrationService;
import com.utdallas.capstone.vo.OrganizationVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController

@RequestMapping(value = "api/v1")
public class RegistrationController {

    @Autowired
    private CapstoneEnvironmentProp environmentProp;

    @Autowired
    private IRegistrationService registrationService;

    @PostMapping(value = "register")
    public ResponseEntity<OrganizationVO> registerNewOrganization(
            @RequestParam(value = "Authorization") String userEmail,
            @RequestBody OrganizationVO organization) throws Exception {
        log.info("RegistrationController :: Enrolling new organization to the application: {}", organization);
        if(!environmentProp.getAuthorizedUsers().contains(userEmail)) {
            log.error("RegistrationController :: User: {} is not authorized to enroll new organization", userEmail);
            String errorMessage = "User " + userEmail + " is not authorized to add new organization";
            throw new Exception(errorMessage);
        }

        registrationService.addNewOrganization(organization);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "auth/{userEmail}")
    public ResponseEntity<String> getAuthorizedUserCookie(@PathVariable("userEmail") String userEmail) {
        log.info("RegistrationContoller :: Getting the user authorization cookie for email: {}", userEmail);
        String cookie = registrationService.getAuthorizationCookie(userEmail);
        return new ResponseEntity<>(cookie, HttpStatus.OK);
    }
}
