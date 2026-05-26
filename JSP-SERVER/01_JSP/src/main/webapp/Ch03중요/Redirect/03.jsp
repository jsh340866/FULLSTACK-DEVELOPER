<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	
	System.out.println("현재위치 : 03.jsp");
	
	// 세션SCOPE에 보관
	session.setAttribute("username", username);
	session.setAttribute("password", password);

	
	// Redirect
	response.sendRedirect("./04.jsp");
	
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>03.JSP PAGE</h1>
	USERNAME : <%=username%><br /> 
	PASSWORD : <%=password%><br />

</body>
</html>