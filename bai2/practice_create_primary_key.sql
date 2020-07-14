CREATE DATABASE create_primary_key;
USE create_primary_key;

-- create primary key at the begin 
CREATE TABLE users(
	user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(40),
    password VARCHAR(255),
    email VARCHAR(255)
);

-- create primary key at the end of statement 
CREATE TABLE roles(
	role_id INT AUTO_INCREMENT,
    role_name VARCHAR(50),
    PRIMARY KEY(role_id)
    );
    
-- create composite primary key (khóa chính tổ hợp)
CREATE TABLE userroles (
    user_id INT NOT NULL,
    role_id INT NOT NULL,
    PRIMARY KEY (user_id , role_id),
    FOREIGN KEY (user_id)
        REFERENCES users (user_id),
    FOREIGN KEY (role_id)
        REFERENCES roles (role_id)
);

-- create primary key when you changed the table// tạo khóa chính khi thay đổi bảng
CREATE TABLE table1(
column1 VARCHAR(30),
column2 VARCHAR(40)
);

-- vừa add cột vừa set cột đó là primary key

ALTER TABLE table1
ADD COLUMN id INT NOT NULL,
ADD PRIMARY KEY(id);