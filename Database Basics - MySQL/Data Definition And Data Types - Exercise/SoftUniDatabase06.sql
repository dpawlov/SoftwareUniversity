/*14.Create SoftUni Database*/
CREATE DATABASE soft_uni;
USE soft_uni;

CREATE TABLE towns
(
    id   INT         NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE addresses
(
    id           INT          NOT NULL PRIMARY KEY AUTO_INCREMENT,
    address_text VARCHAR(200) NOT NULL,
    town_id      INT          NOT NULL,
    CONSTRAINT fk_addresses_town FOREIGN KEY (town_id) REFERENCES towns (id)
);

CREATE TABLE departments
(
    id   INT         NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE employees
(
    id            INT         NOT NULL PRIMARY KEY AUTO_INCREMENT,
    first_name    VARCHAR(20) NOT NULL,
    middle_name   VARCHAR(20) NOT NULL,
    last_name     VARCHAR(20) NOT NULL,
    job_title     VARCHAR(50) NOT NULL,
    department_id INT         NOT NULL,
    CONSTRAINT fk_employees_departments FOREIGN KEY (department_id) REFERENCES departments (id),
    hire_date     DATE        NOT NULL,
    salary        DECIMAL     NOT NULL,
    address_id    INT         NOT NULL,
    CONSTRAINT fk_employees_addresses FOREIGN KEY (address_id) REFERENCES addresses (id)
);