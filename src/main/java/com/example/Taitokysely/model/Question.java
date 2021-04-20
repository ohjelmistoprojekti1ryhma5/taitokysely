package com.example.Taitokysely.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long questionId;
	private String questionName;
	
	public Question() {	}
	
	public Question(String questionName) {
		super();
		this.questionName = questionName;
	}

	public String getName() {
		return questionName;
	}
	public void setName(String name) {
		this.questionName = name;
	}
	
	public Long getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", name=" + questionName + "]";
	}
}
