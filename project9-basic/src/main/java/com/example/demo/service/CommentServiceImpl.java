package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CommentDTO;
import com.example.demo.entity.Board;
import com.example.demo.entity.Comment;
import com.example.demo.repository.CommentRepository;

@Service
public class CommentServiceImpl implements CommentService{
	
	@Autowired
	CommentRepository repository;

//	추상메소드만 오버라이드 !
	@Override
	public List<CommentDTO> getListByBoard(int boardNo) {
		
		Board board = Board.builder().no(boardNo).build();		//엔티티 생성
		
		List<Comment> entityList = repository.findByBoard(board);	//게시물 기준으로 댓글 조회
		
		List<CommentDTO> dtoList = new ArrayList<>();		//엔티티 리스트 -> 디티오리스트
		for(Comment entity : entityList) {
			CommentDTO dto = entityToDto(entity);
			dtoList.add(dto);
		}
		return dtoList;
	}

	@Override
	public int register(CommentDTO dto) {
		Comment entity = dtoToEntity(dto);		//dto -> entity
		repository.save(entity);

		return entity.getCommentNo();		//새로운 댓글 번호 반환
	}

	@Override
	public boolean remove(int no) {
		Optional<Comment> comment = repository.findById(no);	//데이터가 실제로 있는지 확인
		if(comment.isEmpty()) {			//데이터가 없으면 삭제X
			return false; 
		}
		repository.deleteById(no);		//데이터가 있으면 삭제O
		return true;
	}
}
