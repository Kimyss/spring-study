package com.example.demo.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.example.demo.dto.BoardDTO;

@SpringBootTest
public class BoardServiceTest {

	@Autowired
	BoardService service;

	@Test
	public void 게시물등록() {
		BoardDTO dto = BoardDTO.builder()
						.title("2번글").content("내용입니다").writer("또치")
						.build();
		int no = service.register(dto);
		System.out.println("새로운 게시물 번호: " + no);
	}

	@Test
	public void 게시물목록조회() {
		Page<BoardDTO> page = service.getList(2);	//페이지조회
//		page 안에는 전체게시물 갯수, List, page정보 등 여러개 구성되어있기에 게시물 목록 꺼내기 필요해
		
		List<BoardDTO> list = page.getContent();	//게시물 목록 꺼내기
		
		for(BoardDTO dto :page) {
			System.out.println(page);
		}
	}
	
	@Test
	public void 게시물단건조회() {
		BoardDTO dto = service.read(1);
		System.out.println(dto);
	}
	
	@Test
	public void 게시물수정() {
		BoardDTO dto = service.read(1);
		dto.setContent("내용이수정되었습니다~");
		service.modify(dto);
	}
	
	@Test
	public void 게시물삭제() {
		service.remove(1);
	}

}
