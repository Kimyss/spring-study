package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//MV*C* -> Controller : 사용자 요청처리 (비즈니스로직, 서블릿 포함하고 있어)
@Controller
@RequestMapping("/sample")
public class SampleController {
	
	@GetMapping("/ex1")
	public void ex1() {
//		return type이 void : url 주소가 html 경로가 됨
//		return type이 String : html 경로를 직접 정할 수 있음
	}
	
	
	@GetMapping("/ex2")
	public void ex2(Model model) {		//model : 화면에 데이터를 전달하는 클래스
		model.addAttribute("msg", "안녕하세요");	//컨트롤러 > 화면으로 전달
	}
	
	
	@GetMapping("/ex3")
	public void ex3(Model model) {		//model : 화면에 데이터를 전달하는 클래스(객체) 
		model.addAttribute("msg11", "안녕하세요");	//컨트롤러 > 화면으로 전달
		model.addAttribute("msg22", "안녕하세요둘");	//컨트롤러 > 화면으로 전달
	}
//	model 객체에 데이터 여러번 담기 개능
	

}
