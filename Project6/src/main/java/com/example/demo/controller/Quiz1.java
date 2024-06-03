package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/method")
//@RequestMapping("/method/q") 이렇게도 가능 (주소같으니)
@Controller
public class Quiz1 {
	
	@ResponseBody
	@GetMapping("/q")
	public String getGe() {
		System.out.println("get메소드요청 ...");
		return "Get Ok";
	}
	
	@ResponseBody
	@PostMapping("/q")
	public String postPo() {
		System.out.println("post메소드요청...");
		return "Post...Ok";
	}
	
	@ResponseBody
	@PutMapping("/q")
	public String putPu() {
		System.out.println("put메소드요청...");
		return "Put... Ok";
	}
	
	@ResponseBody
	@DeleteMapping("/q")
	public String deleteD() {
		System.out.println("Del메소드요청...");
		return "Del... Ok";
	}

}
