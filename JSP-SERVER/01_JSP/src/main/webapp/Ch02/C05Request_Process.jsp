<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%
	/*  
		request 내장객체 : 요청정보값 저장(Http Request Protocol의 구조형태)
		HttpServeletRequest 클래스로 생성된 객체  - 중요
	*/
	
	/* 문자셋 설정 */
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html; charset=UTF-8");
	//
	
	
%>    
    
    
<jsp:useBean id="dto" class="Ch02.C05UserDto" scope="request"/>
<jsp:setProperty name="dto" property="*" />

<%
	System.out.println("DTO : " + dto);
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>C05 Process File</h1>
	<hr/>
	DTO : <%=dto %>
	<hr/>





</body>
</html>