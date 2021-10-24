package com.example.dementia.service;

import com.example.dementia.beans.Activity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ActivityService {
    ResponseEntity<Object> getAcivities(String pid);
}
