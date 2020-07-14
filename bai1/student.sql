create database codegyme_management;
use codegyme_management;
create table student(
id int,
name varchar(50),
date_of_birth date
);
alter table student
modify id int primary key auto_increment;
insert into student(name, date_of_birth)
values
('Thinh', '2020-07-13'),
('Huy', '2020-06-12');

select name
from student;

update student
set name = 'Huy'
where id=3;
update student
set name = 'Thinh'
where id=4;

delete from student
where id =6;

delete from student

truncate table student;

drop table student;
​
drop database codegym_management;
