package com.example.dementia.controller;

import com.example.dementia.Configuration.ResponseHandler;
import com.example.dementia.beans.SectionBody;
import com.example.dementia.beans.SurveyQuestions;
import com.example.dementia.beans.SurveyResponse;
import com.example.dementia.dao.SurveyQuestionsDAO;
import com.example.dementia.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("dementia/PT")
public class PatientAppController {

    @Autowired
    SurveyService surveyService;

    @Autowired
    SurveyQuestionsDAO surveyQuestionsDAO;

    @Autowired
    ResponseHandler responseHandler;

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

    @PostMapping("/addQuestionJson")
    public ResponseEntity<Object> addQuestion(@RequestBody SectionBody sectionBody)
    {
        System.out.println(sectionBody.toString());

        SurveyQuestions surveyQuestions = new SurveyQuestions();
        surveyQuestions.setSectionNo(sectionBody.getSection());
        surveyQuestions.setVersion(sectionBody.getVersion());
        surveyQuestions.setTitle(sectionBody.getTitle());
        surveyQuestions.setSectionBody(sectionBody.getListOfQuestions().toString());
        surveyQuestionsDAO.save(surveyQuestions);
        return responseHandler.generateResponse("", HttpStatus.OK);
    }

}
