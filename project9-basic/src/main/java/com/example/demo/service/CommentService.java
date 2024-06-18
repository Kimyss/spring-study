package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.CommentDTO;
import com.example.demo.entity.Board;
import com.example.demo.entity.Comment;
import com.example.demo.entity.Member;

public interface CommentService {

//	게시물별로 댓글 목록 조회 - 조건 : 게시물 번호
	List<CommentDTO> getListByBoard(int boardNo);
	
//	새로운 댓글 등록	- 사용자에게 댓글정보를 받고 처리결과는 댓글 번호
	int register(CommentDTO dto);
	
//	특정 댓글 삭제	//댓글번호를 받고 처리결과는 boolean
	boolean remove(int no);
	
//	DTO -> Entity 변환메소드
	default Comment dtoToEntity(CommentDTO dto) {
		Member member = Member.builder().id(dto.getWriter()).build();
		
		Board board = Board.builder().no(dto.getBoardNo()).build();
		
		Comment entity = Comment.builder()
					.commentNo(dto.getCommentNo())
					.board(board)
					.content(dto.getContent())
					.writer(member)
					.build();
		return entity;
	}
	
//	Entity -> DTO 변환 메소드
	default CommentDTO entityToDto(Comment entity) {
		
		CommentDTO dto = CommentDTO.builder()
									.commentNo(entity.getCommentNo())
									.boardNo(entity.getBoard().getNo())
									.content(entity.getContent())
									.writer(entity.getWriter().getId())
									.regDate(entity.getRegDate())
									.modDate(entity.getRegDate())
									.build();
		return dto;
	}
	
}
