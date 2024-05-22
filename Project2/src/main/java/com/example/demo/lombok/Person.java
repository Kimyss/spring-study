package com.example.demo.lombok;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Data : Getter, Setter, ToString을 포함한다
@Getter
@Setter
@ToString
@NoArgsConstructor 	// 생성자	No: 디폴트생성자
@AllArgsConstructor // 생성자	모든멤버변수 초기화 생성자
@Builder 			// 생성자
public class Person {

	String name;
	int age;
//	멤버변수에 대한 getter와 setter, 생성자, 클래스 정보를 반환하는 toString만들기
//	또한 이전에는 제너레이트를 사용했다.
//	**lombok 사용하기 lombok class 상단에 작성

}
