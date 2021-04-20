package com.example.Taitokysely.web;

import java.util.List;

import javax.swing.JRadioButton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.Taitokysely.model.Answer;
import com.example.Taitokysely.model.AnswerRepository;
import com.example.Taitokysely.model.QuestionRepository;
import com.example.Taitokysely.model.Survey;
import com.example.Taitokysely.model.SurveyRepository;


@Controller
public class QuestionController {

	@Autowired
	private AnswerRepository arepository;
	
	@Autowired
	private QuestionRepository qrepository;
	
	@Autowired
	private SurveyRepository srepository;

	// JSON MUOTO KAIKISTA VASTAUKSISTA
	@RequestMapping(value = "/answers", method = RequestMethod.GET)
	public @ResponseBody List<Answer> answer() {	
		return (List<Answer>) arepository.findAll();
	}
	
	@RequestMapping(value = "/surveys", method = RequestMethod.GET)
	public @ResponseBody List<Survey> survey() {	
		return (List<Survey>) srepository.findAll();
	}
	
	@RequestMapping("/taitokysely")
	public String web() {
		return "taitokysely";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String answer(Answer answer) {

		if (answer.getAnswerName() == null) {
			answer.setAnswerName("no");
		}
		arepository.save(answer);
		System.out.println(answer.getAnswerName());
		System.out.println(answer.getAnswerId());
		return "redirect:vastaus";
	}

	@RequestMapping("/vastaus")
	public String web2() {
		return "vastaus";
	}

}
