package com.utdallas.capstone.config;


import com.microsoft.sqlserver.jdbc.SQLServerException;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.MyBatisSystemException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.naming.AuthenticationException;

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

    @ExceptionHandler
    public ResponseEntity<String> handleAuthenticationException(AuthenticationException ae) {
        log.error("An error occured while authenticating the request" + ae);
        return new ResponseEntity<>("User is not authorized to perform this action", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler
    public ResponseEntity<String> handleMyBatisSystemException(MyBatisSystemException me) {
        log.error("An error occurred while processing MyBatis SQL Query" + me.getCause());
        return new ResponseEntity<>("Error occurred in MyBatis SQL Query " + me, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
