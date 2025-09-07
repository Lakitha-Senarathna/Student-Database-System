# Student Database System

A console-based Java application to manage student records with CRUD operations (Create, Read, Update, Delete) using MySQL.

## Setup Instructions

1. **Install MySQL**:
   - Use XAMPP. Start the MySQL service.

2. **Create Database and Table**:
   - Open a MySQL terminal (e.g., `mysql -u root -p`).
   - Run the following commands:
     ```sql
     CREATE DATABASE student_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
     USE student_db;
     CREATE TABLE students (
         id INT AUTO_INCREMENT PRIMARY KEY,
         name VARCHAR(255) NOT NULL,
         email VARCHAR(255) NOT NULL,
         course VARCHAR(255) NOT NULL
     );
     CREATE USER 'Miniproject'@'localhost' IDENTIFIED BY 'StrongPass123!';
     GRANT ALL PRIVILEGES ON student_db.* TO 'Miniproject'@'localhost';
     FLUSH PRIVILEGES;
