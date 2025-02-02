-- -- Step 1: Create the flights table
CREATE TABLE flights (
    airline_id INT PRIMARY KEY,
    airline_number VARCHAR(10),
    airline_name VARCHAR(50),
    departure_city VARCHAR(50),
    arrival_city VARCHAR(50),
    departure_date DATE,
    arrival_date DATE,
    departure_time TIME,
    arrival_time TIME,
    price float
);

-- -- Step 2: Insert sample data into the flights table
INSERT INTO flights (airline_id, airline_number, airline_name, departure_city, arrival_city, departure_date, arrival_date, departure_time, arrival_time, price) 
VALUES 
(1, 'AI202', 'Air India', 'Mumbai', 'Delhi', '2025-01-25', '2025-01-25', '10:30:00', '12:30:00', 5000.00),
(2, 'SG105', 'SpiceJet', 'Delhi', 'Chennai', '2025-01-26', '2025-01-26', '15:00:00', '17:30:00', 4500.00),
(3, 'IND150', 'IndiGo', 'Bangalore', 'Pune', '2025-01-27', '2025-01-27', '09:15:00', '10:30:00', 3000.00),
(4, 'AI303', 'Air India', 'Kolkata', 'Mumbai', '2025-01-28', '2025-01-28', '18:00:00', '19:45:00', 5500.00),
(5, 'VX401', 'Vistara', 'Delhi', 'Goa', '2025-01-29', '2025-01-29', '14:00:00', '15:45:00', 6000.00),
(6, 'SG302', 'SpiceJet', 'Mumbai', 'Kolkata', '2025-01-30', '2025-01-30', '08:00:00', '10:00:00', 5200.00),
(7, 'IND250', 'IndiGo', 'Chennai', 'Bangalore', '2025-01-31', '2025-01-31', '11:30:00', '13:00:00', 3500.00),
(8, 'AI505', 'Air India', 'Hyderabad', 'Delhi', '2025-02-01', '2025-02-01', '16:45:00', '18:30:00', 4800.00),
(9, 'VX601', 'Vistara', 'Pune', 'Mumbai', '2025-02-02', '2025-02-02', '07:15:00', '08:30:00', 2900.00),
(10, 'SG707', 'SpiceJet', 'Delhi', 'Pune', '2025-02-03', '2025-02-03', '19:00:00', '21:00:00', 4100.00),
(11, 'AI203', 'Air India', 'Mumbai', 'Delhi', '2025-01-25', '2025-01-25', '14:30:00', '16:30:00', 5100.00),
(12, 'SG106', 'SpiceJet', 'Delhi', 'Chennai', '2025-01-26', '2025-01-26', '16:00:00', '18:30:00', 4600.00),
(13, 'IND151', 'IndiGo', 'Bangalore', 'Pune', '2025-01-27', '2025-01-27', '12:15:00', '13:30:00', 3100.00),
(14, 'AI304', 'Air India', 'Kolkata', 'Mumbai', '2025-01-28', '2025-01-28', '20:00:00', '21:45:00', 5600.00),
(15, 'VX402', 'Vistara', 'Delhi', 'Goa', '2025-01-29', '2025-01-29', '17:00:00', '18:45:00', 6100.00),
(16, 'SG303', 'SpiceJet', 'Mumbai', 'Kolkata', '2025-01-30', '2025-01-30', '09:30:00', '11:30:00', 5300.00),
(17, 'IND251', 'IndiGo', 'Chennai', 'Bangalore', '2025-01-31', '2025-01-31', '13:30:00', '15:00:00', 3600.00),
(18, 'AI506', 'Air India', 'Hyderabad', 'Delhi', '2025-02-01', '2025-02-01', '19:45:00', '21:30:00', 4900.00),
(19, 'VX602', 'Vistara', 'Pune', 'Mumbai', '2025-02-02', '2025-02-02', '09:15:00', '10:30:00', 3000.00),
(20, 'SG708', 'SpiceJet', 'Delhi', 'Pune', '2025-02-03', '2025-02-03', '20:00:00', '22:00:00', 4200.00), 
(21, 'AI204', 'Air India', 'Mumbai', 'Delhi', '2025-01-25', '2025-01-25', '18:30:00', '20:30:00', 5200.00),
(22, 'SG109', 'SpiceJet', 'Delhi', 'Chennai', '2025-01-26', '2025-01-26', '17:30:00', '20:00:00', 4700.00),
(23, 'IND152', 'IndiGo', 'Bangalore', 'Pune', '2025-01-27', '2025-01-27', '15:15:00', '16:30:00', 3200.00),
(24, 'AI305', 'Air India', 'Kolkata', 'Mumbai', '2025-01-28', '2025-01-29', '23:00:00', '00:45:00', 5700.00),
(25, 'VX403', 'Vistara', 'Delhi', 'Goa', '2025-01-29', '2025-01-29', '10:00:00', '11:45:00', 5900.00),
(26, 'SG304', 'SpiceJet', 'Mumbai', 'Kolkata', '2025-01-30', '2025-01-30', '13:00:00', '15:00:00', 5100.00),
(27, 'IND253', 'IndiGo', 'Chennai', 'Bangalore', '2025-01-31', '2025-01-31', '08:30:00', '10:00:00', 3400.00),
(28, 'AI507', 'Air India', 'Hyderabad', 'Delhi', '2025-02-01', '2025-02-01', '11:15:00', '13:00:00', 4600.00),
(29, 'VX603', 'Vistara', 'Pune', 'Mumbai', '2025-02-02', '2025-02-02', '18:15:00', '19:30:00', 2850.00),
(30, 'SG709', 'SpiceJet', 'Delhi', 'Pune', '2025-02-03', '2025-02-03', '06:00:00', '08:00:00', 4300.00),
(31, 'AI205', 'Air India', 'Mumbai', 'Delhi', '2025-01-25', '2025-01-25', '12:30:00', '14:30:00', 5050.00),
(32, 'SG110', 'SpiceJet', 'Delhi', 'Chennai', '2025-01-26', '2025-01-26', '21:00:00', '23:30:00', 4550.00),
(33, 'IND153', 'IndiGo', 'Bangalore', 'Pune', '2025-01-27', '2025-01-27', '07:15:00', '08:30:00', 2950.00),
(34, 'AI306', 'Air India', 'Kolkata', 'Mumbai', '2025-01-28', '2025-01-28', '13:00:00', '14:45:00', 5400.00),
(35, 'VX404', 'Vistara', 'Delhi', 'Goa', '2025-01-29', '2025-01-29', '22:00:00', '23:45:00', 6200.00),
(36, 'SG305', 'SpiceJet', 'Mumbai', 'Kolkata', '2025-01-30', '2025-01-30', '10:00:00', '12:00:00', 5000.00),
(37, 'IND254', 'IndiGo', 'Chennai', 'Bangalore', '2025-01-31', '2025-01-31', '16:45:00', '18:00:00', 3500.00),
(38, 'AI508', 'Air India', 'Hyderabad', 'Delhi', '2025-02-01', '2025-02-01', '08:00:00', '09:45:00', 4800.00),
(39, 'VX604', 'Vistara', 'Pune', 'Mumbai', '2025-02-02', '2025-02-02', '14:30:00', '15:45:00', 2900.00),
(40, 'SG710', 'SpiceJet', 'Delhi', 'Pune', '2025-02-03', '2025-02-03', '19:30:00', '21:30:00', 4100.00);






create table users(
    id int auto_increment primary key,
    first_name varchar(30),
    last_name varchar(30),
    email varchar(30),
    password varchar(30),
    dob date
);

create table passengers(
    id int auto_increment primary key,
    passenger_name varchar(50),
    email varchar(40),
    phone varchar(10)
);

create table cards(
    payment_id int auto_increment primary key,
    card_no varchar(16),
    card_name varchar(40),
    expiry_date date,
    cvv int,
    payment_date_time datetime
);

create table reservation(
    booking_id int auto_increment primary key,
    passenger_id int,
    flight_id int,
    payment_id int,
    constraint fk_pid foreign key(passenger_id) references passengers(id),
    constraint fk_fid foreign key(flight_id) references flights(airline_id),
    constraint fk_payid foreign key(payment_id) references cards(payment_id)
);

-- select booking_id ,p.passenger_name, f.flight_number,f.departure_city,f.arrival_city,f.departure_date,f.departure_time,f.available_seats
-- from reservation r inner join passengers p on r.passenger_id=p.id
-- inner join flights f on r.flight_id=f.flight_id;          



