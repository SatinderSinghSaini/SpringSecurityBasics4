create database springsecuritydemo;
use springsecuritydemo;

create table 'users'(
'id' INT NOT NULL AUTO_INCREMENT,
'username' VARCHAR(45) NOT NULL,
'password' VARCHAR(45) NOT NULL,
'enabled' INT NOT NULL,
PRIMARY KEY('id')
);

create table 'authorities' (
'id' INT NOT NULL AUTO_INCREMENT,
'username' VARCHAR(45) NOT NULL,
'authority' VARCHAR(45) NOT NULL
PRIMARY KEY('id')
);

Insert ignore into 'users' values(null,'happy','123',1);
insert ignore into 'authorities' values(null,'happy','write');


CREATE TABLE `springsecuritydemo`.`customers` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NOT NULL,
  `pwd` VARCHAR(200) NOT NULL,
  `role` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));

insert ignore into 'customers' values(null,'happy@gmail.com','123','write');