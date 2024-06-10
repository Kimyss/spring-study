package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Board;

//리파지토리가 가지고 있는 기능을 단독으로 테스트하기 위함
//프로젝트 통으로X 이 클래스에서는 리파지토리만 단위테스트 해보기위함

@SpringBootTest
public class BoardRepositoryTest {

	@Autowired
	BoardRepository repository;

	@Test
	void 빈을가졌는지확인() {
		System.out.println("repository의 주소: " + repository);
	}

	@Test
	void 게시물등록() {
		Board board = Board.builder().title("1번글").content("내용입니다").writer("둘리").build();
		System.out.println("등록전: " + board);
		repository.save(board);
		System.out.println("등록후: " + board);
	}
	
	@Test
	void 게시물목록조회() {
		List<Board> list = repository.findAll();
		System.out.println("회원목록: ");
		for(Board all : list) {
			System.out.println(all);
		}
	}
	
	@Test
	void 게시물단건조회() {
		Optional<Board> result = repository.findById(1);
		
		if(result.isPresent()) {
			Board board = result.get();
			System.out.println(board);
		}
	}
	
	@Test
	void 게시물수정() {
		Optional<Board> modi = repository.findById(1); // 데이터 먼저 꺼내기 필요
		Board board = modi.get();
		board.setTitle("1번글");
		repository.save(board);
	}
	
//	@Test
//	void 게시물삭제() {
//		repository.deleteById(1);
//	}
	
//	@Test
//	void 게시물전체삭제() {
//		repository.deleteAll();
//	}
	 	
}
