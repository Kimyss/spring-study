package com.example.demo.controller;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.BookDTO;
import com.example.demo.dto.PersonDTO;

@Controller
@RequestMapping("/quiz") // 공통경로
public class QContrloler {

	@GetMapping("/q1") // 마지막경로 각 메소드에 붙여주세요
	public void q1(Model q1q1) {
		q1q1.addAttribute("msg1", "둘리");
		q1q1.addAttribute("msg2", 20);
		q1q1.addAttribute("msg3", "구월동");
	}

	@GetMapping("/q2") // 마지막경로 각 메소드에 붙여주세요
	public void q2(Model q2q2) {
		q2q2.addAttribute("msg4", "스프링부트웹코딩단");
		q2q2.addAttribute("msg5", "구멍가게 코딩단");
		q2q2.addAttribute("msg6", LocalDate.of(2022, 12, 25));
	}

//	타임리프 기본경로 : /templates
//	Model 정보를 전달 시켜주는 객체
//	addAttribute : 정보를 담아주는 함수

	@GetMapping("/q3")
	public void ex3(Model model) {
		PersonDTO personDTO = new PersonDTO("둘리", 20, "인천 구월동");
		model.addAttribute("dto", personDTO);
	}
	
	@GetMapping("/q4")
	public void ex4(Model model) {
		BookDTO book1 = new BookDTO("인어공주", "디즈니", LocalDate.now());
		model.addAttribute("dto", book1);
	}

}
