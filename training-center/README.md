# Training Center API


## Table of Contents

- [Introduction](#introduction)
- [Requirements](#requirements)
- [Installation and Setup](#installation-and-setup)
- [Project Structure](#project-structure)
- [API Endpoints](#api-endpoints)
- [Exception Handling](#exception-handling)

---

## Introduction

The Training Center API allows users to manage training centers efficiently. It supports storing, retrieving, and filtering training centers using RESTful APIs.

---

## Requirements

Ensure you have the following installed before proceeding:

- Java 17 or higher  
- Maven  
- MySQL or another database  
- Git for version control  
- Any IDE such as IntelliJ IDEA, Eclipse, or VS Code  

---

## Installation and Setup

1. Clone the repository and navigate to the project directory.  
2. Install dependencies using Maven.  
3. Create a MySQL database named `training_center`.  
4. Update database credentials in the `application.properties` file.  
5. Run the application using Maven.  
6. The API will be available at `http://localhost:8080`.  

---

## Project Structure

The project follows a **clean architecture** with separation of concerns:

- **Controller**: Handles API requests and responses.  
- **Service**: Contains business logic.  
- **Repository**: Handles database operations using JPA.  
- **Entity**: Defines entity classes and validation constraints.  
- **Exception**: Custom exception handling classes.  

---

## API Endpoints

1. **Create Training Center**: `POST /api/centers`  
2. **Get All Training Centers**: `GET /api/centers`  
3. **Get Training Centers with Filtering**: `GET /api/centers?location=<location>`  

The API supports filtering by location and other parameters.

---

## Exception Handling

The project includes **global exception handling** using `@RestControllerAdvice` to handle errors such as:  

- Resource Not Found  
- Invalid Input  
- Database Errors  

This ensures meaningful error messages are returned in API responses.

---

For any issues or improvements, feel free to open an issue on the GitHub repository.
