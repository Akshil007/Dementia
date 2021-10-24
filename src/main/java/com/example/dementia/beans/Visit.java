package com.example.dementia.beans;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
public class Visit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int visitId;

    @Column
    private String Did;

    @Column
    private String Pid;

    @Column
    private String visitDetailsJson;

    @Column
    private java.sql.Timestamp visitDateTime;

    @Column
    private java.sql.Date followUpDate;

    public Visit() {
    }

    public int getVisitId() {
        return visitId;
    }

    public void setVisitId(int visitId) {
        this.visitId = visitId;
    }

    public String getDid() {
        return Did;
    }

    public void setDid(String did) {
        Did = did;
    }

    public String getPid() {
        return Pid;
    }

    public void setPid(String pid) {
        Pid = pid;
    }

    public String getVisitDetailsJson() {
        return visitDetailsJson;
    }

    public void setVisitDetailsJson(String visitDetailsJson) {
        this.visitDetailsJson = visitDetailsJson;
    }

    public Timestamp getVisitDateTime() {
        return visitDateTime;
    }

    public void setVisitDateTime(Timestamp visitDateTime) {
        this.visitDateTime = visitDateTime;
    }

    public Date getFollowUpDate() {
        return followUpDate;
    }

    public void setFollowUpDate(Date followUpDate) {
        this.followUpDate = followUpDate;
    }
}
