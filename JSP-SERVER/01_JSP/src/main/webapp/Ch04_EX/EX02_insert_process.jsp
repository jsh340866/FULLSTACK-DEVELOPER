<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="Ch04_EX.*" %>
<!--
	[EX02] 도서 등록 처리
	요구사항:
		1) request.setCharacterEncoding("UTF-8")
		2) BookDto 만들기 (title/author/price)
		3) DbUtils.conn() → insertBook(dto) → disConn()
		4) 성공시 sendRedirect("./EX01_list.jsp")
		5) 예외시 rollback
-->
<%
	request.setCharacterEncoding("UTF-8");

	// TODO: 파라미터 추출 (price는 parseInt)

	// TODO: BookDto 생성

	try{
		// TODO: conn → TxStart → insertBook → TxEnd → disConn → redirect
	}catch(Exception e){
		DbUtils.RollBack();
		e.printStackTrace();
	}
%>
