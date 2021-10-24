package com.example.dementia.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "Patient")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Patient {

    @Id
    @Column
    private String uhid;

    @Column
    private String name;

    @Column
    private int age;

    @Column
    private String address;

    @Column
    private String phoneNo;

    @Column
    private String gender;

    @Column
    private String primaryContactName;

    @Column
    private String pcPhoneNo;

    public Patient() {
    }

    public Patient(String uhid, String name, int age, String address, String phoneNo, String gender, String primaryContactName, String pcPhoneNo) {
        this.uhid = uhid;
        this.name = name;
        this.age = age;
        this.address = address;
        this.phoneNo = phoneNo;
        this.gender = gender;
        this.primaryContactName = primaryContactName;
        this.pcPhoneNo = pcPhoneNo;
    }

    public String getUhid() {
        return uhid;
    }

    public void setUhid(String uhid) {
        this.uhid = uhid;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPrimaryContactName() {
        return primaryContactName;
    }

    public void setPrimaryContactName(String primaryContactName) {
        this.primaryContactName = primaryContactName;
    }

    public String getPcPhoneNo() {
        return pcPhoneNo;
    }

    public void setPcPhoneNo(String pcPhoneNo) {
        this.pcPhoneNo = pcPhoneNo;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "uhid='" + uhid + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", gender='" + gender + '\'' +
                ", primaryContactName='" + primaryContactName + '\'' +
                ", pcPhoneNo='" + pcPhoneNo + '\'' +
                '}';
    }
}
