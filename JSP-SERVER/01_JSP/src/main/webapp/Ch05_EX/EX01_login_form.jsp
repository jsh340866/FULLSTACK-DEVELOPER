<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!--
	[EX01-form] 이미 로그인 상태면 main 으로 이동시키기
-->
<%
	// TODO: session.getAttribute("isAuth") 가 null 이 아니면 main.jsp 로 redirect
%>
<!DOCTYPE html>
<html>
<head><meta charset="UTF-8"><title>EX01 - 로그인</title></head>
<body>
	<h1>LOGIN</h1>
	<div style="color:orange">${param.msg}</div>
	<form action="./EX01_login.jsp" method="post">
		아이디 : <input name="username" /><br/>
		비번 : <input name="password" type="password" /><br/>
		<button>로그인</button>
	</form>
</body>
</html>
