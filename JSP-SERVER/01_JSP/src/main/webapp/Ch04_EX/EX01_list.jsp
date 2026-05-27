<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, Ch04_EX.*" %>
<!--
	[EX01] tbl_book 전체조회 후 테이블 출력
-->
<%
	List<BookDto> list = null;
	try{
		DbUtils.conn();
		list = DbUtils.selectAll();
		DbUtils.disConn();
	}catch(Exception e){
		e.printStackTrace();
	}
%>
<!DOCTYPE html>
<html>
<head><meta charset="UTF-8"><title>도서목록</title>
<style>
	table{border-collapse:collapse}th,td{border:1px solid #999;padding:6px 10px}
</style>
</head>
<body>
	<h1>도서 목록</h1>
	<a href="./EX02_insert_form.html">신규 등록</a> | <a href="./EX03_search_form.html">검색</a>
	<table>
		<thead><tr><th>No</th><th>제목</th><th>저자</th><th>가격</th><th>등록일</th></tr></thead>
		<tbody>
			<%-- TODO: for(BookDto dto : list) 반복 출력 (list == null 가드 필요) --%>
		</tbody>
	</table>
</body>
</html>
