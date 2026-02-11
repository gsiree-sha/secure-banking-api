# secure-banking-api

A secure backend REST API built using Spring Boot that simulates a banking user management system with role-based access control.

---

## 🚀 Features

- User registration
- Role-based authentication (USER / ADMIN)
- Secure password hashing using BCrypt
- Basic Authentication via Spring Security
- Swagger UI for API documentation
- H2 Database integration
- RESTful API design
- Layered architecture (Controller → Service → Repository)

---

## 🛠 Tech Stack

- Java 17
- Spring Boot
- Spring Security
- Spring Data JPA
- H2 Database
- Maven
- Swagger (OpenAPI)
- JUnit (if added)

---

## 🔐 Security

- Role-Based Access Control (RBAC)
- ADMIN can:
  - List all users
- USER can:
  - View their own profile
- Passwords stored securely using BCrypt

---

## 📂 API Endpoints

| Method | Endpoint | Description | Access |
|--------|----------|-------------|--------|
| POST | /api/users | Create new user | Public |
| GET | /api/users | List all users | ADMIN |
| GET | /api/users/me | Get current user profile | Authenticated |

---

## 🧪 How to Run

1. Clone repository
2. Run: mvn clean spring-boot:run
3. Open:
- Swagger UI: http://localhost:8080/swagger-ui/index.html
- H2 Console: http://localhost:8080/h2-console

---

## 📊 Database

- H2 (file-based or in-memory)
- Table: USERS
- Passwords encrypted using BCrypt

---

## 📌 Future Improvements

- JWT Authentication
- Refresh tokens
- Docker containerization
- PostgreSQL migration
- CI/CD pipeline integration
git status
git add README.md
git commit -m "Add README"
git push

 