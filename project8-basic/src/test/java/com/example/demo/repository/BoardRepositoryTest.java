package com.example.demo.repository;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Board;
import com.example.demo.entity.Member;

//도메인 패키지... 그중 하나 *로 바꿔요 pageable 자동생성

@SpringBootTest
public class BoardRepositoryTest {

	@Autowired
	BoardRepository repository;
	
//	@Test
//	public void 게시물30추가() {
//		
//		
//		for(int i =1; i<=30; i++) {
//			
//			Board board = Board.builder()
//					.title(i+"번글")
//					.content("삽니다 팝니다")
//					.writer(member)
//					.build();
//			
//			repository.save(board);
//		}
//	}
	
	@Test
	public void 게시물등록() {
		
//		Board board = new Board(0, "1번글", "내용내용이에요", "user2"); XXXXX
		
//		타입이 Member 엔티티로 바뀌었기 때문에 멤버 엔티티 생성후에 writer에 넣어줘야해
		
//		회원 엔티티 생성
		Member member = Member.builder().id("user1").build();	//user1 : 존재하는 id가아니면 오류
		
//		회원테이블에 없는 아이디를 사용하면 에러남\
		Board board = Board.builder()
						.title("게시물1").content("내용이에요내용").writer(member).build();
		
		repository.save(board);
	}
	
	@Test
	public void 게시물조회() {
		Optional<Board> optional = repository.findById(2);
		
		Board board = optional.get();
		
//		회원정보 출력됨
		System.out.println(board);
			
	}
	
	@Test
	public void 특정회원이_작성한_게시물삭제() {
		Member member = Member.builder().id("user1").build();
		
		repository.deleteWriter(member);
	}
		
	
	
//	@Test
//	public void 정렬조건추가하기() {
//		
////		by("기준!") no:필드값을 기준으로 역정렬 ** 게시판은 보통 역정렬 합니다. 최신글이 가장 앞에 나오기에
////		ascending vs descending
//		Sort sort = Sort.by("no").descending();	
//		
////		of메소드: PageRequest의 객체를 생성하는 함수
//		Pageable pageable = PageRequest.of(2, 5, sort);	//(페이지번호, 갯수, 정렬)
//		
//		Page<Board> result = repository.findAll(pageable);	//인자값 넣어줘야 페이지, 양쪽 타입이 맞게되어서 밑줄 안감
//		
//		List<Board> list = result.getContent();
//		
//		System.out.println(list);
//	}
	
}
