package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dto.MemberDTO;
import com.example.demo.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired // 컨트롤러에서 서비스 주입받아
	MemberService service;

//	/member/list?page=1 OK
//	/member/list	OK 기본값
	@GetMapping("/list") // 리턴타입 void: "HTML문서 URL경로가 파일경로 String 직접설정 하여 return
	public void list(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {

		Page<MemberDTO> list = service.getList(page); // 반환 된 데이터가 페이지 객체
		model.addAttribute("list", list);
	}

//	등록 폼 반환 메소드
	@GetMapping("/register")
	public void register() {

	}

//	등록처리 메소드
	@PostMapping("/register") // dto : 파라미터, RedirectAttributes 모델객체 addFlashAttribute: 뷰단으로 데이터 전달함수
	public String registerPost(MemberDTO dto, RedirectAttributes redirectAttributes) {
		boolean isSucces = service.register(dto);

		if (isSucces) {
			return "redirect:/member/list"; // 성공 시 목록 화면 이동
		} else {
			redirectAttributes.addFlashAttribute("msg", "아이디가 중복되어 등록에 실패하였습니다.");
			return "redirect:/member/register"; // 실패 시 회원가입으로 재이동
		}

	}
	
//	회원 상세조회 메소드
	@GetMapping("/read")
	public void read(@RequestParam(name = "id") String id,
			@RequestParam(name = "page", defaultValue = "0") int page,
			Model model){
		MemberDTO dto = service.read(id);
		model.addAttribute("dto", dto);		//사용자정보
		model.addAttribute("page", page);		//페이지번호
		
		
	}
	
}
