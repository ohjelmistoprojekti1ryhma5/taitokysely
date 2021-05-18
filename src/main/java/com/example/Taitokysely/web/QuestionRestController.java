package com.example.Taitokysely.web;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JRadioButton;

import org.apache.tomcat.util.buf.Asn1Writer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	@Autowired
	private AnswerRepository arepository;

	@Autowired
	private QuestionRepository qrepository;

	@Autowired
	private SurveyRepository srepository;

	/*
	 * Vastauksiin (Answer-luokka) liittyvät metodit
	 * 1. Hae vastaukset 
	 * 2. Lisää vastaus
	 * 3. Lisää vastaukset
	 * 
	 * Erityisesti 3. Lisää vastaukset -metodi on nyt oleellinen, 
	 * sillä voi lisätä kaikki kyselyn (Survey) vastaukset kerralla
	 * ja generoida niille ID:t 
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
		List<Answer> vastauslista = (List<Answer>) arepository.saveAll(answerList);
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
	 * Erityisesti 2. Lisää kysymys on nyt oleellinen,
	 * kysymyksiä pitää lisätä että voi luoda kyselyn ja
	 * vastata kysymyksiin, 
	 * koska vastaukset on linkitetty kysymyksiin
	 * 
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
	 * 3. Hae kyselyyn liittyvät kysymykset 
	 * 4. Hae kyselyyn liittyvät vastaukset
	 * 
	 * Kysymysten lisäämisen jälkeen, 
	 * lisää kysely 2. Lisää kysely-metodilla
	 * ja anna kyselylle lista kysymyksiä
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
	
	// 3. Hae kyselyyn liittyvät kysymykset
	@GetMapping("/survey/{id}")
	public List<Question> getQuestions(@PathVariable("id") Long SurveyId) {
		return srepository.findById(SurveyId).get().getQuestions();
	}
	
	// 4. Hae kyselyyn liittyvät vastaukset 
	@GetMapping("/answers/{id}")
	public List<Answer> getAnswers(@PathVariable("id") Long SurveyId) {
		List<Answer> answers = new ArrayList<>();
		for (Question kysmys : srepository.findById(SurveyId).get().getQuestions()) {
			answers.addAll(kysmys.getAnswers());
		}
 		return answers;
	}

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