🌱 Greening India Backend

A Spring Boot backend service for managing plantation drives, users, plantation records, and leaderboard tracking for environmental initiatives.

🚀 Tech Stack
Java 17
Spring Boot 3
Spring Data JPA (Hibernate)
PostgreSQL
Docker & Docker Compose
Maven
📌 Features
👤 User management
🌳 Plantation drive creation and tracking
📊 Plantation record management
🏆 Leaderboard based on trees planted
🐳 Fully containerized with Docker
⚡ Auto schema generation using Hibernate
🏗️ System Design Overview
Entities:
User → stores user details
PlantationDrive → event/drive details (location, date, target trees)
PlantationRecord → mapping of users to drives with trees planted
Relationships:
User → One-to-Many → PlantationRecord
PlantationDrive → One-to-Many → PlantationRecord
🐳 Run with Docker (Recommended)
1. Build and start containers
docker compose up --build
2. Services
Backend: http://localhost:8080
PostgreSQL: localhost:5432
🛑 Stop containers
docker compose down
⚙️ Run Locally (Without Docker)
1. Configure DB in application.properties
spring.datasource.url=jdbc:postgresql://localhost:5432/greening
spring.datasource.username=postgres
spring.datasource.password=postgres
2. Run application
mvn spring-boot:run
📮 API Endpoints
👤 User APIs
Method	Endpoint	Description
POST	/users	Create user
GET	/users	Get all users
🌳 Plantation Drive APIs
Method	Endpoint	Description
POST	/plantation-drives	Create drive
GET	/plantation-drives	Get all drives
🌱 Plantation Record APIs
Method	Endpoint	Description
POST	/plantation-records	Add record
GET	/plantation-records	Get all records
GET	/plantation-records/leaderboard	Get leaderboard
📊 Leaderboard Logic

Leaderboard ranks users based on total trees planted:

SELECT user_id, SUM(trees_planted)
FROM plantation_record
GROUP BY user_id
ORDER BY SUM(trees_planted) DESC;
📦 Sample JSON
Create User
{
  "name": "Archita",
  "email": "archita@test.com",
  "city": "Indore"
}
Create Drive
{
  "location": "Indore Park",
  "date": "2026-04-13",
  "targetTrees": 100
}
Create Plantation Record
{
  "treesPlanted": 10,
  "user": { "id": 1 },
  "drive": { "id": 1 }
}
🧪 Postman Collection

Import the file:

Greening-India.postman_collection.json
🧹 Notes
Flyway is intentionally disabled (spring.flyway.enabled=false)
Hibernate auto-generates schema (ddl-auto=update)
No manual DB migration required
All services are Dockerized
✅ Status

✔ All APIs working
✔ Docker build successful
✔ Database connected
✔ Leaderboard implemented
✔ Ready for submission

👩‍💻 Author

Archita Pathak
