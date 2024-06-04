package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReturnController1 {

//	ModelAndView: 뷰에 데이터를 전달하는 객체, 뷰이름과 데이터 담을 수 있음. 뷰 이름도 선택하고 데이터도 담아서 보내
	@GetMapping("/return/ex1")
	public ModelAndView ex1() {
		ModelAndView modelAndView = new ModelAndView("return/sample")	//뷰이름
											.addObject("data", "banana");	// → data
		return modelAndView;
	}
	
	@GetMapping("/return/ex2")
	public String ex2(Model model) {
		
		model.addAttribute("data", "banana");		//변수이름, 실데이터
		
		return "/return/sample";		//뷰 이름
	}
	

//	void : 자동결정-> 주소가 경로 중간 경로가 폴더가 되고 마지막 경로가 HTML문서이름
//	경로와 실제 파일의 경로가 같을때 사용
	
	@GetMapping("/return/sample")
	public void ex3(Model model) {
		
		model.addAttribute("data", "banana");
		
	}
}
