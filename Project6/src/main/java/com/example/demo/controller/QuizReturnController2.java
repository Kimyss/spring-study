package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.CarDTO;
import com.example.demo.dto.StudentDTO;

@Controller
@RequestMapping("/return")
public class QuizReturnController2 {
	

	@GetMapping("/q1")
	public String q1(Model model) {
		model.addAttribute("data1", "첫번째퀴즈에요");
		return "return/q1";
	}
	
	@GetMapping("/q2")
	public void q2(Model model) {
		model.addAttribute("data2","두번째퀴즈입니다");
	}
	
	@ResponseBody
	@GetMapping("/q3")
	public StudentDTO q3() {
		StudentDTO stuDto = new StudentDTO(1, "둘리", 3);
		return stuDto;
	}
	
	@ResponseBody
	@GetMapping("/q4")
	public CarDTO q4() {
		CarDTO carDto = new CarDTO("현대", "코나", "블랙");
		return carDto;
	}
	
	@ResponseBody
	@GetMapping("/q5")
	public List<StudentDTO> q5(){
		List<StudentDTO> stuList = new ArrayList<>();
		
		stuList.add(new StudentDTO(1, "둘리", 3));
		stuList.add(new StudentDTO(2, "또치", 1));
		stuList.add(new StudentDTO(3, "도우너", 2));
		
		return stuList;
	}
	
	
	

}
