package com.example.Taitokysely.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.Taitokysely.model.AnswerRepository;
import com.example.Taitokysely.model.Question;
import com.example.Taitokysely.model.QuestionRepository;
import com.example.Taitokysely.model.Survey;
import com.example.Taitokysely.model.SurveyRepository;

// ADMININ CONTROLLERI LISAAMAAN KYSYMYKSIA
@Controller
public class AdminController {

	@Autowired
	private AnswerRepository arepository;

	@Autowired
	private QuestionRepository qrepository;

	@Autowired
	private SurveyRepository srepository;

	@RequestMapping("/AdminQuestion")
	public String web() {
		return "AdminQuestion";
	}

	// LISÄÄ UUDEN KYSYMYKSEN
	@RequestMapping(value = "/add")
	public String addQuestion(Model model) {
		model.addAttribute("question", new Question());
		return "AdminQuestion";
	}

	// TALLENTAA KYSYMYKSEN
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveQuestion(Question question) {
		qrepository.save(question);
		// OHJAA TAKAISIN LISÄÄ ENDPOINTTIIN
		return "redirect:add";
	}

	// KAIKKI KYSYMYKSET
	@RequestMapping(value = "/questionlist")
	public String questionlist(Model model) {
		model.addAttribute("question", qrepository.findAll());
		return "Questions";
	}

	// POISTAA KYSMYKSEN
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteQuestion(@PathVariable("id") Long questionId, Model model) {
		qrepository.deleteById(questionId);
		return "redirect:../questionlist";
	}

	// MUOKKAA KYSYMYSTÄ
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editQuestion(@PathVariable("id") Long QuestionId, Model model) {
		model.addAttribute("question", qrepository.findById(QuestionId));
		return "EditQuestion";
	}

}
