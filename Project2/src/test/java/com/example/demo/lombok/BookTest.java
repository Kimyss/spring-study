package com.example.demo.lombok;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookTest {
	
	@Test
	void 북테스트() {
		Book book1 = new Book();
		book1.setName("자바프로그래밍");
		book1.setPrice(10000);
		book1.setCompany("가나출판사");
		book1.setPage(300);
		
		Book book2 = new Book("스프링배우기", 12000, "나다출판사", 350);
		
		Book book3 = Book.builder().name("자바의정석").company("라라출판사").build();
		
		System.out.println(book1.getName());
		System.out.println(book1.getPrice());
		System.out.println(book1.getCompany());
		System.out.println(book1.getPage());
		System.out.println(book1.toString());
		System.out.println("-----");
		System.out.println(book2.getName());
		System.out.println(book2.toString());
		System.out.println("-----");
		System.out.println(book3.toString());
		
	}


}
