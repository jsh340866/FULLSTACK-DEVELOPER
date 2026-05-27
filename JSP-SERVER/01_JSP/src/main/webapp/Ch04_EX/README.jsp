<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ch04_EX - DB 연동 (JDBC)</title>
<style>
	body{font-family:'맑은 고딕';max-width:900px;margin:30px auto;line-height:1.6}
	h1{border-bottom:3px solid #333;padding-bottom:10px}
	h2{background:#eee;padding:8px 12px;border-left:5px solid #4a90e2}
	.tag{display:inline-block;background:#4a90e2;color:#fff;padding:2px 8px;border-radius:3px;font-size:.8rem}
	.hint{background:#fffae6;border-left:5px solid #f5a623;padding:8px 12px;margin:8px 0}
	pre{background:#272822;color:#f8f8f2;padding:12px;border-radius:5px}
</style>
</head>
<body>
<h1>[Ch04_EX] DB 연동 - JDBC + MySQL</h1>
<p><span class="tag">JDBC Driver</span> <span class="tag">PreparedStatement</span> <span class="tag">ResultSet</span> <span class="tag">Transaction</span></p>

<h2>사전 준비 - 테이블 생성 (MySQL)</h2>
<pre>
CREATE TABLE tbl_book (
	bno      INT AUTO_INCREMENT PRIMARY KEY,
	title    VARCHAR(100) NOT NULL,
	author   VARCHAR(50),
	price    INT,
	regdate  DATETIME DEFAULT CURRENT_TIMESTAMP
);
</pre>

<h2>EX01. tbl_book 전체 조회 (SELECT)</h2>
<ul>
	<li>BookDto (bno, title, author, price, regdate) 생성</li>
	<li>DbUtils.conn() / disConn() / selectAll() 작성</li>
	<li>JSP에서 List&lt;BookDto&gt; 받아 테이블 출력</li>
</ul>
<a href="./EX01_list.jsp">▶ EX01 풀기</a>

<h2>EX02. 신규 도서 등록 (INSERT)</h2>
<ul>
	<li>등록 폼 + Process JSP</li>
	<li>PreparedStatement 사용 (SQL Injection 방지)</li>
	<li>등록 성공시 EX01_list.jsp 로 redirect</li>
</ul>
<a href="./EX02_insert_form.html">▶ EX02 풀기</a>

<h2>EX03. 도서 검색 (LIKE 검색)</h2>
<ul>
	<li>검색 폼 (title 으로 LIKE 검색)</li>
	<li>WHERE title LIKE ? → setString(1, "%"+keyword+"%")</li>
</ul>
<a href="./EX03_search_form.html">▶ EX03 풀기</a>

<h2>EX04. 트랜잭션 - 2건 동시 INSERT (둘 다 성공해야 commit)</h2>
<ul>
	<li>두 권의 책을 한 번에 등록</li>
	<li>두번째 INSERT에서 강제로 예외 발생시 첫번째도 rollback 확인</li>
	<li>conn.setAutoCommit(false), commit(), rollback() 사용</li>
</ul>
<a href="./EX04_tx_test.jsp">▶ EX04 풀기</a>

<div class="hint">
	<b>HINT</b><br>
	- Driver : <code>Class.forName("com.mysql.cj.jdbc.Driver")</code><br>
	- URL : <code>jdbc:mysql://localhost:3306/DBNAME</code><br>
	- close 순서 : rs → pstmt → conn<br>
	- 트랜잭션 : try → setAutoCommit(false) → ... → commit() / catch → rollback()
</div>
</body>
</html>
