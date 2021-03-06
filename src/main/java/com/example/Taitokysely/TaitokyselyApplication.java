package com.example.Taitokysely;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.Taitokysely.model.Answer;
import com.example.Taitokysely.model.AnswerRepository;
import com.example.Taitokysely.model.Question;
// import com.example.Taitokysely.model.Survey;
import com.example.Taitokysely.model.QuestionRepository;
// import com.example.Taitokysely.model.SurveyRepository;

@SpringBootApplication
public class TaitokyselyApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaitokyselyApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(AnswerRepository arepo, QuestionRepository qrepo) {
		return (args) -> {
			
			//arepo.deleteAll();
			//qrepo.deleteAll();
			//srepo.deleteAll();
			//srepo.save(new Survey("kysely", "22.01.2021"));
		};
	}
}
