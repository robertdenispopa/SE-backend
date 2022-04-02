package com.example.se.controller;

import com.example.se.model.Question;
import com.example.se.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping(path = "/question")

public class QuestionController {

    @Autowired
    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping
    public ResponseEntity<List<Question>> getAllQuestions() {
        return questionService.getAllQuestions();
    }

//    @GetMapping(path = "/{id}")
//    public ResponseEntity<Question> getQuestionById(@PathVariable("id") UUID id) {
//        return questionService.getQuestionById(id);
//    }
//
//    @GetMapping("/valid")
//    public ResponseEntity<Question> getQuestionTitle(@RequestParam String title) {
//        return questionService.getQuestionTitle(title);
//    }

    @PostMapping
    public ResponseEntity<Question> addQuestion(@RequestBody Question recipe) {
        return questionService.addQuestion(recipe);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<HttpStatus> deleteQuestion(@PathVariable("id") UUID id) {
        return questionService.deleteQuestion(id);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Question> updateQuestion(@PathVariable("id") UUID id, @RequestBody Question recipe) {
        return questionService.updateQuestion(id, recipe);
    }
}
