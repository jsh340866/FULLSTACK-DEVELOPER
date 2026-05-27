<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String cookieName = request.getParameter("name");
	if(cookieName!=null) {
		Cookie cookie = new Cookie(cookieName,null);	//빈 Value 쿠키생성
		cookie.setMaxAge(0);	// 쿠키 유지시간 0초(바로만료처리)
		cookie.setPath("/");	// 쿠키 적용 URI설정(/ : 현재 도메인(http://localhost:8080)의 모든 영역)
		response.addCookie(cookie);	// Response 응답에 해당 쿠키 재적용
		
	}

%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<script>
		alert("쿠키가 삭제되었습니다.");
		location.href='./getCookie.jsp';
	</script>
	
</body>
</html>