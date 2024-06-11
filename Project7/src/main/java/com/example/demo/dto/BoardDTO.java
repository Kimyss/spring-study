package com.example.demo.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class BoardDTO {
	
	int no;
	String title;
	String content;
	String writer;
	LocalDateTime regDate;	
	LocalDateTime modDate;
	
//	Entity에서는 Date 상속받았으나 여기서는 작성요망
//	Entity는 Database에 전달
//	DTO는 view단에 전달
//	서비스 : DATA가공, 비즈니스로직
	

}
