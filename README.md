# CarWorldEnterprise

CarWorldEnterprise is an advanced Spring Boot application for car dealership management, supporting rich car data, user accounts, bookings, robust RESTful APIs, and clear separation between new and used car inventories. The platform is engineered for extensibility, reliability, and clarity, making it a foundation for scalable automotive solutions.

---

## 🚗 Impactful Features

- **Comprehensive Data Models**
  - **Car**: Rich attributes including brand, price, rating, mileage, engine power, body type, fuel type, transmission, seating, summary, images, pros/cons, EMI, city, distance.
  - **User**: Handles user accounts with name, email, password, confirm password, profile image, user role (ADMIN/USER), and age.
  - **Booking**: Represents car bookings, including booking status (CONFIRMED, PENDING, CANCELLED, COMPLETED), payment status (PAID, PENDING, FAILED, REFUNDED, CANCELLED), booking date, total price, and references to users and cars.

- **Domain Separation**
  - Separate services & repositories for new and used cars
  - User and Booking repositories/services for modular extension

- **RESTful CRUD API**
  - Add, update, retrieve, delete cars, users, bookings via clean, well-structured endpoints
  - JSON-based request/response for easy integration

- **Robust Error Handling**
  - Standard HTTP status codes, descriptive error messages

- **Extensible Architecture**
  - Enum types for body/transmission/fuel types, user roles, booking/payment status
  - Easily introduce new attributes or categories

- **Spring Boot & JPA**
  - Rapid setup, configuration, and deployment
  - Entity-based persistence for reliable data management

- **Test Coverage**
  - Basic test scaffolding for application context and further testing

---

## 🗂 Key Data Models

### Car
- Rich car entity with many attributes.
- Used for both new and used cars.
- Related enums: `BodyType`, `TransmissionType`, `FuelType`.

### User
- User accounts for admin and regular users.
- Password management, role assignment, profile images.
- Related enum: `UserRole`.

### Booking
- Booking cars with status, payment, and references to car/user.
- Related enums: `BookingStatus`, `PaymentStatus`.

### Enums
- `BodyType`: SEDAN, SUV, HATCHBACK, MUV, COUPE, MPV
- `TransmissionType`: AUTOMATIC, MANUAL
- `FuelType`: PETROL, DIESEL, CNG, ELECTRIC, HYBRID
- `UserRole`: USER, ADMIN
- `BookingStatus`: CONFIRMED, PENDING, CANCELLED, COMPLETED
- `PaymentStatus`: PENDING, PAID, FAILED, REFUNDED, CANCELLED

---

## 🔌 API Endpoints

### Used Cars

- **Add Used Cars**
  ```http
  POST /admin/usedCars
  ```

- **List All Used Cars**
  ```http
  GET /public/usedCars
  ```

- **Get Used Car by ID**
  ```http
  GET /public/usedCars/{id}
  ```

- **Update Used Car**
  ```http
  PATCH /admin/usedCars/{id}
  ```

- **Delete Used Car**
  ```http
  DELETE /admin/usedCars/{id}
  ```

### Users

- **Add Users**
  ```http
  POST /admin/users
  ```

- **List All Users**
  ```http
  GET /admin/users
  ```

- **Get User by ID**
  ```http
  GET /admin/users/{id}
  ```

- **Update User**
  ```http
  PATCH /admin/users/{id}
  ```

- **Delete User**
  ```http
  DELETE /admin/users/{id}
  ```

### Bookings

- **Create Booking**
  ```http
  POST /public/bookings
  ```

- **List All Bookings**
  ```http
  GET /admin/bookings
  ```

- **Get Booking by ID**
  ```http
  GET /admin/bookings/{id}
  ```

- **Update Booking**
  ```http
  PATCH /admin/bookings/{id}
  ```

- **Delete Booking**
  ```http
  DELETE /admin/bookings/{id}
  ```

---

## 🛠 Technologies

- **Java**
- **Spring Boot**
- **Spring Data JPA / Hibernate**
- **H2**
- **REST API**

---

## 🧩 Extending the Platform

- Add new attributes to core entities (Car, User, Booking).
- Create new services for other inventory types (e.g., electric cars).
- Integrate authentication and authorization for admin/public endpoints.
- Enhance error handling and logging for production readiness.
