package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CustomUser;
import com.example.demo.dto.MemberDTO;
import com.example.demo.service.MemberService;

@Service	//스프링컨테이너가 빈으로등록이 되어있어야 해
public class UserDetailServiceImpl implements UserDetailsService {
	
	@Autowired
	MemberService service;
	
//	사용자 아이디를 기반으로 인증객체를 생성하는 메소드 
//	사실상 로그인처리하는 기능이라고 생각하면 돼 | username: 사용자 아이디
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("Login ID: "+ username);
		
		MemberDTO dto = service.read(username);
		
		if(dto == null) {
			throw new UsernameNotFoundException("");		//사용자 정보가 없다면 에러발생 시킴
		}else {
			return new CustomUser(dto);		//dto를 인증 객체로 변환하여 반환
		}
	}

}
