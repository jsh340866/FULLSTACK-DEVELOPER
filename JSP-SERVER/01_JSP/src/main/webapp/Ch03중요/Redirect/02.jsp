<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	
	System.out.println("현재위치 : 02.jsp");
	request.setAttribute("C02", "02_Value");
	
	// Redirect
	// 
	response.sendRedirect("./03.jsp?username="+username+"&password="+password);
	
	
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>02.JSP PAGE</h1>
	USERNAME : <%=username %><br/>
	PASSWORD : <%=password %><br/>

</body>
</html>