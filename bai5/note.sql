create database note;
use note;
create table note_type(
id Int primary key auto_increment,
`name` varchar(100),
description varchar(200)
);

create table note(
id Int primary key auto_increment,
title varchar(100),
content varchar(500),
type_id int,
foreign key (type_id) references note_type(id) on delete cascade
);

insert into note_type(`name`,description)
values ("Công ty","Công việc ở công ty");

select n.id,title,name 
from note n
join note_type nt on n.type_id=nt.id;
delete from note where id=1;