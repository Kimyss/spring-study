package com.example.demo.service;

import com.example.demo.dto.BoardDTO;
import com.example.demo.entity.Board;

public interface BoardService {

//	인터페이스안에는 추상메소드(게시물 관련된 기능)로 만들어요
//	추상메소드만 가질 수있다 + 자바8버전 이후부터는 일반메소드 추가 가능 -> default 키워드 요망
//	데이터 조회, 등록, 수정, 삭제
	
	
//	게시물 등록 메소드 (추상메소드, 인터페이스 내에선 abstract 생략가능)
	int register(BoardDTO dto);	// -> 선언부
	
//	dto를 엔티티로 변환하는 메소드(일반메소드)
//	매개변수: 엔티티, return타입: DTO
	default Board dtoToEntity(BoardDTO dto) {	// -> 선언부
//	-> 구현부
		Board entity = Board.builder()
				.no(dto.getNo())
				.title(dto.getTitle())
				.content(dto.getContent())
				.writer(dto.getWriter())
				.build();
		
		return entity;
		
	}	// 등록X -> 조회할때 사용~~~
	
	
}

//추상메소드의 목적 :  자식클래스 각자 구현해서 사용하는 기능
//일반메소드의 목적 :  자식클래스 공통으로 사용되는 기능
