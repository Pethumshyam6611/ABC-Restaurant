# 🍽️ ABC Restaurant Web Application

A comprehensive, fully responsive **Restaurant Management System** built using **Java, JSP, HTML, CSS (Bootstrap)** within **Eclipse IDE**, following **MVC architecture**, **SOLID principles**, and **popular design patterns**.  
The system provides robust features for customers and admins — from cart-based food ordering to reservation handling and sales analytics via charts and PDFs.

---

## 🌐 Web Interface (HTML Integration)

This project features a **custom-designed HTML interface** styled with Bootstrap and CSS, which provides:

- 🎨 **A clean and modern layout**
- 🧾 **Dynamic Menu Sections** with filters like "All", "Drinks", "Main Course", etc.
- 🛒 **Cart system with quantity management**
- 📩 **Popup modals** for login, signup, and bills
- 📱 **Responsive design** for desktop and mobile

> ✅ HTML is integrated into JSP pages inside `WebContent/jsp/` and rendered dynamically using JSTL and servlet responses.

---

## 🧩 Key Features

- 🛍️ **Cart System** – Add/remove items, update quantities
- ✅ **Checkout with Bill Modal**
- ✉️ **Email Confirmation** on successful orders/reservations
- 📊 **Admin Dashboard with Bar Charts + Bell Curves**
- 🧾 **Downloadable PDF Sales Reports**
- 📆 **Reservation System with confirmation**
- 👥 **Admin, Staff, Customer login panels**
- 📦 **Unit Testing using JUnit 4**
- 🔒 **Role-based access control**

---

## 💻 Technologies Used

| Component        | Tech Used                            |
|------------------|--------------------------------------|
| Frontend         | HTML, CSS, JavaScript, Bootstrap     |
| Backend          | Java, JSP, Servlets, JSTL            |
| Architecture     | MVC + SOLID + Service Layer          |
| Database         | MySQL                                |
| Server           | Apache Tomcat                        |
| Testing          | JUnit 4                              |
| Tools            | Eclipse IDE, MySQL Workbench         |
| Patterns Used    | Singleton, Factory, DAO              |

---
## 🛠️ Setup & Deployment

### Prerequisites

- Java 8 or higher
- Eclipse IDE with Java EE support
- Apache Tomcat 9 or above
- MySQL Server & MySQL Workbench

### Installation Steps

```bash
# 1. Clone the repository
git clone https://github.com/Pethumshyam6611/ABC-Restaurant.git

# 2. Import the project into Eclipse as a Dynamic Web Project

# 3. Create database
Import the script at: database/abc_restaurant.sql

# 4. Configure database credentials in DBConnection.java

# 5. Deploy to Tomcat and run the project

