create database if not exists ims;
create table if not exists ims.customers(id int primary key auto_increment, first_name varchar(40), surname varchar(40));
CREATE TABLE products (prodId INT auto_increment NOT NULL,prodName VARCHAR(40),prodPrice DOUBLE NOT NULL,prodQty INT NOT NULL,primary key(prodId));