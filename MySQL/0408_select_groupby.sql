use shopdb;

-- 01 SELECT group by
-- userId별 amount 총합(집계함수 : sum))
select userid,sum(amount) as '구매총량' from buytbl group by userid;
-- userId별 amount*price 의 총합(sum)
select userid,sum(amount*price) as '구매총액' from buytbl group by userid;
-- avg 를 이용, truncate((),n) : 소수점 단위
select userid, truncate(avg(amount*price),2) as '구매평균액' from buytbl group by userid;
-- min(), max();
select height from usertbl;
select max(height) from usertbl;
select min(height) from usertbl;

-- 가장 큰 키를 가지는 user 정보 확인
select * from usertbl where height = (select max(height) from usertbl);
-- 가장 작은 키를 가지는 user 정보 확인
select * from usertbl where height = (select min(height) from usertbl);
-- 가장 큰 키와 가장 작은 키의 유저정보를 한번에 출력
select * from usertbl where height = (select max(height) from usertbl) or height = (select min(height) from usertbl);


-- 문제
-- 1 buytbl에서 userid 별로 구매량(amount)의 합을 출력하세요
use shopdb;
select userid,groupname,sum(amount) as '합' from buytbl group by userid,groupname;
-- 2 usertbl에서 키의 평균값을 구하세요
select truncate(avg(height),2) as '키평균' from usertbl;
-- 3 buytbl에서 최대구매량과 최소구매량을 userid와함께 출력하세요
select userID,amount from buytbl where 
amount = (select max(amount) from buytbl) or amount = (select min(amount) from buytbl);
-- 4 buytbl의 groupname의 개수를 출력하세요( count() )
select count(groupname) as 'groupname개수'from buytbl;
-- 5 city 테이블에서 CountryCode 별로 Population의 총합을 구하세요(world DB에서 진행)
use world;
select countrycode,sum(population) from city group by countrycode;
-- 6 country 테이블에서 Continent 별로 LifeExpectancy의 평균을 구하세요(world DB에서 진행)
select continent,truncate(avg(lifeexpectancy),2) as '평균기대수명' from country group by continent;

-- 7 select group by + having
use shopdb;









