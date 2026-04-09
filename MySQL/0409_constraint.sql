use shopdb;
-- -----------------------------------
-- PK 제약조건
-- -----------------------------------
-- 01 테이블 생성시 PK 제약조건 포함
create table tbl_a(
	id varchar(45) primary key,
    name varchar(45) not null
); 
-- desc tbl_a;
-- select table_name,column_name,data_type,column_key from information_schema.columns where table_schema='shopdb' and table_name='tbl_a';

create table tbl_b(
	id varchar(45),
    name varchar(45) not null,
     primary key(id)
); 
desc tbl_b;

create table tbl_c(
	id varchar(45),
    name varchar(45) not null,
     primary key(id,name)
);
desc tbl_c;


-- 02 기존 테이블에 PK 제약조건 추가 (constraint)
create table tbl_d(
	id varchar(45),
    name varchar(45) not null
);
desc tbl_d;
alter table tbl_d add constraint PK_tbl_d primary key(id);

-- 03 PK 제약조건 제거
alter table tbl_d drop primary key;
desc tbl_d;

-- 문제
-- buytbl을 C_buytbl로 구조+데이터 복사하고 num를 primary key로 설정 해보세요.
create table C_buytbl(select * from buytbl);
select * from C_buytbl;
alter table C_buytbl add constraint PK_c_buytbl primary key(num);
desc C_buytbl;

-- -----------------------------------
-- FK 제약조건
-- -----------------------------------
-- 테이블 생성시 FK 설정
create table tbl_test1(
	no int primary key,
    id varchar(45) not null,
    constraint FK_tbl_test1_tbl_a foreign key(id) references tbl_a(id)
);
desc tbl_test1;

-- FK OPTION 정리
-- CASCADE 	: PK 열의 값 on Update , on Delete 이 변경시 FK 열의 값도 함께 변경
-- No Action 	: PK 열의 값이 변경시 FK 열의 값은 변경 X
-- RESTRICT		: PK, FK 열의 값의 변경 차단
-- Set null 	: PK 열의 값이 변경시 FK 열의 값을 NULL로 설정 
-- Set Dafault 	: PK 열의 값이 변경시 FK 열의 값은 Default 로 설정된 기본값을 적용

create table tbl_test2(
	no int primary key,
    id varchar(45) not null,
    constraint FK_tbl_test2_tbl_a foreign key(id) references tbl_a(id)
);

-- 기존 테이블에서 FK 추가

-- FK 제거






