package com.example.dementia.Configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ResponseHandler {
    public ResponseEntity<Object> generateResponse(Object responseObj, HttpStatus status) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("data", responseObj);
        map.put("status", status.value());


        return new ResponseEntity<Object>(map,status);
    }
}
