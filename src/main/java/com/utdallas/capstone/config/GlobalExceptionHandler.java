package com.utdallas.capstone.config;


import com.microsoft.sqlserver.jdbc.SQLServerException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<String> handleException(Exception e) {
        log.error("An error occurred in CapstoneApplication", e);
        return new ResponseEntity<>("An error occurred " + e, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler
    public ResponseEntity<String> handleSQLServerException(SQLServerException e) {
        log.error("An error occurred while carrying out SQL Transaction", e);
        return new ResponseEntity<>("An error occurred in DB Server", HttpStatus.INTERNAL_SERVER_ERROR);
    }


}