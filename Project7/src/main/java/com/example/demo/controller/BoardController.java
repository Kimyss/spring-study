package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dto.BoardDTO;
import com.example.demo.service.BoardService;

@Controller
@RequestMapping("/board")		//중간경로 (폴더이름)
public class BoardController {
	
//	**데이터형식: HTMK문서 or 순수한데이터(JSON이나 XML 형식으로 작성후 반환)
//	스프링부트는 기본적으로 HTML문서를 반환
//	리턴타입 : void or String ->MTML 문서경로작성요망
//	void: url주소가 파일의 경로
//	String: return값으로 파일의 경로 직접작성
	
	@Autowired
	BoardService service;
	
//	메인화면을 반환하는 메소드
	@GetMapping("/main")		//경로(파일이름)
	public void main() {
		
	}
	
//	목록화면을 반환하는 메소드
	@GetMapping("/list")
	public void list(Model model) {
		List<BoardDTO> list =  service.getList();		//서비스를 통해 게시물 목록조회
		model.addAttribute("list", list);				//화면단에 던져
	}
	
//	등록화면을 반환하는 메소드
	@GetMapping("/register")
	public void registerPost() {
		
	}
	
//	1.dto: 폼에서 전달받은 게시물정보 (파라미터)
//	2.RedirectAttributes: 다른 주소로 리다이렉트할때 화면에 데이터를 전달하는 객체 (Model)
//	등록을 처리하는 메소드
	@PostMapping("/register")
	public String registerPost(BoardDTO dto, RedirectAttributes redirectAttributes) {
		
//		게시물 등록하고 새로운 게시물 번호 반환
		int no =  service.register(dto);
		
//		리다이렉트된 페이지 (목록화면)에 새로운 게시물 번호 전달
		redirectAttributes.addFlashAttribute("msg", no);
		
//		게시물 목록 화면으로 리다이렉트 하기
//		리다이렉트? 새로운 URL을 다시 호출하는 것
		return "redirect:/board/list";		//HTML파일X	URL주소O
	}

}