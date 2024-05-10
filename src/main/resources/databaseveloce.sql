USE databaseveloce;-- Users Table
CREATE TABLE users (
                       user_id INT AUTO_INCREMENT PRIMARY KEY,
                       username VARCHAR(255) UNIQUE NOT NULL,
                       password VARCHAR(255) NOT NULL,
                       email VARCHAR(255) UNIQUE NOT NULL,
                       full_name VARCHAR(255) NOT NULL,
                       created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
                       last_login DATETIME
);

CREATE TABLE vehicles (
                          vehicleid INT AUTO_INCREMENT PRIMARY KEY,
                          typevehicle ENUM('car','van','suv','sedan','motorcycle') NOT NULL,
                          brand VARCHAR(255) NOT NULL,
                          model VARCHAR(255) NOT NULL,
                          priceperday int(10, 2) NOT NULL,
                          status ENUM('available', 'rented', 'maintenance') NOT NULL DEFAULT 'available'
);

CREATE TABLE reservations (
                              reservation_id INT AUTO_INCREMENT PRIMARY KEY,
                              user_id INT NOT NULL,
                              vehicle_id INT NOT NULL,
                              start_date DATE NOT NULL,
                              end_date DATE NOT NULL,
                              total_cost DECIMAL(10, 2) NOT NULL,
                              FOREIGN KEY (user_id) REFERENCES users(user_id),
                              FOREIGN KEY (vehicle_id) REFERENCES vehicles(vehicle_id)
);

CREATE TABLE transactions (
                              transaction_id INT AUTO_INCREMENT PRIMARY KEY,
                              reservation_id INT NOT NULL,
                              amount DECIMAL(10, 2) NOT NULL,
                              transaction_date DATETIME DEFAULT CURRENT_TIMESTAMP,
                              payment_method ENUM('credit card', 'debit card', 'cash') NOT NULL,
                              FOREIGN KEY (reservation_id) REFERENCES reservations(reservation_id)
);