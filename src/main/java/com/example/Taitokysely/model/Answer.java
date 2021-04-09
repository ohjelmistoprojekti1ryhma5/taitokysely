package com.example.Taitokysely.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.swing.JRadioButton;

@Entity
public class Answer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long answerId;
	private String name;
	
	public Long getAnswerId() {
		return answerId;
	}
	
	public Answer(String name) {
		super();
		this.name = name;	
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAnswerId(Long answerId) {
		this.answerId = answerId;
	}

	@Override
	public String toString() {
		return "Answer [answerId=" + answerId + ", name=" + name + "]";
	}
	
}
