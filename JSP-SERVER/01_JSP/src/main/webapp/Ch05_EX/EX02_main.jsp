<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!--
	[EX02-main]
	요구사항:
		1) session 에 role 없으면 로그인폼으로 redirect
		2) role == ROLE_ADMIN 일때만 "관리자 페이지로 이동" 링크 표시
		3) 둘다 "일반 메뉴" 표시
-->
<%
	String role = (String)session.getAttribute("role");
	if(role == null){
		response.sendRedirect("./EX02_role_login.jsp");
		return;
	}
%>
<!DOCTYPE html>
<html>
<head><meta charset="UTF-8"><title>MAIN</title></head>
<body>
	<h1>MAIN</h1>
	현재 Role : <%= role %><br/>
	<ul>
		<li>일반 메뉴</li>
		<%-- TODO: role == ROLE_ADMIN 일때만 admin 링크 노출 --%>
	</ul>
</body>
</html>
