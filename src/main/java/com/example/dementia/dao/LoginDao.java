package com.example.dementia.dao;

import com.example.dementia.beans.LoginDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LoginDao extends JpaRepository<LoginDetails,Integer> {
    @Query(value = "select * from login_details l where l.username = :username ", nativeQuery = true)
    List<LoginDetails> findByUsername(@Param("username") String username);
}
