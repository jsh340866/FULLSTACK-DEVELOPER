<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	// 세션초기화
	session.invalidate();

	/* session.setAttribute("message", "로그아웃이 되었습니다."); */
	response.sendRedirect(request.getContextPath()+"/Ch05/02/main.jsp");
	
	

%>