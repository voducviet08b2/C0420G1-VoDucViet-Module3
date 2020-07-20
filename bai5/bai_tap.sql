create database demo;
use demo;
create table Product(
id int primary key auto_increment,
product_code varchar(50),
product_name varchar(50),
product_price int,
product_amount int,
product_description varchar(50),
product_status varchar(50)
);
INSERT INTO `demo`.`product` (`product_code`, `product_name`, `product_price`, `product_amount`, `product_description`, `product_status`) 
VALUES 
('JAV', 'cooking', '40000', '3', 'Xin so', 'On'),
('HIV', 'medicine', '70000', '8', 'ngon lanh', 'On'),
('KOI', 'pone', '20000', '2', 'ngon', 'On'),
('KLP', 'machine', '20000', '2', 'ngon lanh', 'On'),
('POO', 'machine', '20000', '2', 'ngon lanh', 'On');

CREATE UNIQUE INDEX idx_product_code
ON Product (product_code);

CREATE INDEX idx_composite
ON  Product (product_name, product_price);

explain select * from Product
where product_code="HIV";

explain select * from Product
where product_name="machine";

create view product_view
as
select product_code, product_name, product_price, product_status 
from product;

select * from product_view;

update product_view
set product_name="fuck"
Where product_code="HIV";

select * from product_view;

drop view product_view;

delimiter //
create procedure showAll ()
begin
	select *
    from Product;
END; //
delimiter ;

call showAll();

delimiter //
create procedure insertAll (v_code varchar(50),v_name varchar(50), v_price varchar(50),v_amount varchar(50),v_des varchar(50),v_status varchar(50))
begin
	insert into Product(product_code,product_name,product_price,product_amount,product_description,product_status)
    values
    (v_code,v_name,v_price,v_amount,v_des,v_status);
END; //
delimiter ;

call insertAll("KOP","mommy",200000,6,"ngu si","Off");

delimiter //
create procedure updateAll (v_code varchar(50),ten_truong varchar(50),gia_tri varchar(50))
begin

	update Product
    set ten_truong=gia_tri
	where product_code=v_code;
END; //
delimiter ;

drop procedure updateAll;

call updateAll("KOP",product_name,"DMM");

delimiter //
create procedure deleteAll (v_id int)
begin

	delete from Product
	where id=v_id;
END; //
delimiter ;

call deleteAll(1);

show create table product;
