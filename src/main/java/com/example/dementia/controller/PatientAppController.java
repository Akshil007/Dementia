package com.example.dementia.controller;

import com.example.dementia.beans.SectionBody;
import com.example.dementia.beans.SurveyResponse;
import com.example.dementia.service.SurveyService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("dementia/PT")
public class PatientAppController {

    @Autowired
    SurveyService surveyService;

    @GetMapping("/getNextSection")
    public ResponseEntity<Object> getNextSurveySection()
    {
        return surveyService.getNextSection();
    }

    @GetMapping("/getSpecificSection/{section}/{version}")
    public ResponseEntity<Object> getSpecificSurveySection(@PathVariable String section,@PathVariable String version)
    {
        return surveyService.getSpecificSection(section,version);
    }

    @PostMapping("/saveResponse")
    public ResponseEntity<Object> saveResponse(@RequestBody SurveyResponse surveyResponse)
    {
        return surveyService.saveResponse(surveyResponse);
    }

    @PostMapping("/addSection")
    public ResponseEntity<Object> addQuestion(@RequestBody SectionBody sectionBody) throws JsonProcessingException {
        return surveyService.addQuestion(sectionBody);
    }

}
