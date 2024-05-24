package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Book;

@SpringBootTest
public class Quiz1 {
	
	@Autowired
	BookRepository bookRepository;
	
	@Test
	public void book데이터등록() {
		List<Book> list = new ArrayList<>();
		Book book1 = new Book(0, "자바프로그래밍입문", "한빛출판사", 20000);	//책번호 자동생략 - no생략
		Book book2 = new Book(0,"스프링부트프로젝트","남가람북스",25000);
		Book book3 = new Book(0,"실무로 끝내는 PHP","남가람북스",40000);
		Book book4 = new Book(0,"알고리즘코딩테스트","이지스퍼블리싱",35000);
		list.add(book1);
		list.add(book2);
		list.add(book3);
		list.add(book4);
		bookRepository.saveAll(list);
	}
	
	@Test
	public void 데이터단건조회() {
		Optional<Book> result = bookRepository.findById(1);
		if(result.isPresent()) {
			Book book = result.get();
			System.out.println(book);
		}
	}
	
	@Test
	public void 데이터전체조회() {
		List<Book> list = bookRepository.findAll();
		for(Book book : list) {
			System.out.println(book);
		}
	}
	@Test
	public void 데이터수정() {
		Optional<Book> result = bookRepository.findById(1);
		Book book = result.get();
		book.setTitle("자바프로그래밍입문_개정판");
		bookRepository.save(book);	
	}
	
	@Test
	public void 데이터삭제() {
		bookRepository.deleteById(1);
	}
	
	@Test
	public void 데이터전체삭제() {
		bookRepository.deleteAll();
	}
	
	
}
