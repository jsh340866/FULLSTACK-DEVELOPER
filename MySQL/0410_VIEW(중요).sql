-- ---------------------------
-- View (https://coding-factory.tistory.com/224)
-- ---------------------------
-- 뷰는 사용자에게 접근이 허용된 자료만을 제한적으로 보여주기 위한
-- 가상 테이블

use shopdb;
select * from usertbl;
select * from buytbl;

create or replace view view_01
as
select userid,name,addr,concat(mobile1,'-',mobile2) as 'phone' from usertbl;

select * from view_01;

-- 확인
show create view view_01;
select * from information_schema.views where table_schema='shopdb';
desc view_01;


create or replace view view_02
as
select userid,name,addr,concat(mobile1,'-',mobile2) as 'phone' 
from usertbl 
where addr in ('서울','경기');

select * from view_02;


create or replace view view_03
as
select U.userid,name,addr,concat(mobile1,'-',mobile2) as 'phone',prodname,price,amount
from usertbl U
inner join buytbl B
on U.userid = B.userid;

select * from view_03;
use world;
desc country;
desc city;
desc countrylanguage;

use shopdb;

create or replace view view_04
as
select distinct country.name as 'country',city.name,region,country.population,capital,language
from world.country 
inner join world.city 
on city.countrycode = country.code
inner join world.countrylanguage 
on country.code = countrylanguage.countrycode
order by country.name asc, city.name asc;

select * from view_04;


--

create table tbl_a(
	col1 int  primary key,
    col2 int 
);
create table tbl_b(
	col3 int  primary key,
    col4 int 
);

create or replace view view_a_b
as
select *  
from tbl_a
inner join tbl_b;

