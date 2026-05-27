<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="Ch04_EX.*" %>
<!--
	[EX04] 트랜잭션 테스트
	요구사항:
		1) 책 2건 INSERT
		2) 두번째 INSERT 전에 강제로 예외 발생 (throw new RuntimeException("강제 에러"))
		3) catch 에서 rollback → DB에 첫번째도 저장되지 않아야 함
		4) 일반 try-finally 로 disConn
-->
<%
	String result = "";
	try{
		DbUtils.conn();
		DbUtils.TxStart();

		// TODO: 첫번째 BookDto 생성 후 insertBook

		// TODO: 강제 예외
		// throw new RuntimeException("강제 에러");

		// TODO: 두번째 BookDto 생성 후 insertBook

		DbUtils.TxEnd();
		result = "COMMIT 완료";
	}catch(Exception e){
		try{ DbUtils.RollBack(); }catch(Exception ex){}
		result = "ROLLBACK : " + e.getMessage();
	}finally{
		try{ DbUtils.disConn(); }catch(Exception ex){}
	}
%>
<!DOCTYPE html>
<html>
<head><meta charset="UTF-8"><title>TX 결과</title></head>
<body>
	<h1>트랜잭션 결과</h1>
	<%= result %>
	<hr/>
	<a href="./EX01_list.jsp">목록 확인</a>
</body>
</html>
