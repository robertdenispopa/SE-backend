package com.example.se.repository;

import com.example.se.model.Question;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.UUID;
@Repository
public interface QuestionRepository extends MongoRepository<Question, UUID> {
}
