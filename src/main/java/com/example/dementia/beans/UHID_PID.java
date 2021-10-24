package com.example.dementia.beans;

import com.example.dementia.Configuration.PidEncryptor;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UHID_PID {

    @Id
    private String pid;

    @Convert(converter = PidEncryptor.class)
    private String UHIDenc;


    public UHID_PID() {
    }

    public String getUHIDenc() {
        return UHIDenc;
    }

    public void setUHIDenc(String UHIDenc) {
        this.UHIDenc = UHIDenc;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }
}
