package com.example.se.service;

import com.example.se.model.Answer;
import com.example.se.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AnswerService {

    private final AnswerRepository answerRepository;

    @Autowired
    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    public ResponseEntity<List<Answer>> getAllAnswers() {
        try {
            List<Answer> answers = new ArrayList<>();

            answerRepository.findAll().forEach(answers::add);

            if (answers.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {

                return new ResponseEntity<>(answers, HttpStatus.OK);
            }
        } catch (Exception e) {
            System.out.println(HttpStatus.INTERNAL_SERVER_ERROR);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    public ResponseEntity<Answer> addAnswer(Answer answer) {
        try {
            Answer newAnswer = answerRepository.save(new Answer(answer.getQuestionId(), answer.getTitle(), (ArrayList<String>) answer.getRecipes()));
            return new ResponseEntity<>(newAnswer, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(HttpStatus.INTERNAL_SERVER_ERROR);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    public ResponseEntity<HttpStatus> deleteAnswer(UUID id) {
        try {
            answerRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        } catch (Exception e) {
            System.out.println(HttpStatus.INTERNAL_SERVER_ERROR);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Answer> updateAnswer(UUID id, Answer answer) {
        Optional<Answer> answerData = answerRepository.findById(id);

        if (answerData.isPresent()) {
            Answer updatedAnswer = answerData.get();
            updatedAnswer.setTitle(answer.getTitle());
            return new ResponseEntity<>(answerRepository.save(updatedAnswer), HttpStatus.OK);
        } else {
            System.out.println(HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
