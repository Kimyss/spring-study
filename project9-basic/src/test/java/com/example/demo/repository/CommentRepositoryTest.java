package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Board;
import com.example.demo.entity.Comment;
import com.example.demo.entity.Member;
import com.example.demo.repository.CommentRepository;

@SpringBootTest
public class CommentRepositoryTest {
	
	@Autowired
	CommentRepository repository;
	
	@Test
	public void 댓글등록() {
		Board board = Board.builder().no(3).build();
		Member member = Member.builder().id("user1").build();
		Comment comment = Comment.builder()
							.board(board)
							.content("된장찌개 맛있어요")
							.writer(member)
							.build();
		
		repository.save(comment);
		
	}
	@Test
	public void 댓글목록조회() {
		List<Comment> list = new ArrayList<>();
		
		for(Comment comment : list) {
			System.out.println(comment);
		}
	}
//	나머지 조회 작성요망
	
	@Test
	public void 게시물별_댓글조회() {
		Board board = Board.builder().no(2).build();
		
		List<Comment> list = repository.findByBoard(board);
		
		for(Comment comment : list) {
			System.out.println(comment);
		}
	}
	
	@Test
	public void 게시물별_댓글삭제() {
		Board board = Board.builder().no(3).build();
		repository.deleteByBoard(board);
	}

}
