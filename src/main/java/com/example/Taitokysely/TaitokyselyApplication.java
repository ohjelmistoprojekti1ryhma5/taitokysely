package com.example.Taitokysely;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.Taitokysely.model.Answer;
import com.example.Taitokysely.model.AnswerRepository;


@SpringBootApplication
public class TaitokyselyApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaitokyselyApplication.class, args);	 
	}
	/*
	@Bean
	public CommandLineRunner demo(AnswerRepository arepo ) {
		return (args) -> {
			arepo.save(new Answer("Kyllä"));
			
				
		};
	} */
}
