package com.example.Taitokysely.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Answer {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long answerId;
	private String answerName;
	
	public Answer() { }
	
	public Answer(String answerName) {
		super();
		this.answerName = answerName;
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

	@Override
	public String toString() {
		return "Answer [answerId=" + answerId + ", answerName=" + answerName + "]";
	}

}
