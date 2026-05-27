<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!--
	[EX03-process]
	요구사항:
		1) age 파싱 (try/catch)
		2) 0 < age < 150 검증 실패시:
			request.setAttribute("errorMsg", "메시지")
			→ forward → EX03_age_form.jsp
		3) 성공시:
			→ forward → EX03_age_result.jsp
-->
<%
	String ageStr = request.getParameter("age");
	int age = -1;
	String errorMsg = null;

	try{
		age = Integer.parseInt(ageStr);
	}catch(Exception e){
		errorMsg = "숫자를 입력하세요";
	}

	// TODO: 범위 검증

	if(errorMsg != null){
		// TODO: errorMsg setAttribute 후 폼으로 forward, return
	}else{
		request.setAttribute("age", age);
		// TODO: 결과 페이지로 forward
	}
%>
