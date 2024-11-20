package com.java_Machine_Test.business_Application.entity;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
public class ErrorResponse {

    private HttpStatus statusCode;
    private String message;

}
