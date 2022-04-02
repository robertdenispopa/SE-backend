package com.example.se.repository;

import com.example.se.model.Answer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.UUID;
@Repository
public interface AnswerRepository extends MongoRepository<Answer, UUID> {
    List<Answer> findByQuestionId(UUID question_Id);
}