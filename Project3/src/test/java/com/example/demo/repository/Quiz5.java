package com.example.demo.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Book;

@SpringBootTest		//컨테이너 임시환경
public class Quiz5 {
	
	@Autowired	//Book 객체 꺼내와
	BookRepository bookRepository;
	
	@Test		//단위테스트
	public void 자바프로그래밍찾아() {
		List<Book> list = bookRepository.get1("자바프로그래밍입문");
		
		for(Book javabook : list) {
			System.out.println(javabook);
		}
	}
	
	@Test
	public void 삼만이상출판사남가람() {
		List<Book> list = bookRepository.get2(30000, "남가람북스");
		
		for(Book nambook : list) {
			System.out.println(nambook);
		}
	}
	
	@Test
	public void 한빛이지스() {
		List<Book> list = bookRepository.get3("한빛출판사", "이지스퍼블리싱");
		for(Book publ : list) {
			System.out.println(publ);
		}
	}
				

}
