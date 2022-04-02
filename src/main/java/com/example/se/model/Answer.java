package com.example.se.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class Answer {

    @Id
    private UUID id = UUID.randomUUID();
    private UUID questionId;
    private String title;
    private ArrayList<String> recipes;

    public Answer() {
    }

    public Answer(UUID questionId, String title, ArrayList<String> recipes) {
        this.questionId = questionId;
        this.title = title;
        this.recipes = recipes;
    }

    public Answer(String title) {
        this.title = title;
    }

    public Answer(String title, UUID questionId) {
        this.questionId = questionId;
        this.title = title;
    }

    public UUID getId() {
        return id;
    }

    public UUID getQuestionId() {
        return questionId;
    }

    public void setQuestionId(UUID questionId) {
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

    public void setRecipes(ArrayList<String> recipes) {
        this.recipes = recipes;
    }
}
