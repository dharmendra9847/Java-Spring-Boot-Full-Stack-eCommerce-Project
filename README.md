# 🛒 Java Spring Boot Full Stack eCommerce Project

A production-grade Full Stack eCommerce REST API application built using:

- Spring Framework 7
- Spring Boot 4
- Java 25
- Spring Security
- JWT Authentication & Authorization
- Spring Data JPA
- PostgreSQL
- Docker
- AWS Cloud Deployment
- GitHub Actions CI/CD
- React Frontend

---

# 🚀 Project Vision

This project demonstrates how real-world enterprise-level eCommerce systems are built using modern Java backend technologies and scalable cloud-native architecture.

The goal is to create a secure, scalable, maintainable, and production-ready Full Stack application following industry best practices.

---

# 📌 Features

# 🔐 Authentication & Authorization

- JWT Authentication
- Refresh Token Authentication
- Role-Based Access Control (RBAC)
- Spring Security 7
- BCrypt Password Encryption
- Stateless Authentication
- Secure API Access
- User Registration & Login
- Admin/User Roles

---

# 🛍️ Product Management

- Add Product
- Update Product
- Delete Product
- Get All Products
- Product Details API
- Product Search
- Product Filtering
- Product Pagination
- Product Sorting
- Product Categories
- Product Images

---

# 🛒 Shopping Cart

- Add to Cart
- Remove from Cart
- Update Cart Quantity
- View User Cart
- Cart Total Calculation

---

# 📦 Order Management

- Place Order
- Order History
- Order Tracking
- Order Status Management
- Order Details API

---

# 💳 Payment Integration

- Payment Processing
- Payment Status
- Secure Payment API
- Stripe/Razorpay Ready Structure

---

# 👨‍💼 Admin Dashboard Features

- Manage Products
- Manage Users
- Manage Orders
- Manage Categories
- Analytics Ready APIs

---

# 📖 API Documentation

- Swagger/OpenAPI 3 Documentation
- API Testing Support
- API Versioning

---

# ☁️ Cloud & DevOps

- Dockerized Backend
- Docker Compose Setup
- AWS EC2 Deployment
- AWS RDS PostgreSQL
- AWS S3 Integration Ready
- GitHub Actions CI/CD
- NGINX Reverse Proxy
- Kubernetes Ready Infrastructure

---

# 🏗️ System Architecture

```text
Frontend (React + Vite)
        ↓
REST API Layer (Spring Boot 4)
        ↓
Service Layer
        ↓
Repository Layer (Spring Data JPA)
        ↓
PostgreSQL Database
```

---

# 🧱 Backend Architecture Pattern

```text
Controller Layer
        ↓
Service Layer
        ↓
Repository Layer
        ↓
Database
```

---

# ⚙️ Tech Stack

| Category | Technology |
|----------|-------------|
| Language | Java 25 |
| Framework | Spring Framework 7 |
| Backend | Spring Boot 4 |
| Security | Spring Security |
| Authentication | JWT |
| Database | PostgreSQL |
| ORM | Spring Data JPA |
| Build Tool | Maven |
| Frontend | React + Vite |
| API Docs | Swagger/OpenAPI |
| Containerization | Docker |
| Cloud | AWS |
| CI/CD | GitHub Actions |
| Reverse Proxy | NGINX |

---

# 📂 Enterprise Project Structure

