package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.BookDTO;

@Controller
@RequestMapping("/return2")
public class ReturnController2 {
	
	@ResponseBody
	@GetMapping("/text")
	public String ex1() {
		return "Hi, Hello";		//text로 반환됨 기초타입@ResponseBody
	}
	
	@ResponseBody
	@GetMapping("/ex2")
	public int ex2() {
		return 100;				//text로 반환됨
	}
	
//	***class타입, JSON변환
	
	@ResponseBody
	@GetMapping("/ex3")
	public BookDTO ex3() {
		BookDTO bookDto = new BookDTO("자바프로그래밍입문", "한빛컴퍼니", 20000);
		return bookDto;
	}
	
	@ResponseBody
	@GetMapping("/ex4")
	public List<BookDTO> ex4(){
		List<BookDTO> list = new ArrayList<>();
		list.add(new BookDTO("자바프로그래밍입문", "한빛컴퍼니", 20000));
		list.add(new BookDTO("스프링부트웹프로젝트", "구멍가게코딩단", 15000));
		list.add(new BookDTO("모두의리눅스", "길벗출판사", 30000));
		
		return list;
	}
	
//	ResponseEntity: 응답코드와 데이터를 담는 클래스
	@GetMapping("/ex5")
	public ResponseEntity ex5() {
		return new ResponseEntity(HttpStatus.OK);		//200 ok 성공코드
	}
	
//	(HttpStatus.INTERNAL_SERVER_ERROR); 응답을 강제로 조각시키는 경우도 있어요
	
	@GetMapping("/ex6")
	public ResponseEntity<String> ex6(){
		return new ResponseEntity<>("Success... ", HttpStatus.OK);	//200 ok응답 + 문자열
//								   (body에들어가는 코드 , header에 들어가는 코드);
	}
	
	@GetMapping("/ex7")
	public ResponseEntity<BookDTO> ex7(){
		BookDTO bookDto = new BookDTO("자바프로그래밍입문", "한빛컴퍼니", 20000);
		return new ResponseEntity<>(bookDto, HttpStatus.OK);	//200 ok 응답 + Book객체
	}
//	@ResponseBody 없어도 객체출력되어요  → ResponseEntity 안에 들어있어요 그래요
}
