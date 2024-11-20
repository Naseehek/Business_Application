package com.java_Machine_Test.business_Application.exception;

import com.java_Machine_Test.business_Application.entity.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidRequestException.class)
    public ResponseEntity<ErrorResponse> invalidRequestExceptionHandler(InvalidRequestException ie){
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST, ie.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorResponse> productNotFoundExceptionHandler(ProductNotFoundException pe){
        ErrorResponse er = new ErrorResponse(HttpStatus.NOT_FOUND, pe.getMessage());
        return new ResponseEntity<>(er, HttpStatus.NOT_FOUND);
    }

}
