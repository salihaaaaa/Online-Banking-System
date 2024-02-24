# Online Banking System

## Overview

This is an online banking system application that provides functionalities to manage user accounts, including account creation, balance checking, transferring funds between accounts, and closing accounts. It also includes authentication and authorization features for users.

## Features

- **Authentication and Authorization**:
  - Register a new user with an email and password.
  - Authenticate a user using email and password.

- **Account Management**:
  - Create a new account with an initial deposit.
  - Check account balance.
  - Transfer funds between accounts.
  - Close an account.

## Technologies Used

- **Java**: Programming language.
- **Spring Boot**: Framework for building the application.
- **Spring Data JPA**: Provides support for data access layer.
- **Spring Security**: Handles authentication and authorization.
- **Lombok**: Reduces boilerplate code.
- **JWT (JSON Web Tokens)**: For user authentication tokens.
- **PostgreSQL**: Database to store user and account information.

## Learning Purposes
This project is created for learning purposes and serves as a sample implementation of an online banking system. It's intended to demonstrate various concepts, including:

- Building RESTful APIs using Spring Boot
- Handling authentication and authorization with Spring Security and JWT
- Using Spring Data JPA for database interactions
- Implementing basic account management functionalities
- Working with PostgreSQL database

## Getting Started

### Prerequisites

- JDK 11 or higher installed.
- Apache Maven installed.
- PostgreSQL database installed and running.
- IDE (e.g., IntelliJ IDEA, Eclipse) to run and modify the code.

### Setup

1. Clone the repository to your local machine:

```bash
git clone https://github.com/salihaaaaa/online-banking-system.git
```

2. Open the project in your preferred IDE.
3. Create a PostgreSQL database named online_banking_system:

```bash
CREATE DATABASE online_banking_system;
```

4. Update the application.properties file located at src/main/resources with your database credentials:

```bash
spring.datasource.url=jdbc:postgresql://localhost:5432/yourdatabase
spring.datasource.username=yourusername
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.properties.hibernate.format_sql=true
server.error.include-message=always
```

5. Run the application and tested in Postman
