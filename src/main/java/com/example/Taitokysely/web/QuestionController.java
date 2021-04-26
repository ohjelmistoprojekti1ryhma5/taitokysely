package com.example.Taitokysely.web;

import java.util.List;

import javax.swing.JRadioButton;

import org.apache.tomcat.util.buf.Asn1Writer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Taitokysely.model.Answer;
import com.example.Taitokysely.model.AnswerRepository;
import com.example.Taitokysely.model.Question;
import com.example.Taitokysely.model.QuestionRepository;
import com.example.Taitokysely.model.Survey;
import com.example.Taitokysely.model.SurveyRepository;

@RestController
public class QuestionController {

	@Autowired
	private AnswerRepository arepository;

	@Autowired
	private QuestionRepository qrepository;

	@Autowired
	private SurveyRepository srepository;

	// LISTA KAIKISTA
	@GetMapping("/answers")
	public @ResponseBody List<Answer> allAnswers() {
		return (List<Answer>) arepository.findAll();
	}

	@GetMapping("/surveys")
	public @ResponseBody List<Survey> allSurveys() {
		return (List<Survey>) srepository.findAll();
	}
	
	@GetMapping("/questions")
	public @ResponseBody List<Question> allQuestions() {
		return (List<Question>) qrepository.findAll();
	}

	/*
	@RequestMapping("/taitokysely")
	public String web() {
		return "taitokysely";
	}*/

	// RESTIN KAUTTA UUS VASTAUS
	@PostMapping("/answer")
	Answer newAnswer(@RequestBody Answer newAnswer) {
		return arepository.save(newAnswer);
	}

	// RESTIN KAUTTA UUS KYSYMYS
	@PostMapping("/question")
	Question newQuestion(@RequestBody Question newQuestion) {
		return qrepository.save(newQuestion);
	}

	// THYMELEAF HÖPINÄÄ, EI KANNATA KÄYTTÄÄ MEIDÄN REST JUTUISSA
	/*
	 * @PostMapping(value = "/save") public String answer(Answer answer) {
	 * 
	 * if (answer.getAnswerName() == null) { answer.setAnswerName("no"); }
	 * arepository.save(answer); System.out.println(answer.getAnswerName());
	 * System.out.println(answer.getAnswerId()); System.out.println(answer); return
	 * "redirect:vastaus"; }
	 
	
	@RequestMapping("/vastaus")
	public String web2() {
		return "vastaus";
	} */

}
