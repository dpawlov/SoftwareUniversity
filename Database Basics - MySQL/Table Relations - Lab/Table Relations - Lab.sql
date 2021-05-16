-- 1. Mountains and Peaks
CREATE TABLE `mountains` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(50) NOT NULL
);
CREATE TABLE `peaks` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(50) NOT NULL,
`mountain_id` INT,
CONSTRAINT `fk_peaks_mountains`
FOREIGN KEY (`mountain_id`)
REFERENCES `mountains`(`id`)
);

-- 2. Trip Organization
SELECT 
    v.driver_id,
    v.vehicle_type,
    CONCAT_WS(' ', c.first_name, c.last_name) AS driver_name
FROM
    campers AS c
        JOIN
    vehicles AS v ON c.id = v.driver_id;
    
-- 3.	SoftUni Hiking
SELECT 
    r.starting_point,
    r.end_point,
    r.leader_id,
    CONCAT_WS(' ', c.first_name, c.last_name) AS leader_name
FROM
    campers AS c
        JOIN
    routes AS r ON c.id = r.leader_id;
    
-- 4. Delete Mountains
CREATE TABLE `mountains`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(20) NOT NULL
);

CREATE TABLE `peaks`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(20) NOT NULL,
`mountain_id` INT,
CONSTRAINT `fk_mountain_id`
FOREIGN KEY(`mountain_id`)
REFERENCES `mountains`(`id`)
ON DELETE CASCADE
);
    
-- 5.	 Project Management DB*
    CREATE DATABASE company;
USE company;

CREATE TABLE employees (
    id INT UNIQUE NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(30) NOT NULL,
    last_name VARCHAR(30) NOT NULL,
    project_id INT UNIQUE,
    CONSTRAINT pk_employees PRIMARY KEY (id)
);

CREATE TABLE clients (
    id INT UNIQUE NOT NULL AUTO_INCREMENT,
    client_name VARCHAR(100) NOT NULL,
    project_id INT UNIQUE,
    CONSTRAINT pk_clients PRIMARY KEY (id)
);

CREATE TABLE projects (
    id INT UNIQUE NOT NULL AUTO_INCREMENT,
    client_id INT UNIQUE,
    project_lead_id INT UNIQUE,
    CONSTRAINT pk_projects PRIMARY KEY (id)
);

ALTER TABLE employees 
	ADD CONSTRAINT fk_projects_employees FOREIGN KEY (project_id) REFERENCES projects(id);
    
ALTER TABLE clients 
	ADD CONSTRAINT fk_projects_clients FOREIGN KEY (project_id) REFERENCES projects(id);
    
ALTER TABLE projects 
	ADD CONSTRAINT fk_clients_projects FOREIGN KEY (client_id) REFERENCES clients(id),
    ADD CONSTRAINT fk_emoloyees_projects FOREIGN KEY (project_lead_id) REFERENCES employees(id);