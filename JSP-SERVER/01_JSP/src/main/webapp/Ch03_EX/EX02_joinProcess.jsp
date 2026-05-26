<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!--
	[EX02-joinProcess] 가입 처리
	요구사항:
		1) userid, password 받기
		2) (실제 DB저장 생략) 콘솔에 "가입완료" 출력
		3) redirect → EX02_login.jsp?userid=xxx
-->
<%
	request.setCharacterEncoding("UTF-8");
	String userid = request.getParameter("userid");
	String password = request.getParameter("password");

	System.out.println("[가입완료] " + userid);

	// TODO: response.sendRedirect 로 EX02_login.jsp?userid=xxx 이동
%>
