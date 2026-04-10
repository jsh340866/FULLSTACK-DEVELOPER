use shopdb;

-- [참고] https://hongong.hanbit.co.kr/sql-%EA%B8%B0%EB%B3%B8-%EB%AC%B8%EB%B2%95-joininner-outer-cross-self-join/

-- --------------------
-- JOIN
-- --------------------
-- 두 개 이상의 테이블을 연결하여 하나의 결과셋으로 출력

-- --------------------
-- JOIN 종류
-- --------------------
-- INNER JOIN: ON 조건에 맞는 데이터만 조인
-- OUTER JOIN:
--   LEFT OUTER JOIN: 왼쪽 테이블 전체 + 오른쪽 조건 일치 행
--   RIGHT OUTER JOIN: 오른쪽 테이블 전체 + 왼쪽 조건 일치 행
--   FULL OUTER JOIN: 양쪽 테이블 전체 (MySQL은 직접 지원하지 않음 → UNION으로 구현)
-- CROSS JOIN: 모든 행끼리 조인 (조건 없음)
-- SELF JOIN: 자기 자신 테이블을 조인

-- --------------------
-- INNER JOIN 실습
-- --------------------
use shopdb;
select * from usertbl;
desc usertbl;
select * from buytbl;
desc buytbl;

-- INNER JOIN 구매한 고객에대한 모든 정보(전체컬럼)
select * 
from usertbl 
inner join buytbl 
on usertbl.userid = buytbl.userid;

-- INNER JOIN 원하는 컬럼만 출력
select usertbl.userid,name,addr,mobile1,mobile2,prodname,price,amount
from usertbl 
inner join buytbl 
on usertbl.userid = buytbl.userid;

-- INNER JOIN 별칭지정(U,B)
select U.userid,name,addr,mobile1,mobile2,prodname,price,amount
from usertbl U
inner join buytbl B
on U.userid = B.userid;

-- INNER JOIN + WHERE
select U.userid,name,addr,mobile1,mobile2,prodname,price,amount
from usertbl U
inner join buytbl B
on U.userid = B.userid
where amount >= 3;

-- 문제
-- 1 바비킴의 userID,birthYear,prodName,GroupName을 출력하세요
select buytbl.userid,birthYear,prodName,groupName 
from buytbl
inner join usertbl
on usertbl.userid = buytbl.userid
where name='바비킴';

select * from usertbl;
select * from buytbl;
-- 2 amount*price 의 값이 100 이상인 행의 name,addr,prodname,mobile1- mobile2를(Concat()함수사용)
-- 출력하세요
select usertbl.name,addr,prodname,concat(mobile1,'-',mobile2) as 'mobile1- mobile2'
from usertbl
inner join buytbl
on usertbl.userid = buytbl.userid
where amount*price >= 100;
-- 3 groupname이 전자인 행의 userid,name,birthyear prodname을 출력하세요
select usertbl.userid,name,birthyear,prodname
from usertbl
inner join buytbl
on usertbl.userid = buytbl.userid
where groupname = '전자';



-- --------------------
-- OUTER JOIN 실습
-- --------------------
-- LEFT OUTER JOIN(on 조건절을 만족하지 않는 left테이블의 행도 출력)
select * 
from usertbl U -- LEFT
left outer join buytbl B -- RIGHT // 빈값도 표시
on U.userid = B.userid;

-- RIGHT OUTER JOIN(on 조건절을 만족하지 않는 right 테이블의 행도 출력)
select * 
from buytbl B -- LEFT
right outer join usertbl U -- RIGHT
on U.userid = B.userid;

-- FULL OUTER JOIN(on 조건절을 만족하지 않는 left,right 테이블의 행도 출력)
-- mysql에서는 full outer join 을 지원하지 않는다
-- 대신 union 을 사용해서 left, right outer join을 연결(union 테이블 붙이기)

select * from usertbl U left outer join buytbl B on U.userid = B.userid
union
select * from buytbl B right outer join usertbl U on U.userid = B.userid;

use employees;
desc employees;
desc salaries;
desc dept_emp;
desc departments;

select E.emp_no,concat(first_name,' ',last_name),salary,hire_date,S.from_date,S.to_date,D.dept_no,dept_name
from salaries S	-- LEFT
inner join employees E  -- RIGHT
on E.emp_no = S.emp_no
inner join dept_emp DE
on E.emp_no = DE.emp_no
inner join departments D
on DE.dept_no = D.dept_no;


use world;

-- countrycode를 만족하는 city's name,country's name,region,population,capital,language를 출력하세요

desc country;
desc city;
desc countrylanguage;

select distinct country.name as 'countryname',city.name,region,country.population,capital,language
from country
inner join city
on city.countrycode = country.code
inner join countrylanguage
on country.code = countrylanguage.countrycode
order by country.name asc, city.name asc;




























