package com.example.demo.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Order;

@SpringBootTest
public class Quiz3 {
	
	@Autowired
	OrderRepository orderRepository;
	
	@Test
	public void Order데이터등록() {
		List<Order> list = new ArrayList<>();
		
//		of함수 : 생성자 대신 LocalDate의 객체를 생성하는 함
		LocalDate localdate1 = LocalDate.of(2023, 07, 1);
		LocalDate localdate2 = LocalDate.of(2023, 07, 1);
		LocalDate localdate3 = LocalDate.of(2023, 07, 1);
		
		Order order1 = Order.builder().customerName("둘리").orderDate(localdate1).shipAddress("인천 구월동").build();
		Order order2 = Order.builder().customerName("또치").orderDate(localdate2).shipAddress("인천 연수동").build();
		Order order3 = Order.builder().customerName("도우너").orderDate(localdate3).shipAddress("부산 동래동").build();
		
		list.add(order1);		
		list.add(order2);		
		list.add(order3);
		orderRepository.saveAll(list);
	}
	

}