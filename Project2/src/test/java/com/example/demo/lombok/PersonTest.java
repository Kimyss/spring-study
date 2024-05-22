package com.example.demo.lombok;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest		//스프링 컨테이너 환경 임시로 가져오기
public class PersonTest {
	
	@Test	//단위테스트 만들기
	void 롬복테스트(){
		
		Person person1 =  new Person();		// 디폴트생성자
		person1.setName("둘리");				// setter
		person1.setAge(12);
		
		System.out.println(person1.getName());
		System.out.println(person1.getAge());
		
//		모든 멤버를 입력받는 생성자
		Person person2 = new Person("또치", 15);
		System.out.println(person2.toString());		//object원래는 주소값 재정의했기에 잘 출력
		
//		builder :  메소드 체인 패턴으로 객체를 생성하는 생성자
//		객체의 정보를 선택적으로 입력할 수 있음 - 원하는 값만 입력가능
		Person person3 = Person.builder().name("도우너").age(17).build();	//build까지 작성해야 객체가 반환됩니다.
		System.out.println(person2.toString());
		
	}

}
