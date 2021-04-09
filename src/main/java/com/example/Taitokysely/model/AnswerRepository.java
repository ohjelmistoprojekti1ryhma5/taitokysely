package com.example.Taitokysely.model;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface AnswerRepository extends CrudRepository<Answer, Long> {
    
    List<Answer> findByName(@Param("name") String name);
} 
