package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Gift;

@SpringBootTest
public class Quiz2 {

	@Autowired
	GiftRepository giftRepository;

	@Test
	public void Gift데이터등록() {
		List<Gift> list = new ArrayList<>();

		Gift gift1 = Gift.builder().name("참치세트").type("식품").price(10000).build();
		Gift gift2 = Gift.builder().name("햄세트").type("식품").price(20000).build();
		Gift gift3 = Gift.builder().name("샴푸세트").type("생활용품").price(30000).build();
		Gift gift4 = Gift.builder().name("세차용품").type("생활용품").price(40000).build();
		Gift gift5 = Gift.builder().name("주방용품").type("생활용품").price(50000).build();
		Gift gift6 = Gift.builder().name("노트북").type("가전제품").price(60000).build();
		Gift gift7 = Gift.builder().name("벽걸이TV").type("가전제품").price(70000).build();

		list.add(gift1);
		list.add(gift2);
		list.add(gift3);
		list.add(gift4);
		list.add(gift5);
		list.add(gift6);
		list.add(gift7);

		giftRepository.saveAll(list);
	}

	@Test
	public void 데이터단건조회() {
		Optional<Gift> result = giftRepository.findById(1);
		if (result.isPresent()) {
			Gift gift = result.get();
			System.out.println(gift);
		}
	}
	@Test
	public void 데이터전체조회() {
		List<Gift> list = giftRepository.findAll();
		for (Gift gg : list) {
			System.out.println(gg);
		}
	}
	
	@Test
	public void 데이터수정() {
		Optional<Gift> result = giftRepository.findById(2);
		Gift gg = result.get();
		gg.setPrice(25250);
		giftRepository.save(gg);
		
	}
	
	@Test
	public void 데이터삭제() {
		giftRepository.deleteById(1);
	}
	
	@Test
	public void 데이터일괄삭제() {
		giftRepository.deleteAll();
	}

}