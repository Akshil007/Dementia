package com.example.dementia.service;

import com.example.dementia.beans.SurveyResponse;
import org.springframework.http.ResponseEntity;

public interface SurveyService {
    ResponseEntity<Object> getNextSection();
    ResponseEntity<Object> getSpecificSection(String section,String version);

    ResponseEntity<Object> saveResponse(SurveyResponse surveyResponse);
}
