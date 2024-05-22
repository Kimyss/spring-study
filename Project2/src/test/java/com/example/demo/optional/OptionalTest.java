package com.example.demo.optional;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OptionalTest {
	
//		단위테스트시 테스트가 잘 안될 경우  @SpringBootTest / @Test 부터 확인요망
//		Optional : 값을 감싸고 있는 wrapper클래스 (상자가있고 값이 담겨있는 -> optional 상자 안에 객체가 담겨있는)
//		객체에 값이 있는지 없는지를 확인하기 위해 사용
	
	@Test
	void Optional사용하기() {
		String str = "apple";
		Optional<String> opt = Optional.of(str);
//		옵셔널안에 애플이란 클래스 감싸져있어요
				
		System.out.println("Optional에서 값 꺼내기 : " + opt.get());		//box안에 apple value꺼내요
		System.out.println("Optional에서 값 없는지? : " + opt.isEmpty());
		System.out.println("Optional에서 값 있는지? : " + opt.isPresent());
		
//		Optional에 값이 없으면, 바나나로 대체
		String str2 = "monkey";
		System.out.println(Optional.ofNullable(str2).orElse("banana"));	//마치 조건문 처럼 생각
	}
	
	@Test
	void of와ofNullable의차이() {
//		of : Optional을 생성하는 함수. null입력 불가
//		ofNullable : Optional을 생성하는 함수. null 입력 가능
		
		String str = null;
		
//		생성자 함수 대신에 쓰여진다
//		Optional<String> opt1 = Optional.of(str);
		Optional<String> opt2 = Optional.ofNullable(str);
	}
	
	@Test
	void 빈객체사용시() {
		Optional<String> opt = Optional.ofNullable(null);
//		System.out.println(opt.get());	// 에러
		
//		if를 사용하여 null값 체크하기
		String str = "banana";
		if(str != null) {
			System.out.println("값이 존재합니다");
		}
		
//		Optionnal 사용하여 null값 체크하기
		Optional<String> opt2 = Optional.ofNullable(str);
		opt2.ifPresent(name -> System.out.println("값 존재해요 " + name));		//람다식 함수써야해요
	}
	
	
	
	
	
	
	

	
	
}
