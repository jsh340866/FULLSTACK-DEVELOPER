<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!--
	[EX03] 콘솔에서 단(2~9)을 입력받아 구구단을 HTML 테이블로 출력
	요구사항:
		1) Scanner 로 단 수 입력
		2) 2~9 범위 체크 (벗어나면 메시지 출력 후 return)
		3) <table>로 단×i = 결과 형태 출력
-->
<%
	System.out.print("단 수(2~9) 입력 : ");
	Scanner sc = new Scanner(System.in);
	int dan = sc.nextInt();

	// TODO: 2~9 범위 체크
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"><title>EX03</title>
<style>
	table{border-collapse:collapse;margin:20px 0}
	td{border:1px solid #999;padding:8px 12px;text-align:center}
	caption{font-weight:bold;font-size:1.2rem;margin-bottom:8px}
</style>
</head>
<body>
	<h1>EX03 - 구구단</h1>
	<table>
		<caption><%-- TODO: dan 단 표시 --%> 단</caption>
		<tbody>
			<%-- TODO: for(i=1;i<=9;i++) 반복하여 행 만들기 --%>
		</tbody>
	</table>
	<hr/>
	<a href="./README.jsp">목록으로</a>
</body>
</html>
