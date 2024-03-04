package com.utdallas.capstone.config;


import com.microsoft.sqlserver.jdbc.SQLServerException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<String> handleException(Exception e) {
        return new ResponseEntity<>("An error occurred" + e, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler
    public ResponseEntity<String> handleSQLServerException(SQLServerException e) {
        return new ResponseEntity<>("An error occured in DB Server", HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
