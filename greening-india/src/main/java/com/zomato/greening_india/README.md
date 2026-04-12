# 🌱 Greening India - Backend System

## 📌 Overview

This project is a Spring Boot backend application to manage plantation drives, users, and track tree plantation records.

It also provides a leaderboard to identify top contributors based on total trees planted.

---

## 🚀 Tech Stack

* Java 17
* Spring Boot
* Spring Data JPA
* H2 Database
* Maven

---

## 🧩 Features

### 👤 User Management

* Create and fetch users

### 🌳 Plantation Drives

* Create plantation drives with location, date, and target trees

### 📊 Plantation Records

* Track how many trees a user planted in a drive

### 🏆 Leaderboard

* Aggregates total trees planted per user

---

## 🔗 API Endpoints

### Create User

POST /users

### Create Drive

POST /drives

### Create Record

POST /records

### Get All Records

GET /records

### Get Leaderboard

GET /records/leaderboard

---

## ▶️ How to Run

```bash
./mvnw spring-boot:run
```

Open:
http://localhost:8080

---

## 🧪 Sample Leaderboard Response

```json
[
  {
    "userId": 1,
    "totalTrees": 20
  }
]
```

---

## 💡 Design Highlights

* Clean layered architecture (Controller → Service → Repository)
* Entity relationships using JPA
* Aggregation query using JPQL
* DTO for clean API response

---

## 🎯 Future Improvements

* Authentication & Authorization
* Pagination & filtering
* Persistent DB (MySQL/PostgreSQL)
* Frontend integration

---
