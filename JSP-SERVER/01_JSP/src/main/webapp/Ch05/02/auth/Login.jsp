<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<!-- 
01 파라미터 받기 //★ TODO ★

1) AuthDTO 생성(src/main/java/Ch04/AuthDTO)
- userid , password 받기
- jsp:useBean 이용해서 Bean 생성
- jsp:setProperty 로 입력 파라미터 Bean 주입
-->    
<jsp:useBean id="authDTO" class="Ch04.AuthDTO" scope="request" />
<jsp:setProperty name="authDTO" property="*" />

<!-- 
02 유효성 검증  //★ TODO ★
1) userid 일치여부 확인(DB내용 - 입력파라미터 내용)
- 일치하면 2) 진행
- 불일치하면 리다이렉트 /01_JSP/Ch04/login_form.jsp 
2) password 일치여부 확인(DB내용 - 입력파라미터 내용)
- 일치하면 03 서비스 실행 진행
- 불일치하면 리다렉트 /01_JSP/Ch04/login_form.jsp 
-->
<jsp:useBean id="dao" class="Ch04.UserDAO" scope="request" />
<%@ page import="Ch04.UserDTO" %>
<%
	UserDTO userDTO = dao.select(authDTO.getUserid());
	if(userDTO==null){
		response.sendRedirect(request.getContextPath() + "/Ch05/02/login_form.jsp");
		session.setAttribute("isAuth", false);
		session.setAttribute("message", "⚠ 동일한 ID가 없습니다.");
		//메시지
		return ;
	}
	if(!authDTO.getPassword().equals(userDTO.getPassword())){
		response.sendRedirect(request.getContextPath() + "/Ch05/02/login_form.jsp");
		session.setAttribute("isAuth", false);
		session.setAttribute("message", "⚠ PW가 일치하지 않습니다.");
		return ;
	}
	
%>

<!-- 
03 서비스 실행(인가처리)
-->
<%@ page import="Ch05.ROLE" %>
<%
	session.setMaxInactiveInterval(60);
	session.setAttribute("isAuth", true);
	if(authDTO.getUserid().equals("admin")){
		session.setAttribute("role", ROLE.ROLE_ADMIN);	//2
	}else{
		session.setAttribute("role", ROLE.ROLE_USER);	//0
	}

%>

<!-- 
04 뷰로 이동 
-->
<%
	response.sendRedirect(request.getContextPath() + "/Ch05/02/main.jsp");
	session.setAttribute("isAuth", true);	
	session.setAttribute("message", "✔ 로그인 완료!");
%>



