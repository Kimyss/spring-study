package com.example.demo;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;




@RestController

public class TestController {
	
	@GetMapping("/hello")
	public String hello() {
		return "안녕하세요";
	}
}
