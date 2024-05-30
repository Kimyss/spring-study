package com.example.demo.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.SampleDTO;

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
	
	@GetMapping("/ex4")
	public void ex4(Model model) {	//model : 파라미터 아닙니다 데이터 전달해주는놈
		SampleDTO sampleDTO = new SampleDTO(1, "Hey", LocalDate.now());
		
		model.addAttribute("dto", sampleDTO);
	}


//	하나의 메서드가 /ex5, /ex6, /ex7, /ex8 모든 요청을 처리 
//	각 화면에 동일한 데이터를 전달하기 위한 것
	@GetMapping({"/ex5", "/ex6", "/ex7", "/ex8"})
	public void ex5(Model model) {
		List<SampleDTO> list = new ArrayList<>();
		list.add(new SampleDTO(1, "aaa", LocalDate.now()));
		list.add(new SampleDTO(2, "bbb", LocalDate.now()));
		list.add(new SampleDTO(3, "ccc", LocalDate.now()));
		
		model.addAttribute("list", list);
	}
	
	@GetMapping("/ex9")
	public void ex9(Model model) {
		
		SampleDTO sampleDTO = new SampleDTO(1, "샘플디티오", LocalDate.now());
		
		model.addAttribute("result", "success");	//화면에 문자열 전달
		model.addAttribute("dto", sampleDTO);		//화면에 객체 전달
	}
	
	@GetMapping("/ex10")
	public void ex10(Model model) {
		
//		화면에 현재시간 전달
		model.addAttribute("date", LocalDateTime.now());
		
//		생성자대신에 - of(): 수동 | now(): 자동
	}

}







