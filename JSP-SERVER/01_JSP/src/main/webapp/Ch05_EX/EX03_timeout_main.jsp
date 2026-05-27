<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	if(session.getAttribute("isAuth") == null){
		out.println("<h1>세션 만료!</h1>");
		out.println("<a href='./EX03_timeout_login.jsp'>다시 로그인</a>");
		return;
	}
%>
<!DOCTYPE html>
<html>
<head><meta charset="UTF-8"><title>MAIN</title></head>
<body>
	<h1>로그인 유지중</h1>
	3초 후 새로고침해보세요 - 만료 화면이 보일 것 입니다.<br/>
	<a href="./EX03_timeout_main.jsp">새로고침</a>
</body>
</html>
