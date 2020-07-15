create database bank;

use bank;

create table customers (
customer_number int primary key not null,
fullname varchar(50) not null,
address text,
email varchar(100) unique not null,
phone int unique not null
);

create table accounts (
account_number  int primary key not null,
account_type varchar(10) not null,
date_open date not null,
balance  int,
customer_number int,
 FOREIGN KEY (customer_number) REFERENCES customers(customer_number)
);

create table transactions (
tran_number  int primary key not null,
date_tran date not null,
amounts double not null,
descriptions text,
account_number int,
FOREIGN KEY (account_number) REFERENCES accounts(account_number)
);

