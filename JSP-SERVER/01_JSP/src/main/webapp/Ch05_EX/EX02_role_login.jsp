<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!--
	[EX02-role-login] role 선택해서 로그인
	요구사항:
		1) 폼에 select role (ADMIN / USER)
		2) 로그인 후 session 에 role 저장
		3) main 으로 이동
-->
<!DOCTYPE html>
<html>
<head><meta charset="UTF-8"><title>EX02 - Role 로그인</title></head>
<body>
	<h1>Role 선택 로그인</h1>
	<form action="./EX02_role_process.jsp" method="post">
		아이디 : <input name="username" /><br/>
		Role :
		<select name="role">
			<option value="ROLE_ADMIN">관리자</option>
			<option value="ROLE_USER">일반사용자</option>
		</select><br/>
		<button>로그인</button>
	</form>
</body>
</html>
