<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.*"%>
<!-- @ = 지시자 -->

<%
/* java.util.Scanner sc = new java.util.Scanner(System.in); */
Scanner sc = new Scanner(System.in);
System.out.println("행 열 입력 : ");
int row = sc.nextInt();
int col = sc.nextInt();
System.out.println("행 : " + row + " 열 : " + col);
sc.close();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
td {
	width: 50px;
	height: 50px;
	border: 1px solid gray;
}
</style>
</head>
<body>
	<!-- 서비스함수 -->
	<table>
	<%
	for (int i = 0; i < row; i++) {
	%>
	<tr>
		<%
		for (int j = 0; j < col; j++) {
		%>
		<td><%=i%>|<%=j%></td>
		<%
		}
		%>
	</tr>
	<%
	}
	%>	
	</table>

</body>
</html>