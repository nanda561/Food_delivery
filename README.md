🍔 FoodFlow – Food Delivery Web Application (Core Java)

A full-stack food delivery web application built using Core Java technologies only, without any frameworks.
This project demonstrates real-world backend logic, session handling, JDBC transactions, and clean MVC architecture using Servlets & JSP.

🚀 Features
👤 Customer

User registration & login

Browse restaurants

View restaurant menus

Add multiple items to cart

Increase / decrease quantity (+ / −)

View cart with total calculation

Place order

Order placed success animation

🏪 Restaurant Admin

Login as restaurant (admin role)

Add food items

View incoming orders

Update order status
(Preparing → Out for delivery → Delivered)

🛠️ Tech Stack (NO Frameworks)
Layer	Technology
Language	Java (JDK 17+)
Backend	Servlets (Jakarta EE)
View	JSP
Database	MySQL
Persistence	JDBC
Server	Apache Tomcat 10
Frontend	HTML5, CSS3, Vanilla JavaScript

❌ No Spring
❌ No Hibernate
❌ No Bootstrap

🧱 Architecture

The project follows a clean layered MVC architecture:

Controller (Servlets)
        ↓
Service Logic
        ↓
DAO (JDBC)
        ↓
Database (MySQL)
        ↓
View (JSP)

Packages

model – POJO classes

dao – Database logic (JDBC)

servlet – Controllers

filter – Role-based access control

util – DB connection & utilities

📂 Project Structure
FoodDeliveryApp/
├── src/main/java/com/foodapp
│   ├── model
│   ├── dao
│   ├── servlet
│   ├── servlet/admin
│   ├── filter
│   └── util
│
├── src/main/webapp
│   ├── css
│   ├── js
│   ├── images
│   ├── admin
│   ├── index.jsp
│   ├── menu.jsp
│   ├── cart.jsp
│   ├── checkout.jsp
│   ├── order_success.jsp
│   └── WEB-INF/web.xml
│
├── sql/food_delivery.sql
└── README.md

🗄️ Database Schema
Tables

users

restaurants

foods

cart

cart_items

orders

order_items

Key Concepts

Foreign key relationships

Transaction-safe order placement

PreparedStatements (SQL injection safe)

⚙️ Setup & Installation
1️⃣ Prerequisites

JDK 17 or later

Apache Tomcat 10.x

MySQL 8.x

Eclipse / IntelliJ IDEA

2️⃣ Database Setup
CREATE DATABASE food_delivery;


Import the SQL file:

sql/food_delivery.sql

3️⃣ Configure Database Connection

Update DBConnection.java:

private static final String URL =
  "jdbc:mysql://localhost:3306/food_delivery?useSSL=false&serverTimezone=UTC";
private static final String USER = "root";
private static final String PASSWORD = "your_password";

4️⃣ Add MySQL Connector

Place mysql-connector-j-8.x.x.jar inside:

WEB-INF/lib/

5️⃣ Deploy on Tomcat

Add project to Tomcat server

Clean & start server

Open browser:

http://localhost:8080/FoodDeliveryApp/home

🔐 Security Features

Password hashing (SHA-256)

Session-based authentication

Role-based access using Servlet Filters

PreparedStatement used everywhere

🎨 UI / UX

Responsive layout

Cart quantity controls (+ / −)

Loading spinner on checkout

Order success animation using pure CSS

Clean, modern UI (no UI libraries)

🧠 Key Learnings

End-to-end Servlet lifecycle

HttpSession management

JDBC transaction handling

MVC without frameworks

Debugging Tomcat startup issues

Clean separation of concerns

❗ Common Issues & Fixes
Issue	Fix
Tomcat not starting	Check duplicate servlet mappings
404 errors	Use servlet URLs, not JSP directly
Order success page not loading	Redirect from servlet, don’t link manually
Cart resets	Ensure session usage
Duplicate orders	Disable button / prevent resubmission
📌 Interview Explanation (Use This)

“I built a food delivery application using Core Java with Servlets, JSP, and JDBC.
The application follows MVC architecture with session-based cart handling and transaction-safe order processing.
Role-based access is implemented using servlet filters, and the UI is built with pure HTML, CSS, and JavaScript.”

📈 Future Enhancements

AJAX cart updates

Order history page

Search & filter restaurants

Spring Boot migration

REST API version

React frontend

👤 Author

Nandakishore Dharalingam
Java Full Stack Developer (Fresher)
📍 India

⭐ Final Note

This project is intentionally built without frameworks to demonstrate strong Core Java fundamentals.
It is suitable for Java Developer / Full Stack Fresher roles and is interview-defensible.
