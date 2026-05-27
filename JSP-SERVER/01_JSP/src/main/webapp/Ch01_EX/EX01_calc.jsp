<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!--
	[EX01] 선언문으로 사칙연산 함수 4개를 만들고 표현식으로 결과 출력
	요구사항:
		1) 선언문 영역에 add/sub/mul/div(int,int) 메서드 작성
		2) div는 0으로 나눌 때 0 반환
		3) 표현식으로 a=10, b=5 결과 4줄 출력
-->
<%!
	// TODO 1: int add(int a,int b) 구현

	// TODO 2: int sub(int a,int b) 구현

	// TODO 3: int mul(int a,int b) 구현

	// TODO 4: int div(int a,int b) 구현 (b=0이면 0 리턴)

%>
<!DOCTYPE html>
<html>
<head><meta charset="UTF-8"><title>EX01</title></head>
<body>
	<h1>EX01 - 사칙연산</h1>
	<%
		int a = 10;
		int b = 5;
	%>
	<%-- TODO 5: 표현식으로 결과 출력 (예 : 10 + 5 = 15) --%>

	<hr/>
	<a href="./README.jsp">목록으로</a>
</body>
</html>
