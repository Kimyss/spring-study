package com.example.demo.service;
//부모는 인터페이스로 만들어

import org.springframework.data.domain.Page;

import com.example.demo.dto.MemberDTO;
import com.example.demo.entity.Member;

public interface MemberService {
	
	Page<MemberDTO> getList(int pageNumber);		//<MemberDTO> 페이지객체(리턴타입)  페이지번호 int pageNumber
	
//	엔티티를 DTO로 변환하는 메소드. 하나씩 꺼내서 디티오로 옮겨요 default를 사용하여 일반메소드 만드세요
	default MemberDTO entityToDto(Member entity) {
		MemberDTO dto = MemberDTO.builder().id(entity.getId())
				.password(entity.getPassword())
				.name(entity.getName())
				.regDate(entity.getRegDate())
				.modDate(entity.getModDate())
				.build();
		
		return dto;
	}
	
//	DTO를 엔티티로 변환하는 메소드
	default Member dtoToEntity(MemberDTO dto) {
		
		Member entity = Member.builder()
				.id(dto.getId())
				.password(dto.getPassword())
				.name(dto.getName())
				.build();
				
			return entity;
				
	}
	
}
