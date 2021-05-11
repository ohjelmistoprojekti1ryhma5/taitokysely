package com.example.Taitokysely.model;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends CrudRepository<Answer, Long> {
    
    List<Answer> findByAnswerName(@Param("answerName") String answerName);
    
} 
