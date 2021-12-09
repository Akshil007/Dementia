package com.example.dementia.beans;

import java.io.Serializable;
import java.util.List;

public class QuestionBody implements Serializable {
    String question;
    List<String> options;

    public QuestionBody() {
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }
}
