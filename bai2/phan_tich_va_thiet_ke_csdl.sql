create database store;
use store;

CREATE TABLE customers (
    id INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL,
    last_name VARCHAR(50),
    first_name VARCHAR(50),
    phone VARCHAR(20) NOT NULL,
    address_line1 VARCHAR(50) NOT NULL,
    address_line2 VARCHAR(50),
    city VARCHAR(30) NOT NULL,
    state VARCHAR(30) NOT NULL,
    postal_code VARCHAR(30) NOT NULL,
    country VARCHAR(30) NOT NULL,
    credit_limit FLOAT
);

CREATE TABLE orders (
    id INT PRIMARY KEY AUTO_INCREMENT,
    order_date DATE NOT NULL,
    require_date DATE NOT NULL,
    shipped_date DATE,
    `status` VARCHAR(20),
    `comment` TEXT,
    quantity_ordered INT NOT NULL,
    price_each FLOAT NOT NULL,
    customer_id int,
    foreign key (customer_id) references customers(id)
);

CREATE TABLE office (
    id varchar(10) PRIMARY KEY,
    city VARCHAR(50) NOT NULL,
    phone VARCHAR(50) NOT NULL,
    address_line1 VARCHAR(100) NOT NULL,
    address_line2 VARCHAR(100) ,
    state VARCHAR(50),
    country VARCHAR(50) NOT NULL,
    postal_code VARCHAR(10) NOT NULL
);


CREATE TABLE employees (
    id INT PRIMARY KEY AUTO_INCREMENT,
    last_name VARCHAR(50) NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    job_title VARCHAR(50) NOT NULL,
    report_to int,
    office_id varchar(10),
    foreign key (report_to) references employees(id),
    foreign key (office_id) references office(id)
);

create table payments(
id int primary key auto_increment,
check_number varchar(50) not null,
payment_date date not null,
amount float not null,
customer_id int,
employee_id int,
foreign key (customer_id) references customers(id),
foreign key (employee_id) references employees(id)
);

CREATE TABLE product_lines (
    id varchar(50) PRIMARY KEY,
    text_description text NOT NULL,
    image text NOT NULL
);

CREATE TABLE products (
    id varchar(50) PRIMARY KEY ,
    product_name VARCHAR(70) NOT NULL,
    product_scale VARCHAR(10) NOT NULL,
    product_vendor VARCHAR(50) NOT NULL,
    product_description TEXT NOT NULL,
    quanity_stock VARCHAR(70) NOT NULL,
    buy_price INT NOT NULL,
    MSRP FLOAT NOT NULL,
    product_line_id varchar(50),
    customer_id int,
    foreign key (customer_id) references customers(id)
);

create table order_details(
id int primary key auto_increment,
product_id varchar(50),
order_id int,
foreign key (product_id) references products(id),
foreign key (order_id) references orders(id)
);




