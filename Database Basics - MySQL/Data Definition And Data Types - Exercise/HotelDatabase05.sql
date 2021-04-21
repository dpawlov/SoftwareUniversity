CREATE DATABASE hotel;
USE hotel;

CREATE TABLE employees
(
    id         INT         NOT NULL PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50) NOT NULL,
    last_name  VARCHAR(50) NOT NULL,
    title      VARCHAR(50) NOT NULL,
    notes      TEXT
);

CREATE TABLE customers
(
    account_number   INT         NOT NULL PRIMARY KEY AUTO_INCREMENT,
    first_name       VARCHAR(50) NOT NULL,
    last_name        VARCHAR(50) NOT NULL,
    phone_number     VARCHAR(15) UNIQUE,
    emergency_name   VARCHAR(50) NOT NULL UNIQUE,
    emergency_number VARCHAR(50) NOT NULL UNIQUE,
    notes            TEXT
);

CREATE TABLE room_status
(
    room_status VARCHAR(50) NOT NULL,
    notes       TEXT
);

CREATE TABLE room_types
(
    room_type VARCHAR(20) NOT NULL,
    notes     TEXT
);

CREATE TABLE bed_types
(
    bed_type VARCHAR(20) NOT NULL,
    notes    TEXT
);

CREATE TABLE rooms
(
    room_number INT          NOT NULL PRIMARY KEY AUTO_INCREMENT,
    room_type   VARCHAR(50)  NOT NULL,
    bed_type    VARCHAR(20)  NOT NULL,
    rate        DOUBLE(5, 2) NOT NULL,
    room_status VARCHAR(50)  NOT NULL,
    notes       TEXT
);

CREATE TABLE payments
(
    id                  INT          NOT NULL PRIMARY KEY AUTO_INCREMENT,
    employee_id         INT          NOT NULL,
    FOREIGN KEY (employee_id) REFERENCES employees (id),
    payment_date        TIMESTAMP    NOT NULL,
    account_number      INT          NOT NULL,
    first_date_occupied TIMESTAMP    NOT NULL,
    last_date_occupied  TIMESTAMP    NOT NULL,
    total_days          INT          NOT NULL,
    amount_charged      DOUBLE(6, 2) NOT NULL,
    tax_rate            DOUBLE(4, 2) NOT NULL,
    tax_amount          DOUBLE(5, 2) NOT NULL,
    payment_total       DOUBLE(6, 2) NOT NULL,
    notes               TEXT
);

CREATE TABLE occupancies
(
    id             INT          NOT NULL PRIMARY KEY AUTO_INCREMENT,
    employee_id    INT          NOT NULL,
    date_occupied  TIMESTAMP    NOT NULL,
    account_number INT          NOT NULL,
    room_number    INT          NOT NULL,
    rate_applied   DOUBLE(4, 2) NOT NULL,
    phone_charge   DOUBLE(4, 2),
    notes          TEXT
);

INSERT INTO employees (first_name, last_name, title)
VALUES ('petko', 'petkov', 'manager'),
       ('petko', 'petkov', 'manager'),
       ('petko', 'petkov', 'manager');

INSERT INTO customers (first_name, last_name, phone_number, emergency_name, emergency_number,
                       notes)
VALUES ('petko', 'petkov', 2222222222, 'petko kapitan', 333333, 'notes1'),
       ('petko', 'petkov', 1111111111, 'petko captain', 222222, 'notes2'),
       ('petko', 'petkov', 3333333333, 'petko komutan', 111111, 'notes3');

INSERT INTO room_status (room_status)
VALUES ('available'),
       ('needs cleaning'),
       ('reserved');

INSERT INTO room_types (room_type)
VALUES ('suite'),
       ('single-room'),
       ('president-apartment');

INSERT INTO bed_types (bed_type)
VALUES ('single-bed'),
       ('person-and-a-half'),
       ('large-bed');

INSERT INTO rooms (room_type, bed_type, rate, room_status)
VALUES ('suite', 'large-bed', 80.00, 'available'),
       ('suite', 'large-bed', 80.00, 'available'),
       ('suite', 'large-bed', 80.00, 'available');

INSERT INTO payments (employee_id, payment_date, account_number, first_date_occupied, last_date_occupied,
                      total_days, amount_charged, tax_rate, tax_amount, payment_total)
VALUES (1, '2018-05-05 08:00:00', 1, '2018-05-05 08:00:00', '2018-05-13 11:00:00', 8, 640.00, 20.00, 128.00, 768.00),
       (1, '2018-05-05 08:00:00', 1, '2018-05-05 08:00:00', '2018-05-13 11:00:00', 8, 640.00, 20.00, 128.00, 768.00),
       (1, '2018-05-05 08:00:00', 1, '2018-05-05 08:00:00', '2018-05-13 11:00:00', 8, 640.00, 20.00, 128.00, 768.00);

INSERT INTO occupancies (employee_id, date_occupied, account_number, room_number, rate_applied, phone_charge)
VALUES (1, '2018-05-05 08:00:00', 1, 2, 20.00, 24.20),
       (1, '2018-05-05 08:00:00', 1, 2, 20.00, 24.20),
       (1, '2018-05-05 08:00:00', 1, 2, 20.00, 24.20);
