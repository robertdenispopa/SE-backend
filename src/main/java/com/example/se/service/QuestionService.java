package com.example.se.service;

import com.example.se.model.Answer;
import com.example.se.model.Question;
import com.example.se.repository.AnswerRepository;
import com.example.se.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;

    @Autowired
    public QuestionService(QuestionRepository questionRepository, AnswerRepository answerRepository) {
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
    }

    public ResponseEntity<List<Question>> getAllQuestions() {
        try {
            List<Question> questions = new ArrayList<>();

            questionRepository.findAll().forEach(questions::add);

            if (questions.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                questions.forEach(question ->{
                    List<Answer> answers = answerRepository.findByQuestionId(question.getId());
                     question.setAnswers(answers); ;
                });
            }

            return new ResponseEntity<>(questions, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(HttpStatus.INTERNAL_SERVER_ERROR);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    public ResponseEntity<Question> addQuestion(Question question) {
        try {
            Question newQuestion = questionRepository.save(new Question(question.getTitle()));
            return new ResponseEntity<>(question, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(HttpStatus.INTERNAL_SERVER_ERROR);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    public ResponseEntity<HttpStatus> deleteQuestion(UUID id) {
        try {
            questionRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        } catch (Exception e) {
            System.out.println(HttpStatus.INTERNAL_SERVER_ERROR);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Question> updateQuestion(UUID id, Question question) {
        Optional<Question> questionData = questionRepository.findById(id);

        if (questionData.isPresent()) {
            Question updatedQuestion = questionData.get();
            updatedQuestion.setTitle(question.getTitle());
            return new ResponseEntity<>(questionRepository.save(updatedQuestion), HttpStatus.OK);
        } else {
            System.out.println(HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
