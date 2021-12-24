package com.example.dementia.service.ServiceImpl;

import com.example.dementia.Configuration.ResponseHandler;
import com.example.dementia.beans.Activity;
import com.example.dementia.dao.ActivityDao;
import com.example.dementia.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    ActivityDao activityDao;

    @Autowired
    ResponseHandler responseHandler;

    @Override
    public ResponseEntity<Object> getAcivities(String pid) {
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            List<Activity> l = activityDao.getActivitySorted(pid);
            map.put("ListOfActivites",l);
            return responseHandler.generateResponse(map, HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ResponseEntity<Object> recordActivity(Activity activity) {
        try {
            activityDao.save(activity);
            return responseHandler.generateResponse("Activity Recorded Successfully", HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
