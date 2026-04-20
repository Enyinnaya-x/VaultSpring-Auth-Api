# VaultSpring Auth API

A clean Spring Boot + PostgreSQL starter for building REST APIs with **user registration**, **login**, and **JWT-based auth** as your foundation.

This is meant to be a practical starting template: add mailers, roles/permissions, refresh tokens, password reset, profile endpoints, and whatever your app needs—after the core **signup + login** flows are in place.

## What’s inside

- **Spring Boot (Maven)** REST API
- **PostgreSQL + Spring Data JPA**
- **Spring Security**
- **JWT token generation** (login returns a token)
- Validation-ready request DTOs

## Requirements

- **Java 21**
- **PostgreSQL** (local install or Docker)

## Quick start

1. Create a Postgres database (example: `mydatabase`).
2. Configure your datasource.

Your repo currently has DB credentials in `src/main/resources/application.properties`. For real projects, prefer a local override file and keep secrets out of git:

- Create `src/main/resources/application-local.properties` (this repo’s `.gitignore` ignores it)
- Put your real credentials there

Example `application-local.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/mydatabase
spring.datasource.username=postgres
spring.datasource.password=1234
spring.jpa.hibernate.ddl-auto=update
```

3. Run the app:

On Windows:

```powershell
.\mvnw.cmd spring-boot:run
```

On macOS/Linux:

```bash
./mvnw spring-boot:run
```

## API endpoints

Base path is not centralized, so endpoints are currently declared directly in `UserController`.

### Register

`POST /api/auth/register`

Example:

```bash
curl -X POST http://localhost:8080/api/auth/register \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Victor",
    "email": "victor@example.com",
    "password": "password123",
    "confirmPassword": "password123",
    "phone": "1234567890"
  }'
```

### Login

`POST /api/auth/login`

Example:

```bash
curl -X POST http://localhost:8080/api/auth/login \
  -H "Content-Type: application/json" \
  -d '{
    "email": "victor@example.com",
    "password": "password123"
  }'
```

### List users

`GET /api/auth/users`

Example:

```bash
curl http://localhost:8080/api/auth/users
```

## JWT note (important)

`JwtUtil` currently creates a **new random signing key on every application start**. That means tokens issued before a restart will stop validating after a restart.

For production, you’ll typically:

- Store the JWT secret in config/environment (constant across restarts)
- Add token validation + an auth filter
- Consider refresh tokens and token revocation strategies

## Roadmap ideas (easy wins)

- Add **refresh tokens**
- Add **roles/permissions** and secure `/api/auth/users`
- Add **email verification** / password reset mail flow
- Add Swagger/OpenAPI docs

