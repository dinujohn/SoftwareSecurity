CREATE DATABASE SPRINGJDBC;

USE SPRINGJDBC;

CREATE TABLE EMPLOYEE(
EMP_ID INT(5) PRIMARY KEY AUTO_INCREMENT NOT NULL,
EMP_NAME VARCHAR(20) NOT NULL,
EMP_DEPT VARCHAR (20) NOT NULL,
EMP_EMAILID VARCHAR(50) NOT NULL);