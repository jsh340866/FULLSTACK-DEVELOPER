<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!--
	[EX01-step1] name 파라미터 받기 + setAttribute("step1", "step1처리완료")
	→ forward → EX01_step2.jsp
-->
<%
	String name = request.getParameter("name");
	// TODO: setAttribute, forward
%>
