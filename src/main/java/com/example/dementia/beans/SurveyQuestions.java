package com.example.dementia.beans;

import javax.persistence.*;


@Entity
@Table(uniqueConstraints={
        @UniqueConstraint(columnNames = {"section_no","version"})})
public class SurveyQuestions {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int surveyId;

    @Column(name = "section_no")
    private String sectionNo;

    @Column(name = "version")
    private String version;

    @Column
    private String title;

    @Column
    private String sectionBody;

    public SurveyQuestions() {
    }

    public int getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(int surveyId) {
        this.surveyId = surveyId;
    }

    public String getSectionNo() {
        return sectionNo;
    }

    public void setSectionNo(String sectionNo) {
        this.sectionNo = sectionNo;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getSectionBody() {
        return sectionBody;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSectionBody(String sectionBody) {
        this.sectionBody = sectionBody;
    }
}
