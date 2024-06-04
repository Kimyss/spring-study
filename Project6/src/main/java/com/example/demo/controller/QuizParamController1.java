package com.example.demo.controller;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.StudentDTO;
//1. 주소
//모든 주소의 중간경로가 같으므로 /param을 클래스 레벨에 적용

@Controller
@RequestMapping("/param")
public class QuizParamController1 {
	
	// 2. 파라미터 형태
		// 간단 -> @RequestParam 또는 @PathVariable
		// 복잡 -> @RequestParam, @PathVariable 보다는 @RequestBody
	
	@ResponseBody
	@GetMapping("/q1")
	public String q1(@RequestParam(name = "") String a) {
	
		System.out.println("String 파라미터 수집: "+ a);
		return "ok";
	}
	
	@ResponseBody
	@GetMapping("/q2")
	public String q2(@RequestParam(name = "i") float i, @RequestParam(name ="bool")Boolean bool) {
		System.out.println("float형 파라미터수집: "+i + "boolean타입 파라미터 수집: " + bool );
		return "ok";
	}
	
	@ResponseBody
	@GetMapping("/q3")
	public String q3(@RequestParam(name = "arr") char[] arr) {
		System.out.println("Char형 배열수집: " + Arrays.toString(arr));
		for(int i=0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		System.out.println("배열의개수: " + arr.length);
		return "ok";
	}
	
	@ResponseBody
	@PostMapping("/q4")
	public String q4(@ModelAttribute StudentDTO dto) {
		System.out.println("객체수집" +dto);
		return "ok";
	}
	
//	@ResponseBody
//	@PostMapping("/q5")
//	public String q5()
}
