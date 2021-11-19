package com.example.dementia.dao;

import com.example.dementia.beans.ResponseId;
import com.example.dementia.beans.SurveyResponse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyResponseDAO extends JpaRepository<SurveyResponse, ResponseId> {
}
