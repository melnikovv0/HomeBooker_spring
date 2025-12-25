# 🏡 HomeBooker — Spring Edition

**HomeBooker** is a robust property booking backend service designed for seamless accommodation management. Built with **Java 21** and **Spring Boot 3**, it provides a reliable RESTful API integrated with MySQL and features an interactive UI for both guests and property owners.

---

### 🚀 Key Features

* **👥 Dual-Role System:** * **Guest:** Browse listings, make reservations, and manage personal bookings.
    * **Owner:** Full control over listings (Add/Edit/Delete) and real-time reservation tracking.
* **🔐 Secure Access:** Role-based authentication and authorization.
* **📖 Interactive API:** Fully documented endpoints via **Swagger UI** for easy testing and integration.
* **🖼️ Media Support:** Dynamic image integration via direct URLs for property listings.

---

### 🛠 Tech Stack

* **Backend:** Java 21, Spring Boot 3.x
* **Database:** MySQL (Relational storage)
* **Documentation:** Swagger / OpenAPI 3
* **Frontend:** HTML5, CSS3, JavaScript (Bootstrap 5)
* **Build Tool:** Maven/Gradle

---

### ⚙️ Quick Start Guide

1.  **Clone & Import:** Open the project in your favorite IDE (IntelliJ IDEA recommended).
2.  **Database Setup:**
    * Create a local database: `CREATE DATABASE homebooker_db;`
    * Import the initial structure using `homebooker_dump.sql`.
3.  **Configuration:**
    * Navigate to `src/main/resources/application.properties`.
    * Update `spring.datasource.username` and `password` with your MySQL credentials.
4.  **Launch:**
    * Run the `HomeBookerApplication` class.
    * The server will start on: **`http://localhost:9081/`**

---



### 📝 Project Notes
* **API Docs:** Once the app is running, visit the Swagger UI to test REST endpoints.
* **Port:** Ensure port **9081** is free before launching.
* **MySQL:** Make sure your MySQL service is active on port **3306**.

---

### 👨‍💻 Author
**Evgenii Melnikov** *VŠB-TUO, FEI*
