package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//	클래스 레벨에 붙이면 중간경로
@RequestMapping("/board")			
@Controller
public class MappingController2 {
	
//	GET localhost:8080/board/list 메소드종류 + 주소 :  여기서는 GET방식으로 호출하시면 되요
//	메소드 레벨에 붙이면 마지막 경로
						// 참고 브라우저는 GET방식만-
	@ResponseBody		// 응답데이터 HTML이 XXX -> '순수한데이터' 브라우저 혹은 postman으로 return값 출력요망
	@GetMapping("/list")
	public String list() {
		System.out.println("게시물 조회...");
		return "Ok";
	}
	
//	POST  localhost:8080/board/save
	@ResponseBody
	@PostMapping("/save")
	public String save() {
		System.out.println("게시물 등록...");
		return "Ok !";
	}
	
//	PUT  localhost:8080/board/modify
	@ResponseBody
	@PutMapping("/modify")
	public String modify() {
		System.out.println("게시물 수정...");
		return "Ok -";
	}
	
//	DELETE  localhost:8080/board/remove
	@ResponseBody
	@DeleteMapping("/remove")
	public String remove() {
		System.out.println("게시물 삭제...");
		return "Ok...!";
	}

}
