package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Memo;

@SpringBootTest
public class MemoRepositoryTest1_1 {
	
	@Autowired
	MemoRepository memoRepository;
	
	@Test
	public void 리파지토리객체를가져왔는지확인() {
		System.out.println("memoRepository = " + memoRepository);
	}
	
	
//	추가 - 조회 - 수정 - 삭제 순서로 실행
	@Test
	public void 데이터등록() {
//		no는 Auto_Increment 빈값을 넣어도됨
		Memo memo = new Memo(0, "새글입니다");
		
//		해당 데이터가 없다면 insert 명령 실행됨
		memoRepository.save(memo);
		
	}
	
	@Test
	public void 데이터일괄등록() {
		List<Memo> list = new ArrayList<>();
		
		Memo memo1 = new Memo(0, "새글입니다.");
		Memo memo2 = new Memo(0, null);		//text는 null 입력 가능 (text컬럼의 속성이 null허용하기 때문에)
		
		list.add(memo1);
		list.add(memo2);
		
		memoRepository.saveAll(list);
	}
	
	@Test
	public void 데이터단건조회() {
//		findById 함수는 조회결과를 Optional로 반환
		Optional<Memo> result = memoRepository.findById(10);
		
//		결과값이 있는지 확인하고 값을 꺼내기
		if(result.isPresent()) {	//확인
			
			Memo memo = result.get();	//꺼내기
			System.out.println(memo);
		}
	}
	
	@Test
	public void 데이터수정() {
		Memo memo = new Memo(1, "글이수정되었어요");
		
//		1번이 있으면 UPDATE, 없으면 INSERT
		memoRepository.save(memo);
	}
	
	@Test
	public void 데이터삭제() {
		
//		1번이 있는지 확인하고 delete
		memoRepository.deleteById(1);
	}
	
	@Test
	public void 데이터전체삭제() {
		memoRepository.deleteAll();		//테이블의 모든 데이터 일괄삭제 매개변수없어요!
	}
	
	
	
	
	
	
	
	
	

}
