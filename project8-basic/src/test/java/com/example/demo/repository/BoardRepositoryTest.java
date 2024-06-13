package com.example.demo.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.example.demo.entity.Board;

//도메인 패키지... 그중 하나 *로 바꿔요 pageable 자동생성

@SpringBootTest
public class BoardRepositoryTest {

	@Autowired
	BoardRepository repository;
	
	@Test
	public void 게시물30추가() {
		
		for(int i =1; i<=30; i++) {
			
			Board board = Board.builder()
					.title(i+"번글")
					.content("삽니다 팝니다")
					.writer("김둘리")
					.build();
			
			repository.save(board);
		}
	}
	
	@Test
	public void 정렬조건추가하기() {
		
//		by("기준!") no:필드값을 기준으로 역정렬 ** 게시판은 보통 역정렬 합니다. 최신글이 가장 앞에 나오기에
//		ascending vs descending
		Sort sort = Sort.by("no").descending();	
		
//		of메소드: PageRequest의 객체를 생성하는 함수
		Pageable pageable = PageRequest.of(2, 5, sort);	//(페이지번호, 갯수, 정렬)
		
		Page<Board> result = repository.findAll(pageable);	//인자값 넣어줘야 페이지, 양쪽 타입이 맞게되어서 밑줄 안감
		
		List<Board> list = result.getContent();
		
		System.out.println(list);
	}
	
}
