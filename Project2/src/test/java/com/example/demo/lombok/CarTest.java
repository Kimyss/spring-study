package com.example.demo.lombok;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CarTest {

	@Test
	void cartest() {
		Car sonata = new Car();
		sonata.setModelName("소나타");
		sonata.setCompany("현대");
		sonata.setColor("하양이");
		
		Car k5 = new Car("케이파이브", "기아", "검둥이");
		
		Car rei = Car.builder().company("기아").color("베이지").build();
		
		System.out.println(sonata);
		System.out.println(k5);
		System.out.println(rei.toString());
		
	}
}
