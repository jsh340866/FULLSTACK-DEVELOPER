<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	
	System.out.println("현재위치 : 03.jsp");
	
	/* Object ob = request.getAttribute("C02");
	System.out.println("C02 : " + ob);*/
	request.setAttribute("C03", "03_Value");
	// Forward처리 04.jsp 
	request.getRequestDispatcher("./04.jsp").forward(request,response);
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