use shopdb;
show tables;
desc usertbl;
desc buytbl;
select * from usertbl;
select * from buytbl;

-- 01 SELECT
select userid,birthYear from usertbl;
select userid as '아이디' , birthYear as '생년월일' from usertbl;
select userid as '아이디' , birthYear as '생년월일', concat(mobile1,'-',mobile2) as '연락처' from usertbl;

-- 02 SELECT - WHERE(조건절 - 비교연산자)
select * from usertbl where name='김경호'; -- 동등비교연산자(=)
select * from usertbl where userId='LSG'; -- 동등비교연산자(=)
select * from usertbl where birthYear >= 1970; -- 대소비교연산자
select * from usertbl where height <= 170; -- 대소비교연산자

-- 03 SELECT - WHERE(조건절- 논리연산자)
-- and 연산자
select * from usertbl where birthyear >= 1970 and height >= 180;
-- or 연산자
select * from usertbl where birthyear >= 1970 or height >= 180;
-- between and 
select * from usertbl where height >= 170 and height <= 180;
select * from usertbl where height between 170 and 180;
-- in(포함문자열), like(포함문자열)
select * from usertbl where addr='서울' or addr='경기';
select * from usertbl where addr in ('서울', '경기');
select * from usertbl where addr like ('서울', '경기');

select * from usertbl where name like'김%'; -- 첫글자가 '김'인 경우
select * from usertbl where name like '%수'; -- 끝글자가 '수'인 경우
select * from usertbl where name like '%경%'; -- 글자에 '경'이 포함된 경우
select * from usertbl where name like '김__'; -- 글자수가 제한 '_', 김__ = 3글자 제한

select * from buytbl;

-- 1 구매양(amount)가 5개 이상인 행을 출력
select * from buytbl where amount >= 5;
-- 2 가격이(price) 50 이상 500 이하인 행의 UserId와 prodName만 출력
select userid,prodName from buytbl where price >= 50 and price <= 500;
select userid,prodName from buytbl where price between 50 and 500;
-- 3 구매양(amount)이 10 이상 이거나 가격이 100 이상인 행 출력
select * from buytbl where amount >= 10 or price <= 100;
-- 4 UserId 가 K로 시작하는 행 출력
select * from buytbl where userid like 'K%';
-- 5 '서적' 이거나 '전자' 인 행 출력
select * from buytbl where groupName='서적' or groupName='전자';
select * from buytbl where groupName in('전자','서적');
-- 6 상품(prodName)이 책이거나 userID가 W로 끝나는 행 출략
select * from buytbl where prodName in('책') or userid like '%W';
-- 7 groupname이 비어있지 않는 행만 출력 (!=, <>)
select * from buytbl where groupName like '_%';
select * from buytbl where groupName!='';
select * from buytbl where groupName<>'';
select * from buytbl where groupName is not null;








