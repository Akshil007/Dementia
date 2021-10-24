package com.example.dementia.dao;

import com.example.dementia.beans.Activity;
import com.example.dementia.beans.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayDeque;
import java.util.ArrayList;

public interface ActivityDao extends JpaRepository<Activity,Integer> {
    @Query(value = "select * from activity a where a.pid = :uhid order by a.record_date_time desc ", nativeQuery = true)
    ArrayList<Activity> getActivitySorted(@Param("uhid") String uhid);
}
