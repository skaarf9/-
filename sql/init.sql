drop user wmsdba;

create user wmsdba identified by '333';
grant connect, resource to wmsdba;
alter user wmsdba account unlock;
alter user wmsdba quota unlimited on users;

connect wmsdba/333;

drop table MyOrder;

create table MyOrder(
id number(10) primary key,
dStatus Char(1) not null,
dAddress Varchar(100) not null,
dGoods  number(10) not null,
dNum number(10) not null,
pStatus Char(1) not null,
dTime DATE not null
);
insert into MyOrder values (1101,'N','阳光大道24号',2344,200,'N','24-4月-19');
insert into MyOrder values (1102,'N','阳光大道25号',2344,20,'N','24-4月-20');
insert into MyOrder values (1103,'N','阳光大道26号',2344,30,'N','24-4月-19');
insert into MyOrder values (1104,'N','阳光大道27号',2344,90,'N','24-6月-19');
insert into MyOrder values (1105,'N','阳光大道28号',2344,10,'N','24-4月-19');
insert into MyOrder values (1106,'N','阳光大道29号',2344,1,'N','11-8月-19');
insert into MyOrder values (1107,'N','阳光大道30号',2344,5,'N','24-4月-19');
insert into MyOrder values (1108,'N','阳光大道31号',2344,7,'N','21-4月-18');