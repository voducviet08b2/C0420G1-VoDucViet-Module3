USE codegyme_management;
CREATE TABLE contacts
(contact_id INT(11) NOT NULL AUTO_INCREMENT,
last_name VARCHAR(30) NOT NULL,
first_name VARCHAR(25),
birthday DATE,
CONSTRAINT contacts_pk PRIMARY KEY(contact_id)
);

USE codegyme_management;
CREATE TABLE suppliers
(suppliers_id INT NOT NULL AUTO_INCREMENT,
supplier_name VARCHAR(50) NOT NULL,
account_rep VARCHAR(30) NOT NULL DEFAULT 'TBD',
CONSTRAINT suppliers_pk PRIMARY KEY(suppliers_id)
);

DROP TABLE student;
DROP TABLE suppliers, contacts;

DROP TABLE contacts;

ALTER TABLE contacts
	ADD middle_namexx VARCHAR(30) NOT NULL
		AFTER last_name;
        
ALTER TABLE suppliers
	ADD supplier_full_name VARCHAR(50) NOT NULL
		AFTER supplier_name,
	ADD address_suppliers VARCHAR(40) NOT NULL
		AFTER supplier_name;
-- Dùng comment một dòng
/*
Dùng comment nhiều dòng
Lấy ngày hiện tại cộng thêm 10 ngày
*/

-- chỉnh sửa mô tả một cột
ALTER TABLE suppliers
	MODIFY supplier_full_name VARCHAR(60) NULL;
	
-- modify many columms in the same time
ALTER TABLE suppliers
	MODIFY supplier_name VARCHAR(45),
    MODIFY suppliers_id VARCHAR(25);
    
-- xóa một cột trong bảng
ALTER TABLE suppliers
	DROP COLUMN supplier_full_name;
    
-- thay đổi tên cột supplier_full_name  thành full_name
ALTER TABLE suppliers
	CHANGE COLUMN supplier_full_name full_name
		VARCHAR(80) NOT NULL;
        
-- change name of a table
ALTER TABLE suppliers
	RENAME TO vendor;