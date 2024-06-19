package com.example.demo.dto;

import java.util.Arrays;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
//User..Detail 그 부분 import / 생성자 만들라고 옵션 나오면 두번째 옵션 선택하세욤

public class CustomUser extends User {
	
//	MemberDTO ->USER
//	사용자 아이디, 패스워드, 권한을 꺼내서 User객체 생성 
	public CustomUser(MemberDTO dto) {
		super(dto.getId(), dto.getPassword(), Arrays.asList(new SimpleGrantedAuthority(dto.getRole())));
		
	}

}
