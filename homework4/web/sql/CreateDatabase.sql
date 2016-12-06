CREATE DATABASE IF NOT EXISTS practiceapp;
USE practiceapp;

DROP TABLE IF EXISTS Book;


CREATE TABLE Book (
  BookId INT NOT NULL AUTO_INCREMENT,
  FirstName VARCHAR(75),
  LastName VARCHAR(75),
  Email VARCHAR(100),
  Title VARCHAR(100),
  DueDate Date,
  
  PRIMARY KEY(BookId) 
);

INSERT INTO Book 
  (FirstName, LastName, Email, Title, DueDate)
VALUES 
  ('Dave', 'Powell', 'dpowell2@elon.edu', 'Java Servlets and JSP', '2016-11-15'),
  ('Shannon', 'Duvall', 'sduvall2@elon.edu', 'Game Programming', '2015-10-12'), 
  ('Joel', 'Hollingsworth', 'jhollingsworth@elon.edu', 'Operating Systems', '2016-11-26');