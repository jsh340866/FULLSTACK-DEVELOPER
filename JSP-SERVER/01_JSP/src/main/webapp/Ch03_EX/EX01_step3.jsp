<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!--
	[EX01-step3] 최초 name + step1 + step2 + 본인이 만든 step3 모두 출력
	URL이 EX01_forward_form.html 로부터 step1.jsp 그대로 유지되는지 확인할 것!
-->
<%
	request.setAttribute("step3", "step3처리완료");
%>
<!DOCTYPE html>
<html>
<head><meta charset="UTF-8"><title>step3</title></head>
<body>
	<h1>Forward 체인 결과 (URL을 확인해보세요!)</h1>
	name : ${param.name}<br/>
	<%-- TODO: EL 또는 표현식으로 step1, step2, step3 출력 --%>
</body>
</html>
