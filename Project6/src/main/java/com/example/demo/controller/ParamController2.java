package com.example.demo.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.BookDTO;

@Controller
@RequestMapping("/param2")
public class ParamController2 {

	// localhost:8080/param2/ex1?i=100
	@ResponseBody
	@GetMapping("/ex1")
	public String ex1(@RequestParam(name = "i") int i) {
		System.out.println("int형 파라미터 수집: " + i);
		return "ok";
	}

	@ResponseBody
	@GetMapping("/ex2")
	public String ex2(@RequestParam(name = "i") int i, @RequestParam(name = "c") char c) {
		System.out.println("int형 파라미터 수집: " + i + ", char형 파라미터 수집: " + c);
		return "Okk!";
	}

	// localhost:8080/param2/ex3?arr=1&arr=2&arr=3
	@ResponseBody
	@GetMapping("/ex3")
	public String ex3(@RequestParam(name = "arr") int[] arr) {
//			배열 -> 문자열로 변환
		System.out.println("int형 배열 수집 " + Arrays.toString(arr));
		return "OKkkkk!";
	}
	
	// localhost:8080/param2/ex4?list=1&list=2&list=3
	@ResponseBody
	@GetMapping("/ex4")
	public String ex4(@RequestParam(name = "list") ArrayList<Integer> list) {
		System.out.println("int형 리스트 수집: " + list);
		return "ok";
	}
	
	/*
	 * @DateTimeFormat :  날짜 패턴을 지정
	 * 기본값 : "yyyy-mm-dd"
	 * 그 외 "yyyy/MM/dd" or "yyyyMMdd"
	 * 다른 패턴으로 지정해도 "yyyy-mm-dd"은 사용가능
	 * */
//	localhost:8080/param2/ex5?date=2024-01-01
	@ResponseBody
	@GetMapping("/ex5")
	public String ex5(@RequestParam(name = "date") @DateTimeFormat(pattern = "yyyy/MM/dd") LocalDate date){
		System.out.println("날짜 수집: " + date);
		return "Okok";
	}
	
//	localhost:8080/param2/ex6/100
//	@PathVariable : 위치에 따른 식별
	@ResponseBody
	@GetMapping("/ex6/{i}")
	public String ex6(@PathVariable(name = "i") int i) {
		System.out.println("int형 파라미터 수집: "+ i);
		return "OKkkkk!";
	}
	
	//localhost:8080/param2/ex7?title=자바프로그래밍입문&publisher=한빛컴퍼니&price=1000
	@ResponseBody
	@GetMapping("/ex7")
	public String ex7(@ModelAttribute BookDTO dto) {	//@ModelAttribute 생략가능
		System.out.println("객체 파라미터 수집: " + dto);
		return "Ooook!";
	}
	
	

}
