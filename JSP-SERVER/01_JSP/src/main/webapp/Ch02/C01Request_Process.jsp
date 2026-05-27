<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%
	/*  
		request 내장객체 : 요청정보값 저장(Http Request Protocol의 구조형태)
		HttpServeletRequest 클래스로 생성된 객체  - 중요
	*/
	
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	String bgColor = request.getParameter("bgcolor");
	System.out.printf("%s %s %s \n",username,password,bgColor);
%>    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor=<%=bgColor%> >

	<h1>C01 Process File</h1>
	
	username : <%=username %><br/>
	password : <%=password %><br/>
	bgcolor : <%=bgColor %><br/>






</body>
</html>