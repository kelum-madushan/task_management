package com.threerive.taskmanagement.config;

import com.threerive.taskmanagement.constant.LoggerConstants;
import com.threerive.taskmanagement.dto.response.GenericResponse;
import com.threerive.taskmanagement.exception.CustomValidationException;
import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ValidationExceptionConfig {
    private static final Logger log = LoggerFactory.getLogger(ValidationExceptionConfig.class);

    @ExceptionHandler(ConstraintViolationException.class)
    public final ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex) {
        GenericResponse response = new GenericResponse();
        response.setStatus(HttpStatus.BAD_REQUEST);
        response.setResponse(ex.getMessage());
        log.error(LoggerConstants.VALIDATION_FAIL_RESPONSE, ex);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public final ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentException ex) {
        GenericResponse response = new GenericResponse();
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        response.setResponse(ex.getMessage());
        log.error(LoggerConstants.EXCEPTION_OCCURRED, ex);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NullPointerException.class)
    public final ResponseEntity<Object> handleNullPointerException(NullPointerException ex) {
        GenericResponse response = new GenericResponse();
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        response.setResponse(ex.getMessage());
        log.error(LoggerConstants.EXCEPTION_OCCURRED, ex);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(CustomValidationException.class)
    public final ResponseEntity<GenericResponse> handleCustomValidationException(CustomValidationException ex) {
        GenericResponse response = new GenericResponse();
        response.setStatus(HttpStatus.PRECONDITION_REQUIRED);
        response.setMessage(ex.getMessage());
        log.error(LoggerConstants.VALIDATION_FAIL_RESPONSE, ex);
        return new ResponseEntity<>(response, HttpStatus.PRECONDITION_REQUIRED);
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity <Object> handleException(Exception ex) {
        log.error(LoggerConstants.EXCEPTION_OCCURRED, ex);
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
