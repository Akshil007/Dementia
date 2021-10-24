package com.example.dementia.dao;

import com.example.dementia.beans.Activity;
import com.example.dementia.beans.UHID_PID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface UHID_PID_DAO extends JpaRepository<UHID_PID,String> {
    @Query(value = "select u.pid from uhid_pid u where u.uhidenc = :uhid", nativeQuery = true)
    String findByUhid(@Param("uhid") String uhid);
}
