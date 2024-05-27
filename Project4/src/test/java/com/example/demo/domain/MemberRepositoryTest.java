package com.example.demo.domain;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest // 리파지토리가 가지고있는 기능 확인하기 위한 문제 빈 만들지 X 직접 생성자 써서 만듦
public class MemberRepositoryTest {

	MemberRepository repository = new MemberRepository();

	@Test
	public void 테스트() {

//		회원등록
		Member member1 = new Member(0, "user1", "1234");
		repository.save(member1);

		Member member2 = new Member(0, "user2", "1234");
		repository.save(member2);

		// 1번째 회원 조회
		Member getMember = repository.findById(1);
		System.out.println("1번째 회원: " + getMember);

		// 회원 목록 조회
		List<Member> list = repository.findAll();
		System.out.println("회원 목록: ");
		for (Member allMember : list) {
			System.out.println(allMember);
		}

		// 회원 전체 삭제
		repository.clearStore();
		List<Member> list2 = repository.findAll();
		System.out.println("삭제 후 회원 목록: ");
		for (Member member : list2) {
			System.out.println(member);
		}

	}

}
