package com.example.Taitokysely.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class QuestionController {	
	@RequestMapping("/hello")
	public String web() {
		return "taitokysely";
	}
}


