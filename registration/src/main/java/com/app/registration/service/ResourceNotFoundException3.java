package com.app.registration.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException3 extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException3(String message){
        super(message);
    }
}