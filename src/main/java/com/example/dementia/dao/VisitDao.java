package com.example.dementia.dao;

import com.example.dementia.beans.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayDeque;
import java.util.List;

public interface VisitDao extends JpaRepository<Visit,Integer> {

    @Query(value = "select * from visit v where v.pid = :uhid order by v.visit_date_time desc ", nativeQuery = true)
    ArrayDeque<Visit> getVisitSorted(@Param("uhid") String uhid);

}
