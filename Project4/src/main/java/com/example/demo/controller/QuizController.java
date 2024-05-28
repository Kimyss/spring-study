package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/quiz")
public class QuizController {
	
	@GetMapping("/q1")			// /quiz/q1
	public String q1Method() {
		return "/quiz/q1";		// 경로위치 반환
	}
	
	@PostMapping("/q2")			// /quiz/q2
	public String q2Method() {
		return "/quiz/q2";
	}

}
