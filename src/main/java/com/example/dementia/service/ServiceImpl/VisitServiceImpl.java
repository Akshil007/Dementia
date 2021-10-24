package com.example.dementia.service.ServiceImpl;

import com.example.dementia.Configuration.ResponseHandler;
import com.example.dementia.beans.Visit;
import com.example.dementia.dao.VisitDao;
import com.example.dementia.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class VisitServiceImpl implements VisitService {

    static String globalPid="";
    static ArrayDeque<Visit> visitList;

    @Autowired
    VisitDao visitDao;

    @Autowired
    ResponseHandler responseHandler;

    @Override
    public ResponseEntity<Object> getPatientVisitDetails(String pid) {
        int noOfRowsAtTime = 5;
        try
        {
            if(!pid.equals(globalPid))
            {
                globalPid = new String(pid);
                visitList = visitDao.getVisitSorted(pid);
            }
            List<Visit> returnList = new ArrayList<>();

            int temp = noOfRowsAtTime;
            while(!visitList.isEmpty() && temp>0)
            {
                returnList.add(visitList.pollFirst());
                temp--;
            }

            return responseHandler.generateResponse(returnList, HttpStatus.OK);

        }
        catch (Exception e) {
            e.printStackTrace();
            return responseHandler.generateResponse(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Object> addVisitDetails(Visit visit) {
        try{
            Date dt = new Date();
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String currentTime = sdf.format(dt);
            visit.setVisitDateTime(parseTimestamp(currentTime));
            visitDao.save(visit);
            return responseHandler.generateResponse("Visit record inserted successfully.",HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return responseHandler.generateResponse("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public java.sql.Timestamp parseTimestamp(String timestamp) {
        SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return new Timestamp(DATE_TIME_FORMAT.parse(timestamp).getTime());
        } catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
