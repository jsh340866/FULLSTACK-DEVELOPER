<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	
	//Request 속성설정
	request.setAttribute("t1", "v1");

    //세션 속성설정(기본 유지시간 1800초(60*30))
    session.setAttribute("t2", "v2");
    
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>setSession Page</h1>
	REQUEST t1 : ${t1}<br/>
	SESSION t2 : ${t2}<br/>
	<hr/>
	<!-- METHOD : GET -->
	<a href="./getSession.jsp"> 세션의 속성 확인!</a>
</body>
</html>