package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CommentDTO;
import com.example.demo.service.CommentService;

@RestController		//@Controller + @ResponseBody(JSON형태로 변환해주는 놈)
@RequestMapping("/comment")
public class CommentController {

	@Autowired
	CommentService service;		//서비스주입	
	
	@GetMapping("/list")
	public List<CommentDTO> list(@RequestParam(name ="boardNo") int boardNo){
		
		List<CommentDTO> commentList = service.getListByBoard(boardNo);
		return commentList;
	}
	
//	새로운 댓글 등록
	
	@PostMapping("/register")
	public Boolean register(CommentDTO dto) {
//		시큐리티 처리를 아직 못해서, 임시아이디로 등록
		String id = "user1";
		dto.setWriter(id);
		service.register(dto);
		return true;
	}
//	특정댓글삭제
	@DeleteMapping("/remove")
	public Boolean remove(@RequestParam(name ="commentNo") int commentNo) {
		boolean result = service.remove(commentNo);
		return result;
	}
//	화면 반환 시 String 또는 void
//	삭제메소드는 순수한 데이터 List는 Json객체 형태로 응답이 되고 Boolean text로 변환 후 응답데이터로 변환
	
	
	
	

}
