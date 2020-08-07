use users;

DELIMITER $$
CREATE PROCEDURE get_user_by_id(IN user_id INT)
BEGIN
    SELECT users.name, users.email, users.country
    FROM users
    where users.id = user_id;
    END$$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE get_all_user()
BEGIN
    SELECT users.id,users.name, users.email, users.country
    FROM users;
    END$$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE insert_user(
IN user_name varchar(50),
IN user_email varchar(50),
IN user_country varchar(50)
)
BEGIN
    INSERT INTO users(name, email, country) VALUES(user_name, user_email, user_country);
    END$$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE update_user(
IN user_name varchar(50),
IN user_email varchar(50),
IN user_country varchar(50),
IN user_id integer
)
BEGIN
   UPDATE users
SET name=user_name,email=user_email,country=user_country
WHERE id=user_id;
    END$$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE delete_user(
IN user_id integer
)
BEGIN
   delete from users
WHERE id=user_id;
    END$$
DELIMITER ;

call delete_user(8);