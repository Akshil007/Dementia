package com.example.dementia.service.ServiceImpl;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.example.dementia.Configuration.PidEncryptor;
import com.example.dementia.Configuration.ResponseHandler;
import com.example.dementia.beans.Patient;
import com.example.dementia.beans.PatientQueueInfo;
import com.example.dementia.beans.UHID_PID;
import com.example.dementia.dao.PatientDao;
import com.example.dementia.dao.UHID_PID_DAO;
import com.example.dementia.service.PatientService;
import org.hibernate.event.service.internal.EventListenerServiceInitiator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class PatientServiceImpl implements PatientService {

    //waiting queue of patients in doctor app
    ArrayList<PatientQueueInfo> waitingQueue = new ArrayList<>();


    @Autowired
    PatientDao patientDao;

    @Autowired
    UHID_PID_DAO uhid_pid_dao;

    @Autowired
    PidEncryptor pidEncryptor;

    @Autowired
    ResponseHandler responseHandler;

    @Override
    public ResponseEntity<Object> getPatientByUHID(String UHID) {
        Map<String,Object> map = new HashMap<>();
        try {
            Optional<Patient> patients = patientDao.findById(UHID);
            String pid;
            Patient patient;
            if(patients.isPresent())
            {
                patient = patients.get();
                String encryptedUHID = pidEncryptor.convertToDatabaseColumn(UHID);
                pid = uhid_pid_dao.findByUhid(encryptedUHID);
            }
            else
            {
                //=======================================
                //this is dummy code right now. Later we have to write code for fetching data from nimhans
                patient = new Patient( UHID,"abc", 34, "asdfghj", "123456789", "male", "xvy", "987654321");
                patientDao.save(patient);
                //=======================================

                //saving mapping of encrypted uhid to pid
                pid = UUID.randomUUID().toString();
                UHID_PID uhid_pid = new UHID_PID();
                uhid_pid.setPid(pid);
                uhid_pid.setUHIDenc(UHID);
                uhid_pid_dao.save(uhid_pid);
            }

            map.put("PatientData",patient);
            map.put("pid",pid);
            return responseHandler.generateResponse(map,HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return responseHandler.generateResponse(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @Override
    public ResponseEntity<Object> getPatientDemographic(String pid) {

        Patient p;
        try{
            Optional<UHID_PID> pids = uhid_pid_dao.findById(pid);
            if(!pids.isPresent())
            {
                return responseHandler.generateResponse("Patient not found.",HttpStatus.OK);
            }
            p = patientDao.getById(pids.get().getUHIDenc());
            return responseHandler.generateResponse(p,HttpStatus.OK);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return responseHandler.generateResponse(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
