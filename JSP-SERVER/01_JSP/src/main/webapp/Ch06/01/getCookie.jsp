<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	Cookie[] cookies = request.getCookies();
	for(Cookie cookie : cookies) {
		System.out.println("key : " + cookie.getName() + " val : " + cookie.getValue());
		%>
			<%= cookie.getName() %> : <%= cookie.getValue() %> <br/>
			<a href="./deleteCookie.jsp?name=<%=cookie.getName()%>"><%= cookie.getName() %> 쿠키삭제하기</a> <br/><br/>
		<%
	}

%>

</body>
</html>