package com.example.demo.service;

import java.util.Optional;

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

	@Override
	public boolean register(MemberDTO dto) {
		
		String id = dto.getId();		//디티오 안에서 아이디 추출한 후 
		MemberDTO getDto = read(id);	
//		단건 조회, 조회한 결과에 있다는 것은 중복아이디가 있다는 것 
//		단건 상세 조회 메소드도 만들 필요 있어
		
		if(getDto != null) {
			System.out.println("사용중 아이디 입니다.");	
			return false;		//해당 아이디 사용된다면, 실패(false)반환
		}else {
			Member entity = dtoToEntity(dto);	
			repository.save(entity);	
			return true;		//해당 아이디 사용X면, 등록 후 성공(true)반환
		}
		
		
	}

	@Override
	public MemberDTO read(String id) {
		
		Optional<Member> result = repository.findById(id);
//		옵셔널의 특징은 박스 박스안에 엔티티(value)포함되어 있다. 겟 메소드로 꺼낸 후
//		엔티티를 디티오로 변환 후에 반환 하시길 체크 안하고 값을 꺼낸다면 에러나요
//		확인하는 부분 꼭 필요해
		
		if(result.isPresent()) {
			Member member = result.get();
			return entityToDto(member);		
		}else {
			return null;
		}
	}
	

}
