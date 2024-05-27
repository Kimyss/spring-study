package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//	@lombok 멤버클래스의 좀 더 편리한 사용을 위해 lombok사용하자 없어도 객체생성에는 문제없긴하다
@Getter
@Setter
@ToString		//재정의
@NoArgsConstructor		//생성자
@AllArgsConstructor		//생성자
@Builder				//생성자
public class Member {
	
	int no;
	
	String userId;
	
	String password;
	

}











