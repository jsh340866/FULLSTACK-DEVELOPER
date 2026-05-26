<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><meta charset="UTF-8"><title>로그인</title></head>
<body>
	<h1>로그인 (URL이 EX02_login.jsp 로 바뀐 것 확인!)</h1>
	<form action="javascript:void(0)" method="post">
		<%-- TODO: ${param.userid} 로 가입한 ID 자동입력 (readonly) --%>
		아이디 : <input type="text" name="userid" value="${param.userid}" readonly /><br/>
		비밀번호 : <input type="password" name="password" /><br/>
		<button>로그인</button>
	</form>
</body>
</html>
