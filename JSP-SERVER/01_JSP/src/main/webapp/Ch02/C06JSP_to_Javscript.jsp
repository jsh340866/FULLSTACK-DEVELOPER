<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String msg1 = "HELLO WORLD1";
	String msg2 = "HELLO WORLD2";

	request.setAttribute("msg3", "HELLO WORLD3");
	request.setAttribute("msg4", "HELLO WORLD4");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<script>
		const m1 = '<%=msg1 %>';	//스크립틀릿
		const m2 = '<%=msg2 %>';	//스크립틀릿
		
		const m3 = '${msg3}';		//EL(Expression Language)
		const m4 = '${msg4}';		//EL	백엔드에서 작업한 결과물을 프론트엔드로 보내기 위한 언어, 스크립틀릿보다 편의성이 좋음
		
		console.log('m1',m1);
		console.log('m2',m2);
		console.log('m3',m3);
		console.log('m4',m4);
	</script>

</body>
</html>