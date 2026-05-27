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
	/* String username = request.getParameter("username");
	String password = request.getParameter("password");
	String bgColor = request.getParameter("bgcolor");
	System.out.printf("%s %s %s \n",username,password,bgColor); */
	
%>    
    
    
<jsp:useBean id="dto" class="Ch02.C04TestDto" scope="request"/>
<jsp:setProperty property="*" name="dto"/>
<%-- <jsp:setProperty property="username" param="username" name="dto"/>
<jsp:setProperty property="password" param="password" name="dto"/>
<jsp:setProperty property="bgcolor" param="bgcolor" name="dto"/> --%>
<%
	System.out.println("DTO : " + dto);
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor=<%=dto.getBgcolor()%> >

	<h1>C04 Process File</h1>
	
	username : <%=dto.getUsername() %><br/>
	password : <%=dto.getPassword() %><br/>
	bgcolor : <%=dto.getBgcolor() %><br/>






</body>
</html>