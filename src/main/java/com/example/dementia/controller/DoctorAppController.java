package com.example.dementia.controller;

import com.example.dementia.beans.Activity;
import com.example.dementia.beans.Patient;
import com.example.dementia.beans.PatientQueueInfo;
import com.example.dementia.beans.Visit;
import com.example.dementia.service.ActivityService;
import com.example.dementia.service.PatientService;
import com.example.dementia.service.QueueService;
import com.example.dementia.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

@RestController
@RequestMapping("dementia/DOC")
public class DoctorAppController {

    @Autowired
    PatientService patientService;

    @Autowired
    VisitService visitService;

    @Autowired
    ActivityService activityService;

    @Autowired
    QueueService queueService;


    //when admin wants patient data from nimhans
    //(on "confirm" button and we will return patient object in this only)
    //(on "show demogrphic details" button frontend will show patient data that we have sent)
    @GetMapping("/getPatientByUHID/{UHID}")
    public ResponseEntity<Object> getPatientByUHID(@PathVariable String UHID)
    {
        return patientService.getPatientByUHID(UHID);
    }



    //when you press "submit" button on add patient page
    //here response will be
    //SUCCESS - for success
    //NOT FOUND - if patient not found by given pid
    //ERROR - if error occurs
    @GetMapping("/addToQ/{pid}")
    public ResponseEntity<Object> addPatientToQ(@PathVariable String pid)
    {
        return queueService.addToQ(pid);
    }

    //on click "view" on landing page this will be called and patient will e removed from Q
    @GetMapping("/removeFromQ/{pid}")
    public ResponseEntity<Object> removeFromQ(@PathVariable String pid)
    {
        return queueService.removeFromQ(pid);
    }


    //this will return all patient from Q
    @GetMapping("/getAllPatientInQ")
    public ResponseEntity<Object> getAllPatientInQ()
    {
        return queueService.getAllPatientInQ();
    }


    //this will get patient demographic details of patient
    @GetMapping("/getPatientDemographic/{pid}")
    public ResponseEntity<Object> getPatientDemographic(@PathVariable String pid)
    {
        return patientService.getPatientDemographic(pid);
    }

    //this will return all visitDetails of patient in reverse chronological order
    //at a time 5 records and then next 5 records
    @GetMapping("/getPatientVisitDetails/{pid}")
    public ResponseEntity<Object> getPatientVisitDetails(@PathVariable String pid)
    {
        return visitService.getPatientVisitDetails(pid);
    }


    //this will record treatment plan and all visit details given by doctor
    @PostMapping("/addVisitDetails")
    public ResponseEntity<Object> addVisitDetails(@RequestBody Visit visit)
    {
        return visitService.addVisitDetails(visit);
    }


    //this will return all activities recorded by particular patient in least recently recorded fashion
    @GetMapping("/getActivityDetails/{pid}")
    public ResponseEntity<Object> getActivityDetails(@PathVariable String pid)
    {
        return activityService.getAcivities(pid);
    }


}
