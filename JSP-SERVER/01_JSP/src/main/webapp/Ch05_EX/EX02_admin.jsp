<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!--
	[EX02-admin] 관리자 전용 페이지
	요구사항:
		1) role != ROLE_ADMIN 이면 sendError(403, "접근금지") 또는 main 으로 redirect
-->
<%
	String role = (String)session.getAttribute("role");
	// TODO: 권한 가드
%>
<!DOCTYPE html>
<html>
<head><meta charset="UTF-8"><title>ADMIN</title></head>
<body>
	<h1>관리자 전용 페이지</h1>
</body>
</html>
