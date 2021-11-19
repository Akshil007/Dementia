package com.example.dementia.beans;

import javax.persistence.Id;
import java.io.Serializable;

public class ResponseId implements Serializable {

    private int surveyId;

    private int pid;

    public ResponseId(int surveyId, int pid) {
        this.surveyId = surveyId;
        this.pid = pid;
    }
}
