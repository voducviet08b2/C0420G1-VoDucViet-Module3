create database library;
use library;
create table students(
id int primary key auto_increment,
student_name varchar(30) not null,
address varchar(100) not null,
email varchar(50),
image varchar(100)
);

create table categories(
id int primary key auto_increment,
name_category varchar(30) not null
);

create table books(
id int primary key auto_increment,
name_book varchar(100) not null,
`description` text not null,
category_id int,
foreign key (category_id) references categories(id)
);



create table borrowOrder(
id int primary key auto_increment,
 student_id int,
 book_id int,
 foreign key (student_id) references students(id),
 foreign key (book_id) references books(id)
);

insert into students(student_name,address,email,image)
values 
("cao tuan viet","cho troi","tinhyeu@gmail.com","image.com"),
("cao ho cot","hai phòng","thoitietthang5@gmail.com","image.com"),
("ho si lien","long","tinhyeu@gmail.com","image.com"),
("cao tt","cho ","tineu@gmail.com","image.com"),
("can viet"," troi","tiu@gmail.com","image.com")
;

insert into categories(name_category)
values 
("Xã hội"),
("Con người"),
("Giới tính"),
("Kinh tế"),
("Lịch sử")
;

insert into books(name_book,`description`,category_id)
values 
("Đại cương duy tâm", "Sách mác lê nin",1),
("Làm giàu không khó", "Sách hay thế giới",2),
("Học nghề", "Sách english",3),
("JAV đại cương", "Sách japanese ",2),
("Sách tốt", "Sách hay",5)
;

insert into borrowOrder(student_id,book_id)
values 
(2,1),
(2,4),
(2,2),
(5,1),
(2,4)
;
