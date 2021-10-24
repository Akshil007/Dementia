package com.example.dementia.service.ServiceImpl;

import com.example.dementia.Configuration.ResponseHandler;
import com.example.dementia.beans.Patient;
import com.example.dementia.beans.PatientQueueInfo;
import com.example.dementia.beans.UHID_PID;
import com.example.dementia.dao.PatientDao;
import com.example.dementia.dao.PatientQueueDao;
import com.example.dementia.dao.UHID_PID_DAO;
import com.example.dementia.service.QueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class QueueServiceImpl implements QueueService {
    @Autowired
    UHID_PID_DAO uhid_pid_dao;

    @Autowired
    PatientDao patientDao;

    @Autowired
    PatientQueueDao patientQueueDao;

    @Autowired
    ResponseHandler responseHandler;

    @Override
    public ResponseEntity<Object> addToQ(String pid) {

        try{
            String uhid = "";
            Optional<UHID_PID> pidList = uhid_pid_dao.findById(pid);
            String msg = "";
            if(!pidList.isPresent())
            {
                return responseHandler.generateResponse("Patient not found.",HttpStatus.OK);
            }
            else
            {
                uhid = pidList.get().getUHIDenc();
            }

            Optional<Patient> patients = patientDao.findById(uhid);
            Patient patient = patients.get();

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            String nowStr = now.format(dtf);
            PatientQueueInfo patientQueueInfo = new PatientQueueInfo();
            patientQueueInfo.setPid(pid);
            patientQueueInfo.setAge(patient.getAge());
            patientQueueInfo.setName(patient.getName());
            patientQueueInfo.setGender(patient.getGender());
            patientQueueInfo.setInsertInQueueTime(nowStr);

            //insert in queue
            patientQueueDao.save(patientQueueInfo);

            return responseHandler.generateResponse("Patient inserted in queue successfully.",HttpStatus.OK);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return responseHandler.generateResponse(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @Override
    public ResponseEntity<Object> removeFromQ(String pid) {
        try{
            patientQueueDao.deleteById(pid);
            return responseHandler.generateResponse("Patient is deleted from queue successfully.",HttpStatus.OK);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return responseHandler.generateResponse(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Object> getAllPatientInQ() {
        try{
            List<PatientQueueInfo>  list= patientQueueDao.findAll();
            return responseHandler.generateResponse(list,HttpStatus.OK);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return responseHandler.generateResponse(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
