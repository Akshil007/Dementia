package com.example.dementia.dao;

import com.example.dementia.beans.PatientQueueInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientQueueDao extends JpaRepository<PatientQueueInfo,String> {
}
