package com.example.dementia.service.ServiceImpl;

import com.example.dementia.Configuration.ResponseHandler;
import com.example.dementia.beans.QuestionBody;
import com.example.dementia.beans.SectionBody;
import com.example.dementia.beans.SurveyQuestions;
import com.example.dementia.beans.SurveyResponse;
import com.example.dementia.dao.SurveyQuestionsDAO;
import com.example.dementia.dao.SurveyResponseDAO;
import com.example.dementia.service.SurveyService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

@Service
public class SurveyServiceImpl implements SurveyService {

    @Autowired
    SurveyResponseDAO surveyResponseDAO;

    @Autowired
    SurveyQuestionsDAO surveyQuestionsDAO;

    @Autowired
    ResponseHandler responseHandler;

    static int globalCurrentSection = 0;

    @Override
    public ResponseEntity<Object> getSpecificSection(String section,String version) {
        try{
            ArrayList<SurveyQuestions> list = surveyQuestionsDAO.getSpecificSection(section,version);

            if(list.size()==0)
            {
                return responseHandler.generateResponse(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            else
            {
                List<QuestionBody> questionList = convertStringToObject(list.get(0).getSectionBody());

                Map<String,Object> map = new HashMap<>();
                map.put("surveyId",list.get(0).getSurveyId());
                map.put("title",list.get(0).getTitle());
                map.put("Questions",questionList);
                return responseHandler.generateResponse(map,HttpStatus.OK);
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
            return responseHandler.generateResponse(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @Override
    public ResponseEntity<Object> getNextSection() {
        try{
            // here we are returning most recent version of each section starting from section 1.
            globalCurrentSection++;
            ArrayList<SurveyQuestions> list = surveyQuestionsDAO.getNextSection(Integer.toString(globalCurrentSection));
            if(list.size()==0)
            {
                return responseHandler.generateResponse("No more section",HttpStatus.OK);
            }
            else
            {
                List<QuestionBody> questionList = convertStringToObject(list.get(0).getSectionBody());

                Map<String,Object> map = new HashMap<>();
                map.put("surveyId",list.get(0).getSurveyId());
                map.put("title",list.get(0).getTitle());
                map.put("Questions",questionList);
                return responseHandler.generateResponse(map,HttpStatus.OK);
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
            return responseHandler.generateResponse(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Object> saveResponse(SurveyResponse surveyResponse) {
        try {
            surveyResponseDAO.save(surveyResponse);
            return responseHandler.generateResponse("Response Saved Successfully",HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return responseHandler.generateResponse(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @Override
    public ResponseEntity<Object> addQuestion(SectionBody sectionBody) {
        try{
//
//            ObjectMapper objectMapper = new ObjectMapper();
//            String sectionStr = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(sectionBody.getListOfQuestions());
//            System.out.println(sectionStr);
//
//            List<QuestionBody> listQuestions = objectMapper.readValue(sectionStr, new TypeReference<List<QuestionBody>>(){});
//
//            System.out.println(listQuestions.get(0).getOptions().toString());

            String questionsStr = convertObjectToString(sectionBody.getListOfQuestions());

            SurveyQuestions surveyQuestions = new SurveyQuestions();
            surveyQuestions.setSectionNo(sectionBody.getSection());
            surveyQuestions.setVersion(sectionBody.getVersion());
            surveyQuestions.setTitle(sectionBody.getTitle());
            surveyQuestions.setSectionBody(questionsStr);
            surveyQuestionsDAO.save(surveyQuestions);


            return responseHandler.generateResponse("Questions added successfully", HttpStatus.OK);
        }
        catch (Exception e)
        {
            return responseHandler.generateResponse(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    public String convertObjectToString(Object object) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
    }

    public List<QuestionBody> convertStringToObject(String str) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(str, new TypeReference<List<QuestionBody>>(){});
    }
}
