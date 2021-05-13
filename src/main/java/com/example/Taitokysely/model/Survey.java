package com.example.Taitokysely.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Survey {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long surveyId;
	private String surveyName;
	
	/*
	 * 
	 * Yhdellä kyselyllä (Survey) on 
	 * lista kysymyksiä ( List<Question> )
	 * 
	 * */
	@OneToMany
	private List<Question> questions;
	
	public Survey() {
    }

	public Survey(String surveyName) {
		this.surveyName = surveyName;
	}
	
	public Survey(String surveyName, List<Answer> answers ) {
		this.surveyName = surveyName;
	}

	public Long getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(Long surveyId) {
		this.surveyId = surveyId;
	}

	public String getSurveyName() {
		return surveyName;
	}
	
	public void setSurveyName(String surveyName) {
		this.surveyName = surveyName;
	}

	
}
