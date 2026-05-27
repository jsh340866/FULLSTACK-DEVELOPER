<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!--
	[EX03] 나이 입력 폼 + 유효성검사 forward
	요구사항:
		1) age 입력
		2) Process에서 0 < age < 150 검증
		3) 실패시 errorMsg attribute 셋팅 후 폼으로 forward (값 유지)
		4) 성공시 결과 페이지로 forward
-->
<!DOCTYPE html>
<html>
<head><meta charset="UTF-8"><title>EX03</title></head>
<body>
	<h1>나이 입력</h1>
	<div style="color:red">${errorMsg}</div>
	<form action="./EX03_age_process.jsp" method="post">
		나이 : <input type="number" name="age" value="${param.age}" /><br/>
		<button>제출</button>
	</form>
</body>
</html>
