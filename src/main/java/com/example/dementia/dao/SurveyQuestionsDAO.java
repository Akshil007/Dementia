package com.example.dementia.dao;

import com.example.dementia.beans.SurveyQuestions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface SurveyQuestionsDAO extends JpaRepository<SurveyQuestions,Integer> {

    @Query(value = "select * from surveyquestions where section_no =:section_value and version =: version_value ",nativeQuery = true)
    ArrayList<SurveyQuestions> getSpecificSection(@Param("section_value") String section, @Param("version_value") String version);

    @Query(value = "select * from surveyquestions where section_no =:section_value order by version desc ",nativeQuery = true)
    ArrayList<SurveyQuestions> getNextSection(@Param("section_value") String section);
}
