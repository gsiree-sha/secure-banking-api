# Secure Banking API

A secure backend REST API built using Spring Boot that simulates a banking-style user management system with JWT-based authentication and role-based access control.

---

## 🚀 Features

- User registration
- JWT-based authentication
- Role-Based Access Control (USER / ADMIN)
- Secure password hashing using BCrypt
- Stateless authentication
- Swagger UI for API documentation
- H2 Database integration
- RESTful API design
- Layered architecture (Controller → Service → Repository)

---

## 🛠 Tech Stack

- Java 17
- Spring Boot
- Spring Security
- JWT (jjwt)
- Spring Data JPA
- H2 Database
- Maven
- Swagger / OpenAPI

---

## 🔐 Authentication (JWT)

This API uses JSON Web Tokens (JWT) for stateless authentication.

### 1️⃣ Register a User

```bash
curl -i -X POST http://localhost:8080/api/users \
  -H "Content-Type: application/json" \
  -d '{"username":"demoUser","password":"test123","role":"USER"}'
```

---

### 2️⃣ Login and Get Token

```bash
curl -s -X POST http://localhost:8080/auth/login \
  -H "Content-Type: application/json" \
  -d '{"username":"demoUser","password":"test123"}'
```

Response:

```json
{
  "token": "eyJhbGciOiJIUzI1NiJ9...",
  "tokenType": "Bearer"
}
```

---

### 3️⃣ Use Token to Access Protected APIs

```bash
curl -i http://localhost:8080/api/users/me \
  -H "Authorization: Bearer <PASTE_TOKEN_HERE>"
```

---

## 🔑 Role-Based Access Control (RBAC)

| Endpoint | Access Level |
|-----------|-------------|
| POST /api/users | Public |
| POST /auth/login | Public |
| GET /api/users/me | Authenticated Users |
| GET /api/users | ADMIN Only |

- USER can access their own profile.
- ADMIN can list all users.
- All protected endpoints require a valid JWT token.

---

## 🧪 How to Run

1. Clone the repository

```
git clone <your-repo-url>
cd secure-banking-api
```

2. Build and run

```
mvn clean spring-boot:run
```

3. Open in browser

- Swagger UI:  
  http://localhost:8080/swagger-ui/index.html

- H2 Console:  
  http://localhost:8080/h2-console

---

## 📊 Database

- H2 (file-based or in-memory)
- Table: USERS
- Passwords stored securely using BCrypt hashing

---

## 🏗 Architecture

- Controller Layer → Handles HTTP requests
- Service Layer → Business logic
- Repository Layer → Data access via JPA
- Security Layer → JWT filter + authentication handling

---

## 📈 What This Project Demonstrates

- Production-style stateless authentication
- Custom JWT authentication filter
- Role-based authorization
- Secure REST API design
- Clean layered architecture
- Real-world backend practices

---

## 🚀 Future Improvements

- Refresh token support
- Docker containerization
- PostgreSQL migration
- CI/CD integration
- Transaction APIs (banking operations)

---

## 👩‍💻 Author

Sireesha Gurram  
Master’s in Computer Science  
Backend Developer | Spring Boot | Security | REST APIs
