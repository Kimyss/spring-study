package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{

//	순수 sql사용하기
	@Query(value = "select * from tbl_book where title = :title1", nativeQuery = true)
	List<Book> get1(@Param("title1") String title1);
	
	@Query(value = "select * from tbl_book where price > :price AND publisher =:publisher  ", nativeQuery = true)
	List<Book> get2(@Param("price") int price, @Param("publisher") String publisher);
	
	@Query(value = "select * from tbl_book where publisher = :publisher1 OR publisher = :publisher2 ", nativeQuery = true)
	List<Book> get3(@Param("publisher1") String publisher, @Param("publisher2") String publisher2);
	
//	JPQL문법사용
//	@Query("select b from tbl_book b where b.title = :title ")
//	List<Book> get4(@Param("title") String title);
//	
//	@Query("select b from tbl_book b where price > :price AND publisher = :publisher")
//	List<Book> get5(@Param("price") int price, @Param("publisher") String publisher);
//	
//	@Query("select b from tbl_book b where publusher =:publiisher1 OR publisher = :publisher2")
//	List<Book> get6(@Param("publiisher1") String publiisher1, @Param("publisher2") String publisher2);
	
	
}
