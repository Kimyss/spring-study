package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.dto.MemberDTO;
import com.example.demo.entity.Member;
import com.example.demo.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	MemberRepository repository;

	@Override
	public Page<MemberDTO> getList(int pageNumber) {
		
		int pageIndex = (pageNumber == 0) ? 0 : pageNumber - 1; //page index는 0부터 시작
		
		Pageable pageable = PageRequest.of(pageIndex, 10, Sort.by("regDate").descending());  //페이지번호, 회원데이터건수, 정렬방법을 입력하여 페이징 조건 생성
		
		Page<Member> entityPage = repository.findAll(pageable); //회원 목록을 페이지에 담아서 조회하기
		
		Page<MemberDTO> dtoPage = entityPage.map( entity -> entityToDto(entity) ); //엔티티 타입의 페이지를 DTO 타입으로 변환

		return dtoPage;
		
	}
	

}
