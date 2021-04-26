package com.example.Taitokysely.model;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Long>{

	List<Question> findByQuestionName(@Param("questionName") String questionName);
}
