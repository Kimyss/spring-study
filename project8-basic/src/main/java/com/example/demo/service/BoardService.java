package com.example.demo.service;

import org.springframework.data.domain.Page;

import com.example.demo.dto.BoardDTO;
import com.example.demo.entity.Board;
import com.example.demo.entity.Member;

public interface BoardService {

	// 게시물 등록 메소드
	int register(BoardDTO dto);

	// 게시물 목록조회 메소드
//	List<BoardDTO> getList();
	Page<BoardDTO> getList(int pageNumber);
	

	// 게시물 상세조회 메소드
	BoardDTO read(int no);

	// 게시물 수정 메소드
	void modify(BoardDTO dto);

	// 게시물 삭제 메소드
	int remove(int no);

	// dto를 엔티티로 변환하는 메소드
	default Board dtoToEntity(BoardDTO dto) {
		
		Member member = Member.builder()
							.id(dto.getWriter())
							.build();

		Board entity = Board.builder()
				.no(dto.getNo())
				.title(dto.getTitle())
				.content(dto.getContent())
				.writer(member)
				.build();
		return entity;
	}

	// 엔티티를 dto로 변환하는 메소드
	default BoardDTO entityToDto(Board entity) {

		BoardDTO dto = BoardDTO.builder()
				.no(entity.getNo())
				.title(entity.getTitle())
				.content(entity.getContent())
				.writer(entity.getWriter().getId())
				.regDate(entity.getRegDate())
				.modDate(entity.getModDate())
				.build();

		return dto;
	}

}
