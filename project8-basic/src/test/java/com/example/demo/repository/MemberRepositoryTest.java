package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Member;

@SpringBootTest
public class MemberRepositoryTest {
	
	@Autowired
	MemberRepository memberRepository;
	
	@Test
	public void 회원등록() {
		List<Member> list = new ArrayList<>();
		
		Member member1 = new Member("user1", "1234", "김질럿");
		Member member2 = new Member("user2", "1234", "최둘리");
		Member member3 = new Member("user3", "1234", "손오공");
		
		list.add(member1);
		list.add(member2);
		list.add(member3);
		
		memberRepository.saveAll(list);		
			
	}
	
	
	@Test
	public void 회원목록조회() {
		List<Member> list = memberRepository.findAll();
		
		for(Member mm : list) {
			System.out.println(mm);
		}
	}
	
	@Test
	public void 회원단건조회() {
		Optional<Member> result = memberRepository.findById("user2");
		
		if(result.isPresent()) {
			Member member = result.get();
			System.out.println(member);
		}
		
	}
	
	@Test
	public void 회원수정() {
		Optional<Member> result = memberRepository.findById("user2");
		Member member = result.get();
		member.setName("배지타");
		memberRepository.save(member);
	}
	
	@Test
	public void 회원삭제() {
		memberRepository.deleteById("user2");
//		게시글을 쓴 id는 자식레코드가 있기 때문에 참조하고 있기 때문에 삭제불가
	}
	
	@Test
	public void 전체삭제() {
		memberRepository.deleteAll();
	}
	

}
