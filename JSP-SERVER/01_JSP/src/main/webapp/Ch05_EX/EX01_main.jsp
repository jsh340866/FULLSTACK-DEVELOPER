<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!--
	[EX01-main] 인증 가드
	요구사항:
		1) session 에 isAuth 없으면 → EX01_login_form.jsp?msg=로그인필요 redirect
		2) 있으면 환영메시지 + 로그아웃 링크
-->
<%
	// TODO: 인증 가드
%>
<!DOCTYPE html>
<html>
<head><meta charset="UTF-8"><title>MAIN</title></head>
<body>
	<h1>MAIN PAGE</h1>
	안녕하세요, <%-- TODO: username 표시 --%> 님!<br/>
	<a href="./EX01_logout.jsp">로그아웃</a>
</body>
</html>
