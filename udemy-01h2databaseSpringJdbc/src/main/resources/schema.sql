create table person (
	id integer not null,
	name varchar(255),
	address varchar(255),
    dateofbirth timestamp
);

insert into person (id,name,address,dateofbirth) values (1001,'JOHN','Hyderabad',sysdate());
insert into person (id,name,address,dateofbirth) values (1002,'SMITH','California',sysdate());
insert into person (id,name,address,dateofbirth) values (1003,'HUSSY','Australia',sysdate());
insert into person (id,name,address,dateofbirth) values (1004,'POINTING','Australia',sysdate());