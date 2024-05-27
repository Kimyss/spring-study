package com.example.demo.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//mybatis -> JPA

//가짜 저장소 만들기
public class MemberRepository {
	
//	회원 목록 저장할 map<key, value> key값 중복X
	static Map<Integer, Member> store = new HashMap<>();
	
//	새로운 회원번호를 발급하기 위한 시퀀스 static 인스턴스가 다 공유하는 정보이기에 프로그램 마칠때까지 유지돼요
	static int sequence = 0; 
	
	public Member save(Member member) {
		member.setNo(++sequence);
		store.put(member.getNo(), member);
		return member;
	}
	
//	회원 단건 조회 메소드	pk대신 식별자 key->id
	public Member findById(int no) {
		return store.get(no);
	}
//	회원 목록 조회
	public List<Member> findAll(){	// <Member>여러개, findAll(인자X)
		return new ArrayList<>(store.values());		//map<> => List<>로 변환	
	}
	
//	회원 전체 삭제
	public void clearStore() {
		store.clear();
	}
	}
