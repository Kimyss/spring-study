package com.example.demo.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//이곳은 단위 테스트. 폴더 나누어 만드는게 좋아요

import com.example.demo.dto.BoardDTO;

@SpringBootTest
public class BoardServiceTest {
	
	//컨테이너 안에 있는 빈을 주입받아요 객체를 꺼내요 BoardService service = new BoardService();
	@Autowired		
	BoardService service;
	
	
	@Test
	public void 게시물등록() {
		BoardDTO dto = BoardDTO.builder()
				.title("2번글")
				.content("2번내용내용")
				.writer("또치")
				.build();
		
		int no =  service.register(dto);
		
		System.out.println("새로운 게시물 번호: " + no);
		
	}
	@Test
	public void 게시물목록조회() {
		List<BoardDTO> list = service.getList();
		for(BoardDTO dto : list) {
			System.out.println(dto);
		}
	}

}
