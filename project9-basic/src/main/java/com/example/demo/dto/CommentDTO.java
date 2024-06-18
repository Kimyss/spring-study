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
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentDTO {
//엔티티와 구조가 같아욤
	
	int commentNo;
	
	int boardNo;
	
	String content;
	
	String writer;
	
	LocalDateTime regDate;
	
	LocalDateTime modDate;

}
