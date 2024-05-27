package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.servlet.ServletComponentScan;

// 서블릿 자동 등록하기
@ServletComponentScan
@SpringBootTest
class Project4ApplicationTests {

	@Test
	void contextLoads() {
	}

}
