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
	/* response.sendRedirect("./C02Request.jsp"); */
	
	/* JSP 에서 response로 Error 정보 전달 */
	/* response.sendError(HttpServletResponse.SC_REQUEST_TIMEOUT); */
	/* response.sendError(HttpServletResponse.SC_NOT_FOUND); */
	
	/* Servlet 에서 오류페이지 랜딩 방법 */
	/* throw new ServletException("오류페이지 입니다.") */
	
	/* 새로고침 */
	/* response.setIntHeader("Refresh",3); */
	
	/* OutStream 추출 */
	/* ServletOutputStream bout = response.getOutputStream();
	bout.write('a');
	bout.write(98);	//b
	bout.flush();
	bout.close(); */
	
	/* Out */
	out.write('a');
	out.write('b');
	out.write('c');
	
%>


	<%@page import = "java.util.*" %>
	<%=new Date() %>




</body>
</html>