package com.example.Taitokysely.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long questionId;
	protected String questionName;
	
	/*
	 * HUOM! 
	 * Kyselyitä luodessasi luo ensin kysymykset, 
	 * koska vastaus (Answer) ja kysely (Survey) -luokat 
	 * tarvitsevat jo luotuja ID:llisiä kysymyksiä (todennäköisesti)
	 * 
	 * Kysymykset luodaan QuestionRestControllerin metodissa newQuestion
	 * 
	 * */
	public Question() {}
	
	public Question(String questionName) {
		super();
		this.questionName = questionName;
	}

	public String getQuestionName() {
		return questionName;
	}

	public void setQuestionName(String questionName) {
		this.questionName = questionName;
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
