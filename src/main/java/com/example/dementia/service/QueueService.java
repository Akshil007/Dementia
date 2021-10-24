package com.example.dementia.service;

import org.springframework.http.ResponseEntity;

public interface QueueService {
    ResponseEntity<Object> addToQ(String pid);
    ResponseEntity<Object> removeFromQ(String pid);
    ResponseEntity<Object> getAllPatientInQ();
}
