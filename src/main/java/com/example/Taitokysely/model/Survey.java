package com.example.Taitokysely.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	// PVM
	private String surveyDate;

	
	//TÄHÄN JÄIN
	
	//@ElementCollection
	@OneToMany
	private List<Question> questions;

	//@ElementCollection
	@OneToMany
	private List<Answer> answers;
	
	public Survey() {
    }

	public Survey(String surveyName, String surveyDate, List<Question> questions, List<Answer> answers ) {
		this.surveyName = surveyName;
		this.surveyDate = surveyDate;
		this.questions = questions;
		this.answers = answers;
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
	
	public String getSurveyDate() {
		return surveyDate;
	}

	public void setSurveyDate(String surveyDate) {
		this.surveyDate = surveyDate;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	
}
