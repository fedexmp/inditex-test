DROP TABLE IF EXISTS clothes;
CREATE TABLE clothes (
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(50) NOT NULL,
sales INT,
small_size INT,
medium_size INT,
large_size INT);
INSERT INTO clothes (name, sales, small_size, medium_size, large_size) VALUES ('V-NECH BASIC SHIRT', 100, 4, 9, 0);
INSERT INTO clothes (name, sales, small_size, medium_size, large_size) VALUES ('CONTRASTING FABRIC T-SHIRT', 50, 35, 9, 9);
INSERT INTO clothes (name, sales, small_size, medium_size, large_size) VALUES ('RAISED PRINT T-SHIRT', 80, 20, 2, 20);
INSERT INTO clothes (name, sales, small_size, medium_size, large_size) VALUES ('PLEATED T-SHIRT', 3, 25, 30, 10);
INSERT INTO clothes (name, sales, small_size, medium_size, large_size) VALUES ('CONTRASTING LACE T-SHIRT', 650, 0, 1, 0);
INSERT INTO clothes (name, sales, small_size, medium_size, large_size) VALUES ('SLOGAN T-SHIRT', 20, 9, 2, 5);