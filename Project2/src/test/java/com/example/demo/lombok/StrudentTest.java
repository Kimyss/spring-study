package com.example.demo.lombok;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StrudentTest {

	@Test
	void 학생롬복테스트() {

		Student stu1 = new Student();
		stu1.setStNum(1001);
		stu1.setName("이순신");
		stu1.setAge(20);
		
		Student stu2 = new Student(1002, "김유신", 19);
		
		Student stu3 = Student.builder().stNum(1003).name("박혁거세").build();
		
		System.out.println(stu1);
		System.out.println(stu2);
		System.out.println(stu3);
	}
}
