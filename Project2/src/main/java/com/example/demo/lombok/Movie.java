package com.example.demo.lombok;

import java.time.LocalDate;

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

public class Movie {

	String title;
	String director;
	LocalDate date;
	
//	LocalDate 날짜타입
//	Date 타임존 없어요
}
