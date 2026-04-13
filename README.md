# 🌱 Greening India Backend

A Spring Boot backend service for managing plantation drives, users, plantation records, and leaderboard tracking for environmental initiatives.

## 🚀 Tech Stack
- Java 17
- Spring Boot 3
- Spring Data JPA (Hibernate)
- PostgreSQL 15
- Docker & Docker Compose
- Maven

## 📌 Features
- 👤 User management
- 🌳 Plantation drive creation and tracking
- 📊 Plantation record management
- 🏆 Leaderboard based on trees planted
- 🐳 Fully containerized with Docker
- ⚡ Auto schema generation using Hibernate

## 🏗️ System Design Overview

### Entities:
- **User** → stores user details
- **PlantationDrive** → event/drive details (location, date, target trees)
- **PlantationRecord** → mapping of users to drives with trees planted

### Relationships:
- User → One-to-Many → PlantationRecord
- PlantationDrive → One-to-Many → PlantationRecord

## 📁 Project Structure

```
greening-india/
├── backend/ → Spring Boot application
├── postman/ → Postman collection
├── docker-compose.yml → Multi-container setup
└── .env.example → Environment variables template
```

## ⚙️ Setup Instructions

1. **Clone the repository**
   ```bash
   git clone <your-repo-url>
   cd greening-india
   ```

2. **Run with Docker (Recommended)**
   ```bash
   docker compose up --build
   ```

   This will start:
   - Backend: http://localhost:8080
   - PostgreSQL: localhost:5432

3. **Stop containers**
   ```bash
   docker compose down
   ```

## 🛑 Run Locally (Without Docker)

1. **Configure DB in application.properties**
   ```
   spring.datasource.url=jdbc:postgresql://localhost:5432/greening
   spring.datasource.username=postgres
   spring.datasource.password=postgres
   ```

2. **Run application**
   ```bash
   mvn spring-boot:run
   ```

## 🧪 API Testing

Import this file into Postman:

`postman/Greening-India.postman_collection.json`

**Base URL:** http://localhost:8080

## 📮 API Endpoints

### 👤 User APIs
| Method | Endpoint    | Description    |
|--------|-------------|----------------|
| POST   | /users      | Create user    |
| GET    | /users      | Get all users  |

### 🌳 Plantation Drive APIs
| Method | Endpoint             | Description     |
|--------|----------------------|-----------------|
| POST   | /plantation-drives   | Create drive    |
| GET    | /plantation-drives   | Get all drives  |

### 🌱 Plantation Record APIs
| Method | Endpoint                      | Description          |
|--------|-------------------------------|----------------------|
| POST   | /plantation-records           | Add record           |
| GET    | /plantation-records           | Get all records      |
| GET    | /plantation-records/leaderboard | Get leaderboard      |

## 📊 Leaderboard Logic

Leaderboard ranks users based on total trees planted:

```sql
SELECT user_id, SUM(trees_planted)
FROM plantation_record
GROUP BY user_id
ORDER BY SUM(trees_planted) DESC;
```

## 📦 Sample JSON

### Create User
```json
{
  "name": "Archita",
  "email": "archita@test.com",
  "city": "Indore"
}
```

### Create Drive
```json
{
  "location": "Indore Park",
  "date": "2026-04-13",
  "targetTrees": 100
}
```

### Create Plantation Record
```json
{
  "treesPlanted": 10,
  "user": { "id": 1 },
  "drive": { "id": 1 }
}
```

## 🧾 Environment Variables

If running locally (without Docker):

```
SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/greening
SPRING_DATASOURCE_USERNAME=postgres
SPRING_DATASOURCE_PASSWORD=postgres
```

## 🐳 Docker Notes
- Backend build context: `./backend`
- PostgreSQL service included
- Persistent volume enabled

## 🧹 Notes
- Flyway is intentionally disabled (`spring.flyway.enabled=false`)
- Hibernate auto-generates schema (`ddl-auto=update`)
- No manual DB migration required
- All services are Dockerized

## ✅ Status
- ✔ All APIs working
- ✔ Docker build successful
- ✔ Database connected
- ✔ Leaderboard implemented
- ✔ Ready for submission

## 👩‍💻 Author

Archita Pathak
