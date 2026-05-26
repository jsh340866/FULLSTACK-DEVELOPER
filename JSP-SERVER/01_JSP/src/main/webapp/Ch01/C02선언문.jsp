<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%! /* ! 붙어있으면 선언문 */
		int n = 0;
		public int countUp() {
			n++;
			return n;
		}
	%>
	
	N : <%= countUp() %>
	
	
	
</body>
</html>