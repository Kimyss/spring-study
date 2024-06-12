package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.BoardDTO;
import com.example.demo.entity.Board;
import com.example.demo.repository.BoardRepository;

//서비스 : 이곳은 구현클래스

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardRepository repository;

	@Override
	public int register(BoardDTO dto) {

		Board entity = dtoToEntity(dto); // dto -> entity 변환

		repository.save(entity); // 변환한 엔티티 저장

		int newNo = entity.getNo();

		return newNo; // 새로운 글의 번호 반환
	}

	@Override
	public List<BoardDTO> getList() {

		List<Board> result = repository.findAll(); // 게시물 목록조회

		List<BoardDTO> dtoList = new ArrayList<>();

		dtoList = result.stream().map(entity -> entityToDto(entity)).collect(Collectors.toList());

		return dtoList; // DTO 리스트 반환
	}

	@Override
	public BoardDTO read(int no) {

		Optional<Board> result = repository.findById(no);

		if (result.isPresent()) {
			Board board = result.get();

//			꺼내고 보니까 entity, dto로 변환 필요

			BoardDTO boardDTO = entityToDto(board); // entity -> dto

			return boardDTO;
		} else {

			return null;
		}

	}

	@Override
	public void modify(BoardDTO dto) {

		Optional<Board> result = repository.findById(dto.getNo());
//		데이터존재 확인 이유 : 동시성 이슈

		if (result.isPresent()) {
			Board entity = result.get();
			entity.setTitle(dto.getTitle());
			entity.setContent(dto.getContent());
			repository.save(entity);
		}

	}

}

