<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!--
	[EX03] 세션 타임아웃 테스트
	요구사항:
		1) 버튼 클릭으로 즉시 로그인 (admin)
		2) session.setMaxInactiveInterval(3)  - 3초만 유효
		3) main 페이지 3초 후 새로고침 → 만료 확인
-->
<%
	if("yes".equals(request.getParameter("login"))){
		session.setAttribute("isAuth", true);
		// TODO: 만료시간 3초 설정
		response.sendRedirect("./EX03_timeout_main.jsp");
		return;
	}
%>
<!DOCTYPE html>
<html>
<head><meta charset="UTF-8"><title>EX03 - 타임아웃</title></head>
<body>
	<h1>세션 3초 타임아웃 테스트</h1>
	<a href="?login=yes">로그인 (3초 유효)</a>
</body>
</html>
