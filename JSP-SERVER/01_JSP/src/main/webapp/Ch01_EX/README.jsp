<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ch01_EX - JSP 기초 (선언문/표현식/스크립틀릿)</title>
<style>
	body{font-family:'맑은 고딕';max-width:900px;margin:30px auto;line-height:1.6}
	h1{border-bottom:3px solid #333;padding-bottom:10px}
	h2{background:#eee;padding:8px 12px;border-left:5px solid #4a90e2}
	pre{background:#272822;color:#f8f8f2;padding:12px;border-radius:5px;overflow:auto}
	.hint{background:#fffae6;border-left:5px solid #f5a623;padding:8px 12px;margin:8px 0}
	.tag{display:inline-block;background:#4a90e2;color:#fff;padding:2px 8px;border-radius:3px;font-size:.8rem}
</style>
</head>
<body>

<h1>[Ch01_EX] JSP 기초 문법 연습문제</h1>
<p>학습 주제 : <span class="tag">선언문 &lt;%! %&gt;</span> <span class="tag">표현식 &lt;%= %&gt;</span> <span class="tag">스크립틀릿 &lt;% %&gt;</span></p>

<h2>EX01. 선언문으로 두 수의 합/차/곱/나눗셈 함수 만들기</h2>
<ul>
	<li>선언문(&lt;%! %&gt;) 영역에 <code>add, sub, mul, div</code> 4개 메서드를 정의하세요.</li>
	<li>두 정수를 매개변수로 받아 결과를 반환합니다.</li>
	<li>표현식으로 화면에 결과를 출력하세요. (예 : <code>10 + 5 = 15</code>)</li>
</ul>
<a href="./EX01_calc.jsp">▶ EX01 풀기</a>

<h2>EX02. 스크립틀릿으로 1~100 사이 짝수의 합 구하기</h2>
<ul>
	<li>스크립틀릿(&lt;% %&gt;) 영역에 for문을 사용하세요.</li>
	<li>짝수만 누적합산하여 변수에 저장합니다.</li>
	<li>표현식으로 결과를 화면에 출력하세요.</li>
</ul>
<a href="./EX02_evenSum.jsp">▶ EX02 풀기</a>

<h2>EX03. 입력한 단의 구구단을 HTML 테이블로 출력</h2>
<ul>
	<li>Scanner로 단 수(2~9)를 콘솔에서 입력받으세요.</li>
	<li>입력값이 2~9 범위를 벗어나면 "잘못된 단 입력!" 메시지를 출력하세요.</li>
	<li>스크립틀릿 + 표현식 + table 태그를 조합해 출력합니다.</li>
</ul>
<a href="./EX03_gugudan.jsp">▶ EX03 풀기</a>

<h2>EX04. 별찍기 (스크립틀릿 응용)</h2>
<ul>
	<li>1~5단 별찍기 직각삼각형 출력 (★)</li>
	<li>이중 for문을 사용</li>
</ul>
<a href="./EX04_star.jsp">▶ EX04 풀기</a>

<div class="hint">
	<b>HINT</b><br>
	- 선언문 : 서블릿 클래스 멤버영역(인스턴스 변수/메서드)<br>
	- 표현식 : <code>out.print()</code> 로 변환됨<br>
	- 스크립틀릿 : <code>_jspService()</code> 메서드 안 지역영역
</div>

</body>
</html>
