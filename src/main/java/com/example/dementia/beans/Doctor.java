package com.example.dementia.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.security.PrivateKey;
import java.util.Objects;

@Entity
public class Doctor {

    @Id
    private String did;

    @Column
    private String name;

    @Column
    private String phoneNo;

    @Column
    private String email;

    public Doctor() {
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "did='" + did + '\'' +
                ", name='" + name + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
