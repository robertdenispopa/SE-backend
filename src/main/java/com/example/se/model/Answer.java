package com.example.se.model;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class Answer {

    @Id
    private UUID id = UUID.randomUUID();
    private UUID questionId;
    private String title;
    private List<String> recipes;

    public Answer() {
    }

    public Answer(UUID id,UUID questionId, String title, List<String> recipes) {
        this.id = id;
        this.questionId = questionId;
        this.title = title;
        this.recipes = recipes;
    }

    public Answer(String title) {
        this.title = title;
    }

    public UUID getId() {
        return id;
    }

    public UUID getQuestion_id() {
        return questionId;
    }

    public void setQuestion_id(UUID questionId) {
        this.questionId = questionId;
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

    public List<String> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<String> recipes) {
        this.recipes = recipes;
    }
}
