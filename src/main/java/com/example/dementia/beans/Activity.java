package com.example.dementia.beans;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ActivityId;

    @Column
    private String pid;

    @Column
    private String Activity;

    @Column
    private String Details;

    @Column
    private java.sql.Timestamp recordDateTime;

    public Activity() {
    }

    public int getActivityId() {
        return ActivityId;
    }

    public void setActivityId(int activityId) {
        ActivityId = activityId;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getActivity() {
        return Activity;
    }

    public void setActivity(String activity) {
        Activity = activity;
    }

    public String getDetails() {
        return Details;
    }

    public void setDetails(String details) {
        Details = details;
    }

    public Timestamp getRecordDateTime() {
        return recordDateTime;
    }

    public void setRecordDateTime(Timestamp recordDateTime) {
        this.recordDateTime = recordDateTime;
    }

    @Override
    public String toString() {
        return "Activiy{" +
                "pid='" + pid + '\'' +
                ", Activity='" + Activity + '\'' +
                ", Details='" + Details + '\'' +
                ", recordDateTime=" + recordDateTime +
                '}';
    }
}
