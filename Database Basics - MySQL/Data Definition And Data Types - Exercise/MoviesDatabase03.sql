/*11.Movies Database*/
CREATE DATABASE `Movies`;
USE `movies`;

CREATE TABLE `directors` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `director_name` VARCHAR(100) NOT NULL,
    `notes` VARCHAR(100) NOT NULL
	);

CREATE TABLE `genres` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `genre_name` VARCHAR(50) NOT NULL,
    `notes` TEXT
    );
    
CREATE TABLE `categories` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `category_name` VARCHAR(50) NOT NULL,
    `notes` TEXT
	);

CREATE TABLE `movies` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `title` VARCHAR(100) NOT NULL,
    `director_id` INT 	 NOT NULL,
    `copyright_year` YEAR,
    `length` INT,
    `genre_id` INT 	     NOT NULL,
    `category_id` INT 	 NOT NULL,
    `rating` INT,
    `notes` TEXT
	);
    
INSERT INTO directors(director_name, notes)
VALUES ('Ivan Petrov', 'Random text1'),
       ('Ivan Petrov', 'Random text2'),
       ('Ivan Petrov', 'Random text3'),
       ('Ivan Petrov', 'Random text4'),
       ('Ivan Petrov', 'Random text5');

INSERT INTO genres(genre_name, notes)
VALUES ('Petar Petrov', 'Random text1'),
       ('Petar Petrov', 'Random text2'),
       ('Petar Petrov', 'Random text3'),
       ('Petar Petrov', 'Random text4'),
       ('Petar Petrov', 'Random text5');

INSERT INTO categories(category_name, notes)
VALUES ('Dimitar Dimitrov', 'Random text1'),
       ('Dimitar Dimitrov', 'Random text2'),
       ('Dimitar Dimitrov', 'Random text3'),
       ('Dimitar Dimitrov', 'Random text4'),
       ('Dimitar Dimitrov', 'Random text5');

INSERT INTO movies(title, director_id, copyright_year, length, genre_id, category_id, rating, notes)
VALUES ('Movie Title 1', 1, 2020, 180, 2, 2, 1, 'Random text1'),
       ('Movie Title 2', 2, 2020, 180, 2, 2, 1, 'Random text2'),
       ('Movie Title 3', 3, 2020, 180, 2, 2, 1, 'Random text3'),
       ('Movie Title 4', 4, 2020, 180, 2, 2, 1, 'Random text4'),
       ('Movie Title 5', 5, 2020, 180, 2, 2, 1, 'Random text5');
    

