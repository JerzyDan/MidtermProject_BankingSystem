CREATE USER 'airline-tester'@'localhost' identified by 'airline-tester123';
GRANT ALL privileges ON *.* TO 'airline-tester'@'localhost';
FLUSH privileges;

create database bankingSystem;
use bankingSystem;
show tables;
select * from account;
select * from account_holder;
select * from third_party;