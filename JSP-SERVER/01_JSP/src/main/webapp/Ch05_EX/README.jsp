<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ch05_EX - Session</title>
<style>
	body{font-family:'맑은 고딕';max-width:900px;margin:30px auto;line-height:1.6}
	h1{border-bottom:3px solid #333;padding-bottom:10px}
	h2{background:#eee;padding:8px 12px;border-left:5px solid #4a90e2}
	.tag{display:inline-block;background:#4a90e2;color:#fff;padding:2px 8px;border-radius:3px;font-size:.8rem}
	.hint{background:#fffae6;border-left:5px solid #f5a623;padding:8px 12px;margin:8px 0}
</style>
</head>
<body>
<h1>[Ch05_EX] Session 활용</h1>
<p><span class="tag">setAttribute</span> <span class="tag">getAttribute</span> <span class="tag">invalidate</span> <span class="tag">권한제어</span> <span class="tag">setMaxInactiveInterval</span></p>

<h2>EX01. 로그인 / 메인 / 로그아웃 (Session)</h2>
<ul>
	<li>로그인폼 → 처리 (id="admin", pw="1234" 만 통과)</li>
	<li>성공시 session에 isAuth, username 저장 → main.jsp</li>
	<li>main.jsp에서 session null 체크 (없으면 로그인폼으로 redirect)</li>
	<li>로그아웃 : session.invalidate()</li>
</ul>
<a href="./EX01_login_form.jsp">▶ EX01 풀기</a>

<h2>EX02. 권한 분기 (Role 별 메뉴)</h2>
<ul>
	<li>로그인 시 role 을 ROLE_ADMIN / ROLE_USER 중 저장</li>
	<li>main.jsp 에서 role 에 따라 보여주는 메뉴 다르게</li>
	<li>관리자 페이지 admin.jsp 는 ROLE_ADMIN 만 진입가능</li>
</ul>
<a href="./EX02_role_login.jsp">▶ EX02 풀기</a>

<h2>EX03. 세션 타임아웃 (3초 만료 테스트)</h2>
<ul>
	<li>session.setMaxInactiveInterval(3) 사용</li>
	<li>로그인 후 3초 기다렸다가 main 새로고침 → 세션만료 처리</li>
</ul>
<a href="./EX03_timeout_login.jsp">▶ EX03 풀기</a>

<div class="hint">
	<b>HINT</b><br>
	- 세션 저장 : <code>session.setAttribute("key", value)</code><br>
	- 세션 조회 : <code>session.getAttribute("key")</code> → Object (캐스팅 필요)<br>
	- EL : <code>${sessionScope.key}</code> 또는 그냥 <code>${key}</code><br>
	- 종료 : <code>session.invalidate()</code><br>
	- 만료시간(초) : <code>session.setMaxInactiveInterval(초)</code>
</div>
</body>
</html>
