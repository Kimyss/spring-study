package com.example.demo.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.BookDTO;
import com.example.demo.dto.PersonDTO;
import com.example.demo.dto.SampleDTO;

@Controller
@RequestMapping("/quiz") // 공통경로
public class QContrloler {

	@GetMapping("/q1") // 마지막경로 각 메소드에 붙여주세요
	public void q1(Model q1q1) {
		q1q1.addAttribute("msg1", "둘리");
		q1q1.addAttribute("msg2", 20);
		q1q1.addAttribute("msg3", "구월동");
	}

	@GetMapping("/q2") // 마지막경로 각 메소드에 붙여주세요
	public void q2(Model q2q2) {
		q2q2.addAttribute("msg4", "스프링부트웹코딩단");
		q2q2.addAttribute("msg5", "구멍가게 코딩단");
		q2q2.addAttribute("msg6", LocalDate.of(2022, 12, 25));
	}

//	타임리프 기본경로 : /templates
//	Model 정보를 전달 시켜주는 객체
//	addAttribute : 정보를 담아주는 함수

	@GetMapping("/q3")
	public void ex3(Model model) {
		PersonDTO personDTO = new PersonDTO("둘리", 20, "인천 구월동");
		model.addAttribute("dto", personDTO);
	}
	
	@GetMapping("/q4")
	public void ex4(Model model) {
		BookDTO book1 = new BookDTO("인어공주", "디즈니", LocalDate.now());
		model.addAttribute("dto", book1);
	}
	
	@GetMapping("/q5")
	public void ex5(Model model) {
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		model.addAttribute("num", arr);
	}
	
	@GetMapping("/q6")
	public void ex6(Model model) {
		
		List<PersonDTO> list = new ArrayList<>();
		
		list.add(new PersonDTO("둘리", 20, "인천 구월동"));
		list.add(new PersonDTO("또치", 30, "서울 신림동"));
		list.add(new PersonDTO("도우너", 40, "부산 문래동"));
		
		model.addAttribute("list", list);
	}
	
	@GetMapping({"/q7"})
	public void ex7(Model model) {
		List<SampleDTO> list = new ArrayList();
    	for(int i=1; i<=20;i++) {
    		list.add(new SampleDTO(i, i+"번", LocalDate.now()));
    	}
    	model.addAttribute("list", list);
		
	}
	
	@GetMapping({"/q8", "/q9"})
	public void ex8(Model model) {
		List<PersonDTO> list = new ArrayList<>();
		list.add(new PersonDTO("박하나",25,"인천 구월동"));
		list.add(new PersonDTO("홍재범",17,"서울 신림동"));
		list.add(new PersonDTO("문유리",31,"부산 문래동"));
		list.add(new PersonDTO("김재민",8,"인천 연수동"));
		list.add(new PersonDTO("장유라",33,"부산 문래동"));
        model.addAttribute("list", list);
	}

}
