package com.example.demo.repository;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;  // 얘는 수동으로 import (자동완성이 안돼?)
import org.springframework.data.domain.Sort;

import com.example.demo.entity.Memo;

@SpringBootTest
public class MemoRepositoryTest1_2 {

	@Autowired		// 컨테이너 빈을 찾아서 필드에 주입
	MemoRepository repository;
	
	@Test
	void 메모데이터100개등록() {
		
//		IntStream :  스트림
//		RangeClosed : 특정 범위의 숫자들로 스트림을 생성하는 함수
//		forEacg : 특정 작업을 수행하는 함수
//		IntStream.rangeClosed(1, 100).forEach((value) -> System.out.println(value));
		
//		위 코드를 활용하여 멤버객체 만들어보기
//		메모 100개를 생성해서 테이블에 추가
		IntStream.rangeClosed(1, 100).forEach(i -> {
			Memo memo = Memo.builder().text("Sample.." + i).build();
			repository.save(memo);
			});
	}
	
	@Test
	void 페이징처리() {
//		페이지 생성(생성자 대신 of , static함수 인자는 페이지 번호, 데이터개수)
		Pageable pageable = PageRequest.of(0, 10);
		
//		페이지를 정보에 전달하여 목록 조회
		Page<Memo> page = repository.findAll(pageable);
		
//		페이지 객체에서 엔티티 리스트 꺼내기
		List<Memo> list = page.getContent();
		
		System.out.println(list);
		
//		페이지 부가 정보
		System.out.println("총 페이지: " + page.getTotalPages());
		System.out.println("현재 페이지: " + page.getNumber());
		System.out.println("페이지당 데이터 개수: " + page.getSize());
		System.out.println("다음 페이지 존재 여부: " + page.hasNext());
		System.out.println("시작 페이지 여부: " + page.isFirst());
	}
	
	@Test
	void 정렬조건추가하기() {
//		no 필드를 기준으로 역정렬. 여기서 by도 static 컬럼X 엔티티의 변수명입력해줘 
		Sort sort = Sort.by("no").descending();
		
//		페이지 정보 생성. of함수 오버로드 되어있어
		Pageable pageable = PageRequest.of(9, 5, sort);
		
		Page<Memo> page = repository.findAll(pageable);
		
		List<Memo> list = page.getContent();
		
		for (Memo mm : list) {
			System.out.println(mm);
		}
	}
	
	
}
