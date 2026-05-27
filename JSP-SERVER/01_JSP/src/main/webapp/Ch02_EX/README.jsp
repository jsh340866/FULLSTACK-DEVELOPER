<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ch02_EX - Request 처리</title>
<style>
	body{font-family:'맑은 고딕';max-width:900px;margin:30px auto;line-height:1.6}
	h1{border-bottom:3px solid #333;padding-bottom:10px}
	h2{background:#eee;padding:8px 12px;border-left:5px solid #4a90e2}
	.tag{display:inline-block;background:#4a90e2;color:#fff;padding:2px 8px;border-radius:3px;font-size:.8rem}
	.hint{background:#fffae6;border-left:5px solid #f5a623;padding:8px 12px;margin:8px 0}
</style>
</head>
<body>
<h1>[Ch02_EX] Request 객체 / Form 데이터 처리</h1>
<p><span class="tag">GET/POST</span> <span class="tag">getParameter</span> <span class="tag">한글처리</span> <span class="tag">useBean</span> <span class="tag">setProperty</span></p>

<h2>EX01. GET 방식 - 영화관 예매 폼</h2>
<ul>
	<li>HTML 폼 : 영화제목(title), 좌석번호(seat), 인원수(num)</li>
	<li>Process JSP : 파라미터를 받아 "OOO 영화 N석 K명 예매완료" 출력</li>
	<li>인원수 × 12000원 = 총결제금액 출력</li>
</ul>
<a href="./EX01_movie_form.html">▶ EX01 풀기</a>

<h2>EX02. POST 방식 - 한글 데이터 처리</h2>
<ul>
	<li>한글 이름/소개글을 POST로 전송</li>
	<li>Process JSP에서 <code>request.setCharacterEncoding("UTF-8")</code> 필수</li>
	<li>한글이 깨지지 않게 출력</li>
</ul>
<a href="./EX02_intro_form.html">▶ EX02 풀기</a>

<h2>EX03. 체크박스 / 라디오 / 셀렉트 - 설문조사</h2>
<ul>
	<li>라디오 : 성별 (남/여)</li>
	<li>체크박스(다중) : 관심분야 (운동/음악/독서/게임)</li>
	<li>셀렉트 : 연령대 (10대/20대/30대)</li>
	<li>Process JSP에서 <code>request.getParameterValues()</code>로 체크박스 다중처리</li>
</ul>
<a href="./EX03_survey_form.html">▶ EX03 풀기</a>

<h2>EX04. useBean / setProperty 액션태그로 DTO 자동매핑</h2>
<ul>
	<li>BookDto (title, author, price, publisher) 클래스 생성</li>
	<li>액션태그로 폼 파라미터를 한 번에 DTO 에 매핑</li>
	<li>화면에 DTO 내용 출력</li>
</ul>
<a href="./EX04_book_form.html">▶ EX04 풀기</a>

<div class="hint">
	<b>HINT</b><br>
	- GET : URL queryString 노출 / 길이제한 / 한글 자동디코딩(WAS설정에 따름)<br>
	- POST : Body 전송 / 한글 setCharacterEncoding 필수<br>
	- 체크박스 여러개 : <code>getParameterValues(name)</code> → String[]<br>
	- useBean + setProperty="*" : 폼 name과 DTO 필드명이 일치하면 자동주입
</div>

</body>
</html>
