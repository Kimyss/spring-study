package com.example.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//회원등록 폼을 보낼 서블릿 만들기

@WebServlet(name = "FormServlet", urlPatterns = "/servlet/form")		//타서블릿과 중복불가
public class FormServlet extends HttpServlet{
	
	
//	사용자 요청을 처리하는 메소드 재정의
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		resp -> 서블릿 응답객체
		
		resp.setContentType("text/html");		// Header 설정(응답형식)
		resp.setCharacterEncoding("utf-8");		// Header 설정(인코딩)
		
		PrintWriter w = resp.getWriter();		//body
		
//		회원등록 폼 HTML 만들기. body부분
		 w.write("<!DOCTYPE html>\n" +
			       "<html>\n" +
			       "<head>\n" +
			       " <meta charset=\"UTF-8\">\n" +
			       " <title>Title</title>\n" +
			       "</head>\n" +
			       "<body>\n" +
			       "<form action=\"/servlet/save\" method=\"post\">\n" +
			       " 이름: <input type=\"text\" name=\"username\" />\n" +
			       " 암호: <input type=\"text\" name=\"password\" />\n" +
			       " <button type=\"submit\">전송</button>\n" +
			       "</form>\n" +
			       "</body>\n" +
			       "</html>\n");
		
//		 주소만들기
//		 기본주소 : 포트/상세주소?파라미터
//		 localhost:8080/servlet/form
	}

}
	
	
