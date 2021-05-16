package com.example.Taitokysely.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Answer {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long answerId;
	private String answerName;
	
	/*
	 * Liittää tietyn kysymyksen (Question-luokka) 
	 * tiettyihin vastauksiin (Answer-luokka)
	 * Yhdellä kysymyksellä voi olla monta vastausta (@ManyToOne)
	 * 
	 * */
	@ManyToOne
	private Question question;
	
	public Answer() {}
	/*
	public Answer(String answerName) {
		super();
		this.answerName = answerName;
	} */
	
	public Answer(String answerName, Question question) {
		super();
		this.answerName = answerName;
		this.question = question;
	}
	
	
	public Long getAnswerId() {
		return answerId;
	}
	
	public void setAnswerId(Long answerId) {
		this.answerId = answerId;
	}
	
	
	public String getAnswerName() {
		return answerName;
	}

	public void setAnswerName(String answerName) {
		this.answerName = answerName;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
	
	

}
