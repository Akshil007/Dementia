package com.example.dementia.controller;

import com.example.dementia.Configuration.ResponseHandler;
import com.example.dementia.beans.SectionBody;
import com.example.dementia.beans.SurveyQuestions;
import com.example.dementia.beans.SurveyResponse;
import com.example.dementia.dao.SurveyQuestionsDAO;
import com.example.dementia.service.SurveyService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8081")
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
