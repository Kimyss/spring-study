package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
// lombok사실 없어도되지만 클래스, 생성자 편하게 만드려고 쓰는거에요
public class BookDTO {
	
	String title; 
	
	String publisher;
	
	int price;

}
