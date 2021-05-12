package com.example.Taitokysely.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyRepository extends CrudRepository<Survey, Long> {
	
	List<Survey> findBySurveyName(@Param("surveyName") String surveyName);
}