```text
Java-Spring-Boot-Full-Stack-eCommerce-Project/
│
├── .github/
│   └── workflows/
│       ├── backend-ci.yml
│       ├── frontend-ci.yml
│       └── deploy.yml
│
├── backend/
│   │
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── com/
│   │   │   │       └── dharmendra/
│   │   │   │           └── ecommerce/
│   │   │   │
│   │   │   │               ├── config/
│   │   │   │               ├── controller/
│   │   │   │               ├── dto/
│   │   │   │               ├── entity/
│   │   │   │               ├── exception/
│   │   │   │               ├── mapper/
│   │   │   │               ├── repository/
│   │   │   │               ├── security/
│   │   │   │               ├── service/
│   │   │   │               ├── util/
│   │   │   │               └── EcommerceApplication.java
│   │   │   │
│   │   │   └── resources/
│   │   │       ├── db/migration/
│   │   │       ├── static/
│   │   │       ├── templates/
│   │   │       ├── application.yml
│   │   │       ├── application-dev.yml
│   │   │       └── application-prod.yml
│   │   │
│   │   └── test/
│   │
│   ├── Dockerfile
│   ├── docker-compose.yml
│   ├── pom.xml
│   └── mvnw
│
├── frontend/
│   ├── public/
│   ├── src/
│   │   ├── api/
│   │   ├── components/
│   │   ├── context/
│   │   ├── hooks/
│   │   ├── layouts/
│   │   ├── pages/
│   │   ├── routes/
│   │   ├── services/
│   │   ├── store/
│   │   ├── styles/
│   │   ├── types/
│   │   └── utils/
│   │
│   ├── package.json
│   └── vite.config.js
│
├── infrastructure/
│   ├── docker/
│   ├── kubernetes/
│   ├── terraform/
│   └── nginx/
│
├── docs/
│   ├── api-docs/
│   ├── architecture/
│   └── screenshots/
│
├── scripts/
│   ├── deploy.sh
│   └── backup.sh
│
├── .env.example
├── .gitattributes
├── .gitignore
├── LICENSE
├── README.md
└── CONTRIBUTING.md
```

---

# 🔑 Authentication Flow

```text
User Login
    ↓
Validate Credentials
    ↓
Generate JWT Token
    ↓
Return Access Token
    ↓
Client Sends JWT in Header
    ↓
Spring Security Validates Token
    ↓
Authorize Request
```

---

# 🔒 Security Features

- Stateless JWT Authentication
- Secure Password Hashing
- Role-Based Authorization
- Protected REST APIs
- CSRF Disabled for APIs
- Secure Headers
- Exception Handling
- Token Validation Filter
- Authentication Entry Point

---

# 🗄️ Database Design

## Main Entities

- User
- Role
- Product
- Category
- Cart
- CartItem
- Order
- OrderItem
- Payment

---

# 📦 API Endpoints

# 🔐 Authentication APIs

| Method | Endpoint | Description |
|--------|-----------|-------------|
| POST | /api/v1/auth/register | Register User |
| POST | /api/v1/auth/login | Login User |
| POST | /api/v1/auth/refresh-token | Refresh JWT Token |

---

# 🛍️ Product APIs

| Method | Endpoint | Description |
|--------|-----------|-------------|
| GET | /api/v1/products | Get All Products |
| GET | /api/v1/products/{id} | Get Product By ID |
| POST | /api/v1/products | Add Product |
| PUT | /api/v1/products/{id} | Update Product |
| DELETE | /api/v1/products/{id} | Delete Product |

---

# 🛒 Cart APIs

| Method | Endpoint | Description |
|--------|-----------|-------------|
| GET | /api/v1/cart | Get User Cart |
| POST | /api/v1/cart/add | Add To Cart |
| DELETE | /api/v1/cart/remove/{id} | Remove From Cart |

---

# 📦 Order APIs

| Method | Endpoint | Description |
|--------|-----------|-------------|
| POST | /api/v1/orders | Create Order |
| GET | /api/v1/orders | Get User Orders |

---

# 💳 Payment APIs

| Method | Endpoint | Description |
|--------|-----------|-------------|
| POST | /api/v1/payments | Process Payment |

---

# 🧪 Testing Strategy

- Unit Testing
- Integration Testing
- Controller Testing
- Repository Testing
- Security Testing
- API Testing

## Tools Used

- JUnit 6
- Mockito
- Spring Boot Test
- Testcontainers

---

# 🐳 Docker Setup

# Build Docker Image

```bash
docker build -t ecommerce-app .
```

# Run Docker Container

```bash
docker run -p 8080:8080 ecommerce-app
```

# Docker Compose

```bash
docker-compose up -d
```

---

# ☁️ AWS Deployment Architecture

```text
GitHub Actions
        ↓
AWS EC2
        ↓
Docker Container
        ↓
Spring Boot Application
        ↓
AWS RDS PostgreSQL
```

---

# ☁️ AWS Services Used

| Service | Purpose |
|---------|----------|
| EC2 | Application Hosting |
| RDS | PostgreSQL Database |
| S3 | Product Image Storage |
| IAM | Security & Permissions |
| CloudFront | CDN |
| Route53 | DNS Management |

---

# 🔄 CI/CD Pipeline

GitHub Actions Pipeline Includes:

