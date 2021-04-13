package com.example.Taitokysely.web;

import javax.swing.JRadioButton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.Taitokysely.model.Answer;
import com.example.Taitokysely.model.AnswerRepository;


@Controller
public class QuestionController {	
	
	@Autowired
	private AnswerRepository arepository;
	
	@RequestMapping("/taitokysely")
	public String web() {
		return "taitokysely";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String answer(Answer answer) {
	
		if (answer.getName() == null) {
			answer.setName("no");
		}
		arepository.save(answer);
		System.out.println(answer.getName());
		System.out.println(answer.getAnswerId());
		return "redirect:vastaus";
	}
	
	@RequestMapping("/vastaus")
	public String web2() {
		return "vastaus";
	}
	
}


