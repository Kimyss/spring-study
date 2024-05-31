//package com.example.demo.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//
//@Controller
//public class MappingController1 {
//	
////	HTML문서 없이 메세지 바디에데이터를 직접 담는 기능
//	@ResponseBody
////	@RequestMapping(value = "/board", method = RequestMethod.GET)
//	@GetMapping("/board")	//의미가 위(버전1)와 같음 (얘는 버전2) GET localhost:8080/board
//	public String list() {	//void: URL주소 그대로 | String: 파일경로 직접
//		System.out.println("게시물 조회...");
//		return "OK";
//	}
//	
//	
//	// Post + localhost:8080/board
//	@ResponseBody
//	@PostMapping("/board")
//	public String save() {
//		System.out.println("게시물 등록...");
//		return "OK";
//	}
//	
//	
//	// Put + localhost:8080/board
//	@ResponseBody
//	@PutMapping("/board")
//	public String modify() {
//		System.out.println("게시물 수정...");
//		return "OK";
//	}
//	
//	
//	// Delete + localhost:8080/board
//	@ResponseBody
//	@DeleteMapping("/board")
//	public String remove() {
//		System.out.println("게시물 삭제...");
//		return "OK";
//	}
//		
//	
//	
//	
//	
//	
//
//}
