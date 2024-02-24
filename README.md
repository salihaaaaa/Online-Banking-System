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

5. Run the application

## Postman Testing
To test the APIs, you can use Postman. Here are the steps to test the account management and authentication APIs:

### User Registration

- Set the request type to POST and enter the URL for the register endpoint:

    ```bash
    http://localhost:8080/api/auth/register
    ```

- In the request body, enter the necessary parameters as JSON. For example:

    ```bash
    {
      "firstName": "John",
      "lastName": "Doe",
      "email": "john.doe@example.com",
      "password": "password"
    }
    ```

- Click Send to register the user.

### User Authentication
- Set the request type to POST and enter the URL for the authenticate endpoint:

    ```bash
    http://localhost:8080/api/auth/authenticate
    ```

- In the request body, enter the user's email and password as JSON. For example:

    ```bash
    {
      "email": "john.doe@example.com",
      "password": "password"
    }
    ```

- Click Send to authenticate the user and receive a JWT token.

### Account Management (After Authentication)
Once you have a JWT token from the authentication step, you can use it to access the account management endpoints. Include the JWT token in the Authorization header of your requests as a Bearer token.

1. **Create Account**
   - Set the request type to POST and enter the URL for the createAccount endpoint:

    ```bash
    http://localhost:8080/api/account/create
    ```

   - In the request body, enter the necessary parameters as JSON. For example:
    ```bash
    {
      "userId": 1,
      "accountType": "SAVINGS",
      "initialDeposit": 5000
    }
    ```

   - Click Send to create an account.


2. **Get All Accounts**
   - Set the request type to GET and enter the URL for the getAllAccounts endpoint:

    ```bash
    http://localhost:8080/api/account
    ```

   - Click Send to retrieve all accounts.


3. **Get Accounts by User ID**
   - Set the request type to GET and enter the URL for the getAccountsByUserId endpoint:

    ```bash
    http://localhost:8080/api/account/user-id=1
    ```

   - Click Send to retrieve accounts for the user with ID 1.


4. **Get Account by Account Number**
   - Set the request type to GET and enter the URL for the getAccountsByAccountNumber endpoint:

    ```bash
    http://localhost:8080/api/account/account-number=1234567890
    ```

   - Click Send to retrieve the account with account number 1234567890.


5. **Transfer Funds**
   - Set the request type to POST and enter the URL for the transfer endpoint:

    ```bash
    http://localhost:8080/api/account/transfer
    ```

   - In the request body, enter the necessary parameters as JSON. For example:
   For destination account number, you can create another account and use that account number

    ```bash
    {
      "sourceAccountNumber": 1234567890,
      "destinationAccountNumber": 9876543210,
      "amount": 1000
    }
    ```

   - Click Send to transfer funds from account 1234567890 to account 9876543210.


6. **Close Account**
   - Set the request type to DELETE and enter the URL for the closeAccount endpoint:

    ```bash
    http://localhost:8080/api/account/close/1
    ```

   - Click Send to close the account with ID 1.

