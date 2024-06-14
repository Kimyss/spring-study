package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository; 

import com.example.demo.entity.Memo;

//MemoRepository | JpaRepository 둘다 인터페이스, extends 사용한다 <엔티티, PKtype>

public interface MemoRepository extends JpaRepository<Memo, Integer>{

//	아무것도 없지만 find save delete 등의 기능 가지고있다. 부모에게 상속 받았기에.
//	물려준 것은 전부 추상메소드 (구현체 없음 -> 이 구현체를 spring이 만들어준다. 인스턴스만들고 저장해주고등등)
	
	
//	단건조회목록, 수정, 삭제, 추가, 페이징
	
//	조건 검색 기능 추가하고 싶을때 확장하고 싶을떄
}
