package com.example.Taitokysely;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/*
 * Tämä SecurityConfiguration luokka disabloi Spring Securityn autogeneroidut asetukset ja käyttää näitä täällä määriteltyjä
 * Tämä luokka hahmoteltu tämän ohjeen pohjalta: https://spring.io/guides/tutorials/react-and-spring-data-rest/ 
 * Kohdassa "Part 5" alkaa Security jutut
 * Ainoa käytetty kohta otettu "Part 5" alakohdasta "Wiring up Your Security Policy" 
 * 
 * */

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) 
public class SecurityConfiguration extends WebSecurityConfigurerAdapter { 

	@Override
	protected void configure(HttpSecurity http) throws Exception { 
		http
			.authorizeRequests()
				// Täällä määritellään mistä urleista sallitaan kaikki liikenne
				// Sallitaan toistaiseksi kaikki kehitystyön helpottamiseksi
				// Myöhemmin muutetaan vain ne urlit jonne lähetetään ja haetaan liikennettä
				// Toistaiseksi riittäisi /answer mutta käytetään /** kaiken liikenteen sallimiseksi
				.antMatchers("/**").permitAll()
				// Muuten sallitaan sellanen liikenne mikä autentikoitu
				.anyRequest().authenticated()
				.and()
				/* Tämä taitaa tarkoittaa että vaatii "ylläpitäjän kirjautumisen" 
				 * Joten kehitystyön helpottamiseksi toistaiseksi kytketty pois päältä
				 * 
				 * .formLogin()
				 * Ja tänne ylläpitäjä ohjataan onnistuneen kirjautumisen jälkeen
				 * .defaultSuccessUrl("/", true)
				 * Ja kaikki sallitaan onnistuneen kirjautumisen jälkeen
				 * .permitAll()
				 * .and() 
				 * */
			.httpBasic()
				.and()
				// CSRF vaatii vielä hahmottamista, disablointi vain kehitysversioissa suositus
			.csrf().disable()
			.logout()
				.logoutSuccessUrl("/");
	}

}