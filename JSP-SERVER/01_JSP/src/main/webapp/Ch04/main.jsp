<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>MAIN PAGE</h1>
	<pre>환영합니다 - !</pre>
	<span style="font-size:.7rem;color:green;">
	    	 ${message}
	</span>
	


	<%
		session.removeAttribute("isAuth");
		session.removeAttribute("message");
	%>
</body>
</html>