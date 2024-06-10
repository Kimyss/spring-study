package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")		//중간경로 (폴더이름)
public class BoardController {
	
//	**데이터형식: HTMK문서 or 순수한데이터(JSON이나 XML 형식으로 작성후 반환)
//	스프링부트는 기본적으로 HTML문서를 반환
//	리턴타입 : void or String ->MTML 문서경로작성요망
//	void: url주소가 파일의 경로
//	String: return값으로 파일의 경로 직접작성
	
//	메인화면
	@GetMapping("/main")		//경로(파일이름)
	public void main() {
		
	}

}
