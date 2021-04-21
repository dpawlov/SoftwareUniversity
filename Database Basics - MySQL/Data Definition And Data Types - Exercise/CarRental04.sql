CREATE DATABASE car_rental;
USE car_rental;

CREATE TABLE categories
(
    id           INT PRIMARY KEY AUTO_INCREMENT,
    category     VARCHAR(50)  NOT NULL,
    daily_rate   DOUBLE(5, 2) NOT NULL,
    weekly_rate  DOUBLE(5, 2) NOT NULL,
    monthly_rate DOUBLE(5, 2) NOT NULL,
    weekend_rate DOUBLE(5, 2) NOT NULL
);

CREATE TABLE cars
(
    id            INT PRIMARY KEY AUTO_INCREMENT,
    plate_number  VARCHAR(10) NOT NULL UNIQUE,
    make          VARCHAR(20) NOT NULL,
    model         VARCHAR(20) NOT NULL,
    car_year      YEAR,
    category_id   INT         NOT NULL,
    doors         INT         NOT NULL,
    picture       BLOB,
    car_condition VARCHAR(50) NOT NULL,
    available     TINYINT     NOT NULL
);

CREATE TABLE employees
(
    id         INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50) NOT NULL,
    last_name  VARCHAR(50) NOT NULL,
    title      VARCHAR(20),
    notes      TEXT
);

CREATE TABLE customers
(
    id                    INT PRIMARY KEY AUTO_INCREMENT,
    driver_licence_number INT          NOT NULL UNIQUE,
    full_name             VARCHAR(100) NOT NULL,
    address               VARCHAR(200),
    city                  VARCHAR(50),
    zip_code              INT          NOT NULL,
    notes                 TEXT
);

CREATE TABLE rental_orders
(
    id                INT PRIMARY KEY AUTO_INCREMENT,
    employee_id       INT          NOT NULL,
    customer_id       INT          NOT NULL,
    car_id            INT          NOT NULL,
    car_condition     VARCHAR(50)  NOT NULL,
    tank_level        INT          NOT NULL,
    kilometrage_start DOUBLE(8, 2) NOT NULL,
    kilometrage_end   DOUBLE(8, 2) NOT NULL,
    total_kilometrage DOUBLE(5, 2) NOT NULL,
    start_date        DATE         NOT NULL,
    end_date          DATE         NOT NULL,
    total_days        INT          NOT NULL,
    rate_applied      DOUBLE(5, 2) NOT NULL,
    tax_rate          DOUBLE(4, 2) NOT NULL,
    order_status      VARCHAR(50)  NOT NULL,
    notes             TEXT
);

INSERT INTO categories(category, daily_rate, weekly_rate, monthly_rate, weekend_rate)
VALUES ('cars', 1.2, 1.3, 1.4, 1.5),
       ('buses', 1.2, 1.3, 1.4, 1.5),
       ('trucks', 1.2, 1.3, 1.4, 1.5);

INSERT INTO cars(plate_number, make, model, category_id, doors, car_condition, available)
VALUES ('CB 1234 XT', 'Mercedes', 'C220', 1, 3, 'used', TRUE),
       ('CB 1234 XT', 'BWM', 'M5', 1, 3, 'used', TRUE),
       ('CB 1234 XT', 'Audi', 'A4', 1, 3, 'used', TRUE);

INSERT INTO employees(first_name, last_name, title)
VALUES ('Peter', 'Petrov', 'CEO'),
       ('Peter', 'Petrov', 'Manager'),
       ('Peter', 'Petrov', 'Owner');

INSERT INTO customers(driver_licence_number, full_name, zip_code)
VALUES (32141244, 'Peter Petrov', 1000),
       (52151252, 'Peter Petrov', 1000),
       (51552152, 'Peter Petrov', 1000);

INSERT INTO rental_orders(EMPLOYEE_ID, CUSTOMER_ID, CAR_ID, CAR_CONDITION, TANK_LEVEL, KILOMETRAGE_START,
                          KILOMETRAGE_END, TOTAL_KILOMETRAGE, START_DATE, END_DATE, TOTAL_DAYS, RATE_APPLIED, TAX_RATE,
                          ORDER_STATUS)
VALUES (1, 2, 2, 'used', 100, 180560.25, 180650.25, 250.22, '2020-01-01', '2020-01-15', 15, 1.5, 20.00, 'submitted'),
       (1, 2, 2, 'used', 100, 180560.25, 180650.25, 250.22, '2020-01-01', '2020-01-15', 15, 1.5, 20.00, 'submitted'),
       (1, 2, 2, 'used', 100, 180560.25, 180650.25, 250.22, '2020-01-01', '2020-01-15', 15, 1.5, 20.00, 'submitted');
