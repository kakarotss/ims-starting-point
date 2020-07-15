create database if not exists ims;
DROP TABLE IF EXISTS orderlines;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS customers;
DROP TABLE IF EXISTS users;
create table if not exists customers(id int primary key auto_increment, first_name varchar(40), surname varchar(40));
CREATE TABLE if not exists products (prodId INT auto_increment NOT NULL,prodName VARCHAR(40),prodPrice DOUBLE NOT NULL,prodQty INT NOT NULL,primary key(prodId));
CREATE TABLE if not exists orders (orderId INT auto_increment NOT NULL, orderCustId INT, total DOUBLE , primary key(orderId), foreign key(orderCustId) references customers(id) );
CREATE TABLE if not exists orderlines (orderId INT NOT NULL, orderLinesId INT auto_increment, orderCustId INT NOT NULL, prodId INT NOT NULL, prodQty INT NOT NULL, lineCost DOUBLE NOT NULL, FOREIGN KEY (orderId) REFERENCES orders(orderId), FOREIGN KEY (orderCustId) REFERENCES orders(orderCustId), FOREIGN KEY (prodId) REFERENCES products(prodId), PRIMARY KEY (orderLinesId));
insert into customers (first_name, surname) values ("Arbab", "Ahmed");
insert into customers (first_name, surname) values ("Vinesh", "Ghela");
insert into customers (first_name, surname) values ("Alan", "idk");
insert into customers (first_name, surname) values ("Nicholas", "idk");
insert into customers (first_name, surname) values ("angelica", "idk");
insert into products (prodName, prodPrice, prodQty) VALUES ("Nike air max 270", 125, 200);
insert into products (prodName, prodPrice, prodQty) VALUES ("Nike sequent 4", 110, 150);
insert into products (prodName, prodPrice, prodQty) VALUES ("Adidas super shenron", 250, 25);
insert into products (prodName, prodPrice, prodQty) VALUES ("Adidas NMD", 80, 100);
insert into products (prodName, prodPrice, prodQty) VALUES ("Nike react 526", 115, 80);
insert into orders (orderCustId, total) values (2, 125 );
insert into orders (orderCustId, total) values (3, 210 );
insert into orders (orderCustId, total) values (4, 250 );
insert into orderlines (orderId, orderCustId, prodId, prodQty, lineCost) VALUES (1, 2, 1, 1, 125);
insert into orderlines (orderId, orderCustId, prodId, prodQty, lineCost) VALUES (2, 3, 2, 2, 110);
insert into orderlines (orderId, orderCustId, prodId, prodQty, lineCost) VALUES (3, 4, 3, 1, 250);