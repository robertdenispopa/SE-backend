package com.example.se.controller;

import com.example.se.model.Answer;
import com.example.se.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping(path = "/answer")

public class AnswerController {

    @Autowired
    private final AnswerService answerService;

    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @GetMapping
    public ResponseEntity<List<Answer>> getAllAnswers() {
        return answerService.getAllAnswers();
    }

    @PostMapping
    public ResponseEntity<Answer> addAnswer(@RequestBody Answer recipe) {
        return answerService.addAnswer(recipe);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<HttpStatus> deleteAnswer(@PathVariable("id") UUID id) {
        return answerService.deleteAnswer(id);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Answer> updateAnswer(@PathVariable("id") UUID id, @RequestBody Answer recipe) {
        return answerService.updateAnswer(id, recipe);
    }
}
