use classicmodels;
SELECT * FROM customers WHERE customerName = "Reims Collectables";
ALTER TABLE customers ADD INDEX idx_customerName(customerName);
ALTER TABLE customers ADD INDEX idx_full_name(contactFirstName, contactLastName);
EXPLAIN SELECT * FROM customers WHERE contactFirstName = 'Jean' or contactFirstName = 'King';
