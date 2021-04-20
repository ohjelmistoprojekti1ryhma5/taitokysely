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

	// EN TIIÄ TOIMIIKO VIELÄ, MUTTA IDEANA OLISI SAADA TÄHÄN MEIDÄN SURVEY LUOKKAAN
	// TALTEEN KYSYMYKSEN JA VASTAUKSET LISTAMUODOSSA

	// OLI ONGELMAA, ETTÄ TULI JOTAIN BEAN ONGELMIA MUTTA GOOGLAILUN JÄLKEEN TÄMÄ ELEMENT COLLECTION RATKAISI ONGELMAN
	@ElementCollection
	private List<Question> questions;

	@ElementCollection
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
	
	public String getSurveyDate() {
		return surveyDate;
	}

	public void setSurveyDate(String surveyDate) {
		this.surveyDate = surveyDate;
	}

	public List<Question> getQuestion() {
		return questions;
	}

	public List<Answer> getAnswer() {
		return answers;
	}
	
	

}
