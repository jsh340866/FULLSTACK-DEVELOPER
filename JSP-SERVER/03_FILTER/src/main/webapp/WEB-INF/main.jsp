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
	<hr/>
	역할 : ${role}		<br/>
	<%-- 로그인 상태 : ${isAuth? '로그인':'로그인상태아님'}<br/> --%>
	<hr/>
	<a href="${pageContext.request.contextPath}/logout.do">로그아웃</a>
	
	
	<%
		
		if(session.getAttribute("isAuth")==null ){
			session.setAttribute("message", "로그인이 필요한 페이지입니다.");
			response.sendRedirect(request.getContextPath()+"/login.do");
			return ;
		}
	
		session.removeAttribute("message");
	%>
</body>
</html>