package com.example.dementia.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Survey {
    @Id
    private String sectionId;

    @Column
    private String pid;

    @Column
    private String responseJson;

    @Column
    private String timestamp;

    public Survey() {
    }

    public String getSectionId() {
        return sectionId;
    }

    public void setSectionId(String sectionId) {
        this.sectionId = sectionId;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getResponseJson() {
        return responseJson;
    }

    public void setResponseJson(String responseJson) {
        this.responseJson = responseJson;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Survey{" +
                "sectionId='" + sectionId + '\'' +
                ", pid='" + pid + '\'' +
                ", responseJson='" + responseJson + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}
