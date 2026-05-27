<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, Ch04_EX.*" %>
<!--
	[EX03] 제목 LIKE 검색결과
-->
<%
	request.setCharacterEncoding("UTF-8");
	String keyword = request.getParameter("keyword");

	List<BookDto> list = null;
	try{
		DbUtils.conn();
		list = DbUtils.searchByTitle(keyword);
		DbUtils.disConn();
	}catch(Exception e){
		e.printStackTrace();
	}
%>
<!DOCTYPE html>
<html>
<head><meta charset="UTF-8"><title>검색결과</title></head>
<body>
	<h1>"${param.keyword}" 검색결과</h1>
	<%-- TODO: list 출력 (없을때 "검색결과 없음" 메시지) --%>
	<hr/>
	<a href="./EX03_search_form.html">다시 검색</a>
</body>
</html>
