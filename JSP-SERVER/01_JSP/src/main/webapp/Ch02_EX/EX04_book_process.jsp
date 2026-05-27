<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!--
	[EX04] 액션태그로 DTO 자동매핑
	선결작업:
		Ch02_EX/BookDto.java 를 src/main/java/Ch02_EX 패키지에 생성
		필드 : String title, String author, int price, String publisher
		Getter/Setter/toString 작성

	요구사항:
		1) request.setCharacterEncoding("UTF-8")
		2) <jsp:useBean id="dto" class="Ch02_EX.BookDto" scope="request" />
		3) <jsp:setProperty name="dto" property="*" />
		4) 출력
-->
<%
	request.setCharacterEncoding("UTF-8");
%>
<%-- TODO: useBean, setProperty 액션태그 작성 --%>

<!DOCTYPE html>
<html>
<head><meta charset="UTF-8"><title>도서결과</title></head>
<body>
	<h1>도서 등록 결과</h1>
	<%-- TODO: dto 의 toString 출력 --%>
</body>
</html>
