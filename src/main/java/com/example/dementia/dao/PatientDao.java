package com.example.dementia.dao;

import com.example.dementia.beans.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface PatientDao extends JpaRepository<Patient,String> {

}
