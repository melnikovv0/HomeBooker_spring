# HomeBooker

A Spring Boot + HTML application for booking accommodations.

## User Roles
- **Guest** – can browse and book available accommodations.
- **Owner** – can add, edit, and manage their own listings and view reservations made by guests.

## Technologies Used
- Java 21
- Spring Boot 3
- MySQL
- Bootstrap 5
- HTML/CSS/JavaScript (frontend)

## Features
- User authentication and role-based access.
- Guests can:
    - View accommodations
    - Make bookings
    - View and cancel their bookings
- Owners can:
    - Add, edit, and delete accommodations
    - View reservations made by guests
    - Add image URLs for listings

## How to Run
1. Import the project into your IDE (e.g., IntelliJ IDEA or VS Code)
2. Create a database named `homebooker_db`
3. Run the SQL dump: `homebooker_dump.sql` to create tables
4. Update `application.properties` with your MySQL username and password
5. Run the main class: `HomeBookerApplication`
6. Open `http://localhost:9081/` in your browser

## Demo Users
- **Guest**
    - Email: `mel@example.com`
    - Password: `1234`
- **Owner**
    - Email: `lem@example.com`
    - Password: `1234`

## Notes
- Image URLs can be added as direct links (e.g., from Wikipedia or Unsplash)
- Make sure MySQL is running and accessible on port 3306

## Author
Evgenii Melnikov, VŠB-TUO, FEI