- Build Application
- Run Tests
- Static Code Analysis
- Build Docker Image
- Push Docker Image
- Deploy to AWS EC2

---

# 📖 Swagger API Documentation

Swagger UI:

```text
http://localhost:8080/swagger-ui/index.html
```

OpenAPI Docs:

```text
http://localhost:8080/v3/api-docs
```

---

# 🧰 Required Software

| Software | Version |
|----------|----------|
| Java | 25 |
| Maven | 4+ |
| Node.js | Latest |
| PostgreSQL | Latest |
| Docker | Latest |

---

# ⚡ Backend Setup

## Clone Repository

```bash
git clone https://github.com/dharmendra9847/Java-Spring-Boot-Full-Stack-eCommerce-Project.git
```

---

## Navigate to Backend

```bash
cd backend
```

---

## Configure Database

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/ecommerce_db
    username: postgres
    password: password

  jpa:
    hibernate:
      ddl-auto: update
```

---

## Run PostgreSQL Container

```bash
docker-compose up -d
```

---

## Run Spring Boot Application

```bash
./mvnw spring-boot:run
```

---

# ⚛️ Frontend Setup

## Navigate to Frontend

```bash
cd frontend
```

---

## Install Dependencies

```bash
npm install
```

---

## Run Frontend

```bash
npm run dev
```

---

# 🌐 Application URLs

| Service | URL |
|---------|-----|
| Backend API | http://localhost:8080 |
| Frontend | http://localhost:5173 |
| Swagger UI | http://localhost:8080/swagger-ui/index.html |

---

# 📈 Future Improvements

- Microservices Architecture
- Kafka Event Streaming
- Redis Caching
- Elasticsearch
- GraphQL APIs
- Kubernetes Deployment
- Payment Gateway Integration
- AI Product Recommendations

---

# 🧑‍💻 Git Commit Message Standards

## Initial Setup

```bash
git commit -m "chore: initialize enterprise-grade Spring Boot ecommerce project"
```

## Security Implementation

```bash
git commit -m "feat: implement JWT authentication with Spring Security 7"
```

## Product Module

```bash
git commit -m "feat: add product management module with CRUD APIs"
```

## Cart Module

```bash
git commit -m "feat: implement shopping cart functionality"
```

## Order Module

```bash
git commit -m "feat: implement order processing workflow"
```

## AWS Deployment

```bash
git commit -m "ci: configure Docker and AWS deployment pipeline"
```

## Documentation

```bash
git commit -m "docs: add comprehensive project documentation"
```

---

# 🌳 Recommended Git Branch Strategy

```text
main
develop
feature/authentication
feature/product-module
feature/cart-module
feature/order-module
feature/payment-module
release/v1.0.0
hotfix/security-patch
```

---

# 📋 Coding Standards

- Clean Architecture
- SOLID Principles
- RESTful API Design
- DTO Pattern
- Layered Architecture
- Global Exception Handling
- Centralized Logging
- Validation Handling

---

# 📚 Recommended Additional Technologies

| Purpose | Technology |
|---------|-------------|
| Database Migration | Flyway |
| Object Mapping | MapStruct |
| Logging | SLF4J + Logback |
| Monitoring | Prometheus + Grafana |
| API Gateway | Spring Cloud Gateway |
| Distributed Tracing | Zipkin |

---

# 🤝 Contributing

Contributions are welcome.

Please follow:

1. Fork Repository
2. Create Feature Branch
3. Commit Changes
4. Push Changes
5. Create Pull Request

---

# 📜 License

This project is licensed under the MIT License.

---

# 👨‍💻 Author

Dharmendra Kumar

GitHub:
https://github.com/dharmendra9847

---

# ⭐ Support

If you like this project:

- Star the repository
- Fork the repository
- Share with developers

---

# 📬 Contact

For collaboration or suggestions:

- GitHub Issues
- Pull Requests

---

# 🔥 Enterprise-Level Highlights

✅ Spring Boot 4  
✅ Spring Framework 7  
✅ Java 25  
✅ Spring Security 
✅ JWT Authentication  
✅ PostgreSQL  
✅ Docker  
✅ AWS Deployment  
✅ GitHub Actions CI/CD  
✅ Production-Grade Architecture  
✅ Enterprise Folder Structure  
✅ Real-World Best Practices  
✅ Full Stack Ready  
✅ Scalable Cloud-Native Design