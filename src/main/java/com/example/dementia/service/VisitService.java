package com.example.dementia.service;

import com.example.dementia.beans.Visit;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface VisitService {
    public ResponseEntity<Object> getPatientVisitDetails(String pid);
    public ResponseEntity<Object> addVisitDetails(Visit visit);
}
