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
public class QuestionRestController {

	/* 
	 * Vastaus-repository 
	 * Vastaus-luokka (Answer) 
	 * 
	 * */
	@Autowired
	private AnswerRepository arepository;

	/*
	 * Question-repository 
	 * 
	 * */
	@Autowired
	private QuestionRepository qrepository;

	/*
	 * Survey-repository
	 * Kaikki kyselyt 
	 * Kyselyt linkitetty 
	 * 
	 * */
	@Autowired
	private SurveyRepository srepository;

	/*
	 * Vastauksiin (Answer-luokka) liittyvät metodit
	 * 1. Hae vastaukset 
	 * 2. Lisää vastaus
	 * 3. Lisää vastaukset
	 * 
	 * */
	
	// 1. Hae vastaukset
	@GetMapping("/answers")
	public @ResponseBody List<Answer> allAnswers() {
		return (List<Answer>) arepository.findAll();
	}
	
	// 2. Lisää vastaus
	@PostMapping("/answer")
	Answer newAnswer(@RequestBody Answer newAnswer) {
		return arepository.save(newAnswer);
	}
	
	// 3. Lisää vastaukset
	@PostMapping("/answers")
	List<Answer> answerList(@RequestBody List<Answer> answerList) {
		return (List<Answer>) arepository.saveAll(answerList);
	}
	
	/*
	 * Vastaus-metodit päättyy
	 * 
	 * 
	 * Kysymyksiin (Question-luokka) liittyvät metodit
	 * 1. Hae kysymykset
	 * 2. Lisää kysymys
	 * 
	 * */

	// 1. Hae kysymykset
	@GetMapping("/questions")
	public @ResponseBody List<Question> allQuestions() {
		return (List<Question>) qrepository.findAll();
	}
	
	// 2. Lisää kysymys
	@PostMapping("/question")
	Question newQuestion(@RequestBody Question newQuestion) {
		return qrepository.save(newQuestion);
	}
	
	/*
	 * Kysymys-metodit päättyy
	 * 
	 * 
	 * Kyselyyn (Survey-luokka) liittyvät metodit
	 * 1. Hae kyselyt
	 * 2. Lisää kysely 
	 * 
	 * */
	
	// 1. Hae kyselyt
	@GetMapping("/surveys")
	public @ResponseBody List<Survey> allSurveys() {
		return (List<Survey>) srepository.findAll();
	}
	
	// 2. Lisää kysely
	@PostMapping("/survey")
	Survey newSurvey(@RequestBody Survey newSurvey) {
		return srepository.save(newSurvey);
	}
	
	/*
	 * ??? ??? ??? ??? ??? 
	 *  
	 * !!! Huomio Babies !!! Boomer kommentoi 12.5.2021
	 * 
	 * Seuraavaksi tänne pitäisi varmaankin rakentaa joku Get joka hakee 
	 * Tietyn kyselyn (Survey [ID]) kaikki vastaukset
	 * 
	 * Tieto on jo olemassa, mutta kuinka se toteutetaan 
	 * en osaa nyt miettiä tähän aikaan illasta enää
	 * 
	 * ??? ??? ??? ??? ???
	 * 
	 * */
} 


/***********************
 * 
 * CODE GRAVEYARD RIP
 * 
 ***********************/


/* palauttaa kaikki kyselyt ei vastauksia 
@GetMapping("/surveyanswers")
public @ResponseBody List<Survey> allSurveyAnswers() {
	return (List<Survey>) srepository.findAll();
}
*/

/* Survey-luokka muuttunut, enää ei haeta käyttäjältä kasaa vastauksia tätä kautta
@PostMapping("/survey")
Survey newAnswerToSurvey(@RequestBody Survey newAnswerToSurvey) {
	return srepository.save(newAnswerToSurvey);
}*/

/*
@RequestMapping("/taitokysely")
public String web() {
	return "taitokysely";
}*/

/*
 * Survey ei vielä käytössä
@GetMapping("/surveys")
public @ResponseBody List<Survey> allSurveys() {
	return (List<Survey>) srepository.findAll();
}
*/

/*
 * Survey ei vielä käytössä
// UUSI SURVEY TÄHÄN TÄIN
@PostMapping("/survey")
Survey newSurvey(@RequestBody Survey newSurvey) {
	
	return srepository.save(newSurvey);
}
 */

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