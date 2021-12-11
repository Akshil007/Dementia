package com.example.dementia.beans;
import java.io.Serializable;
import java.util.List;

public class SectionBody implements Serializable {
    String section;
    String version;
    String title;
    List<QuestionBody> listOfQuestions;

    public SectionBody() {
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<QuestionBody> getListOfQuestions() {
        return listOfQuestions;
    }

    public void setListOfQuestions(List<QuestionBody> listOfQuestions) {
        this.listOfQuestions = listOfQuestions;
    }

    @Override
    public String toString() {
        return "SectionBody{" +
                "section='" + section + '\'' +
                ", version='" + version + '\'' +
                ", title='" + title + '\'' +
                ", listOfQuestions=" + listOfQuestions +
                '}';
    }
}
