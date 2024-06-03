package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.UserDTO;

@Controller
@RequestMapping("/param3")
public class ParamController3 {
//	get방식 + localhost:8080/param3/register
//	사용자 등록폼을 반환하는 메소드
	@GetMapping("/register")
	public String ex1() {
		return "param/register";
	}
	
//	post방식 + localhost:8080/param3/register + 파라미터
//	사용자 정보를 등록하는 메소드 @ResponseBody 붙어있기에 ok문자열 그대로 반환 같은 스트링이어도 위아래 다르다
	@ResponseBody	// → 요청을 처리하는 메소드
	@PostMapping("/register")
	public String ex2(UserDTO dto) {
		System.out.println("username= " +dto.getUsername() + " age= " + dto.getAge());
		return "DTO Ok!!";
	}

}
