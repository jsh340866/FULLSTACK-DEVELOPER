<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    
<%
	/*  
		request 내장객체 : 요청정보값 저장(Http Request Protocol의 구조형태)
		HttpServletRequest 클래스로 생성된 객체
		
	*/
	/* 문자셋 설정 */
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html; charset=UTF-8");
	//
%>

<!-- 01 파라미터 받기  -->
<jsp:useBean id="dto" class="Ch04.UserDTO" scope="request" />
<jsp:setProperty name="dto" property="*" />

<%
	System.out.println("DTO : " + dto);
%>

<!-- 02 유효성 검증(생략) -->

<!-- 03 서비스 실행 ! -->

<jsp:useBean id="dao" class="Ch04.UserDAO" scope="request" />
<%	
	 System.out.println("UserDAO" + dao);
	 dao.insert(dto);
%>

<!-- 04 결과확인 - 리다이렉트(./03Login.jsp) -->
<%
	response.sendRedirect(request.getContextPath() + "/Ch04/login_form.jsp");


	
%>
 