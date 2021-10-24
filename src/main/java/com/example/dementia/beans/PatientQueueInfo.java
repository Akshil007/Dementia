package com.example.dementia.beans;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class PatientQueueInfo {
    @Id
    String pid;
    @Column
    String name;
    @Column
    int age;
    @Column
    String gender;
    @Column
    String insertInQueueTime;

    public PatientQueueInfo() {
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getInsertInQueueTime() {
        return insertInQueueTime;
    }

    public void setInsertInQueueTime(String insertInQueueTime) {
        this.insertInQueueTime = insertInQueueTime;
    }

    @Override
    public String toString() {
        return "PatientQueueInfo{" +
                "pid='" + pid + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", insertInQueueTime='" + insertInQueueTime + '\'' +
                '}';
    }
}
