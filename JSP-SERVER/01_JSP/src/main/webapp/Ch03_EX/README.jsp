<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ch03_EX - Forward / Redirect</title>
<style>
	body{font-family:'맑은 고딕';max-width:900px;margin:30px auto;line-height:1.6}
	h1{border-bottom:3px solid #333;padding-bottom:10px}
	h2{background:#eee;padding:8px 12px;border-left:5px solid #4a90e2}
	.tag{display:inline-block;background:#4a90e2;color:#fff;padding:2px 8px;border-radius:3px;font-size:.8rem}
	.hint{background:#fffae6;border-left:5px solid #f5a623;padding:8px 12px;margin:8px 0}
	table{border-collapse:collapse}th,td{border:1px solid #999;padding:6px 10px}
</style>
</head>
<body>
<h1>[Ch03_EX] 페이지 이동 - Forward vs Redirect</h1>
<p><span class="tag">RequestDispatcher</span> <span class="tag">sendRedirect</span> <span class="tag">setAttribute</span></p>

<table>
	<tr><th></th><th>Forward</th><th>Redirect</th></tr>
	<tr><td>URL 변경</td><td>안됨(최초URL 유지)</td><td>변경됨</td></tr>
	<tr><td>Request 객체</td><td>유지</td><td>새 객체로 생성</td></tr>
	<tr><td>요청-응답 횟수</td><td>1회</td><td>2회</td></tr>
	<tr><td>파라미터 전달</td><td>setAttribute</td><td>queryString or session</td></tr>
</table>

<h2>EX01. Forward 체인 - 3단계 이동</h2>
<ul>
	<li>입력폼 → step1.jsp → step2.jsp → step3.jsp 로 forward</li>
	<li>각 step에서 request.setAttribute("stepN", value) 누적</li>
	<li>마지막 step3.jsp 에서 step1, step2, step3 값을 모두 출력</li>
</ul>
<a href="./EX01_forward_form.html">▶ EX01 풀기</a>

<h2>EX02. Redirect - 회원가입 후 로그인 페이지 이동</h2>
<ul>
	<li>회원가입 폼 → joinProcess.jsp(검증 성공시 redirect)</li>
	<li>redirect로 login.jsp 이동 (URL이 변경됨을 확인)</li>
	<li>queryString으로 가입한 userid 를 전달 → login 페이지에 자동입력</li>
</ul>
<a href="./EX02_redirect_join.html">▶ EX02 풀기</a>

<h2>EX03. Forward + 유효성 검사 (실패시 폼 복귀)</h2>
<ul>
	<li>나이 입력 폼 → 처리 페이지</li>
	<li>나이가 0 이하 또는 150 이상이면 폼으로 forward + 에러메시지 attribute</li>
	<li>유효하면 결과 페이지로 forward</li>
</ul>
<a href="./EX03_age_form.jsp">▶ EX03 풀기</a>

<div class="hint">
	<b>HINT</b><br>
	- Forward : <code>request.getRequestDispatcher("./xxx.jsp").forward(request, response);</code><br>
	- Redirect : <code>response.sendRedirect("./xxx.jsp?key=value");</code><br>
	- Forward 후 더이상 코드 실행을 막으려면 <code>return;</code>
</div>
</body>
</html>
