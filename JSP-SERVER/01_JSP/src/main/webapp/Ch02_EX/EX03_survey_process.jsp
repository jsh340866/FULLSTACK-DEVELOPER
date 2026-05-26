<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!--
	[EX03] 설문조사 처리
	요구사항:
		1) gender, age 는 getParameter
		2) hobby 는 getParameterValues (배열)
		3) 선택된 hobby를 콤마로 연결해 출력
-->
<%
	request.setCharacterEncoding("UTF-8");

	// TODO: 파라미터 추출
	String gender = null;
	String age = null;
	String[] hobby = null;
%>
<!DOCTYPE html>
<html>
<head><meta charset="UTF-8"><title>설문결과</title></head>
<body>
	<h1>설문 결과</h1>
	성별 : <%-- TODO --%><br/>
	연령대 : <%-- TODO --%>대<br/>
	관심분야 :
	<%
		// TODO: hobby가 null 아닐때 콤마로 연결해 출력

	%>
</body>
</html>
