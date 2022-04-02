package com.example.se.model;

import java.util.List;
import java.util.UUID;

public class Question {

    private UUID id = UUID.randomUUID();
    private String title;
    private List<Answer> answers;

    public Question() {
    }

    public Question(UUID id, String title, List<Answer> answers) {
        this.id = id;
        this.title = title;
        this.answers = answers;
    }

    public Question(String title) {
        this.title = title;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
