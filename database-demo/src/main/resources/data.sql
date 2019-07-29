create table person 
(
	id integer not null,
	name varchar(255) not null,
	location varchar(255),
	birth_date timestamp,
	primary key(id)
);


insert into person(ID,NAME,LOCATION,BIRTH_DATE)
values(10001,'Suhas','Mangalore',sysdate());

insert into person(ID,NAME,LOCATION,BIRTH_DATE)
values(10002,'Sushanth','Bangalore',sysdate());

insert into person(ID,NAME,LOCATION,BIRTH_DATE)
values(10003,'Poorna','Udupi',sysdate());

insert into person(ID,NAME,LOCATION,BIRTH_DATE)
values(10004,'Kittu','Udupi',sysdate());