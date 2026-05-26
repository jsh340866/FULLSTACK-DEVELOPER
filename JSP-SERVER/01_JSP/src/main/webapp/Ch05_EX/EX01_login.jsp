<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!--
	[EX01-login]
	요구사항:
		1) username/password 받기
		2) "admin"/"1234" 만 통과
		3) 실패시 EX01_login_form.jsp?msg=실패  로 redirect
		4) 성공시 session 에 isAuth=true, username 저장 → EX01_main.jsp redirect
-->
<%
	request.setCharacterEncoding("UTF-8");
	String username = request.getParameter("username");
	String password = request.getParameter("password");

	// TODO: admin/1234 검증

	// TODO: 성공 → session 저장 → redirect
	// TODO: 실패 → redirect 폼
%>
