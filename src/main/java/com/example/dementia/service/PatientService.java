package com.example.dementia.service;

import com.example.dementia.beans.Patient;
import com.example.dementia.beans.PatientQueueInfo;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PatientService {
    public ResponseEntity<Object> getPatientByUHID(String UHID);
    public ResponseEntity<Object> getPatientDemographic(String pid);
}
