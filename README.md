# REST Assured API Automation Framework

## Project Overview

This project is a Hybrid REST API Automation Framework developed using **Java**, **REST Assured**, and **TestNG** for automating RESTful APIs.

The framework follows enterprise-level automation standards with a modular, reusable, scalable, and maintainable architecture. It supports multiple authentication mechanisms, data-driven testing, JSON Schema validation, POJO serialization/deserialization, detailed reporting, logging, and CI/CD integration.

The framework has been designed to be easily extendable for enterprise API automation projects.

---

# Technology Stack

- Java 21
- REST Assured
- TestNG
- Maven
- Jackson Databind
- Gson
- Lombok
- Apache POI (Excel)
- JSON Schema Validator
- JSONPath
- XMLPath
- Log4j2
- Apache Commons IO
- Apache Commons Lang
- Git
- GitHub
- Jenkins

---

# Framework Features

## Framework Architecture

- Hybrid API Automation Framework
- Modular & Scalable Architecture
- Clean Code Architecture
- Reusable Base API Class
- Factory Design Pattern
- Request Specification Factory
- Response Specification Factory
- Centralized Configuration Management
- Enterprise Package Structure

---

## API Execution

- GET
- POST
- PUT
- PATCH
- DELETE

---

## Authentication

- No Authentication
- Basic Authentication
- Bearer Token Authentication
- OAuth2 Authentication
- API Key Authentication
- JWT Authentication Ready
- Dynamic Token Manager

---

## API Validation

- Status Code Validation
- Response Time Validation
- Response Header Validation
- Response Body Validation
- JSON Schema Validation
- JSONPath Validation
- XMLPath Support

---

## Data Driven Testing

- Excel Driven Test Data
- Apache POI
- TestNG Data Providers
- Reusable Excel Utility
- Dynamic Test Data Factory

---

## POJO Support

- Request POJO
- Response POJO
- Serialization
- Deserialization
- Jackson Integration
- Gson Integration
- Lombok Support

---

## Test Execution

- Smoke Testing
- Sanity Testing
- Regression Testing
- TestNG Groups
- Parallel Test Execution
- Retry Failed Test Cases
- Suite Based Execution
- XML Driven Test Execution

---

## Reporting

- Extent HTML Reports
- Allure Reports
- TestNG Reports
- Automatic Report Generation
- Detailed Execution Reports

---

## Logging

- Log4j2 Logging
- Console Logging
- File Logging
- Request Logging
- Response Logging

---

## Configuration Management

- External Configuration using config.properties
- Environment Selection
- Base URL Configuration
- Authentication Configuration
- Proxy Configuration

---

## Utilities

- Excel Utility
- Schema Validation Utility
- Assertion Utility
- Token Manager
- Request Specification Factory
- Response Specification Factory
- API Data Factory
- Random Test Data Generator

---

## Build & Dependency Management

- Maven Build Management
- Dependency Management
- Surefire Plugin
- Clean Project Structure

---

## Version Control

- Git
- GitHub
- Branch Ready Structure

---

## CI/CD Ready

- Jenkins Integration
- Parameterized Build Ready
- Scheduled Execution Ready

---

# Project Structure

```
RestAssuredFramework
│
├── src
│   ├── main
│   │   ├── api
│   │   ├── auth
│   │   ├── base
│   │   ├── config
│   │   ├── context
│   │   ├── endpoints
│   │   ├── factory
│   │   ├── models
│   │   │   ├── request
│   │   │   └── response
│   │   └── utils
│   │
│   └── test
│       ├── dataProviders
│       ├── listeners
│       ├── reports
│       ├── testCases
│       │   ├── positive
│       │   ├── negative
│       │   ├── pet
│       │   ├── user
│       │   └── store
│       ├── testDataFactory
│       ├── utilities
│       └── resources
│           ├── config
│           ├── schemas
│           ├── testData
│           └── payloads
│
├── reports
├── logs
├── allure-results
├── allure-report
├── test-output
├── pom.xml
├── masterAllTestSuite.xml
└── README.md
```

---

# Current Automation Coverage

## Pet Module

- Create Pet
- Get Pet By ID
- Update Pet
- Delete Pet
- Find Pet By Status

## User Module

- Create User
- Get User
- Update User
- Delete User
- Login User
- Logout User

## Store Module

- Framework Ready
- Test Scenarios will be added continuously.

---

# Test Execution

## Execute Complete Suite

```bash
mvn clean test
```

---

## Execute Specific TestNG Suite

```bash
mvn clean test -DsuiteXmlFile=masterAllTestSuite.xml
```

---

## Execute Smoke Tests

```bash
mvn clean test -Dgroups=smoke
```

---

## Execute Regression Tests

```bash
mvn clean test -Dgroups=regression
```

---

## Execute Against Specific Environment

```bash
mvn clean test -Denv=QA
```

Example:

```bash
mvn clean test -Denv=DEV
```

---

# Reporting

After execution, the framework automatically generates:

- Extent HTML Report
- Allure Report
- TestNG Report
- Log File
- Request & Response Logs

---

# Authentication Supported

- No Authentication
- Basic Authentication
- Bearer Token
- OAuth2
- API Key
- JWT Ready

---

# API Validation Supported

- HTTP Status Code
- Headers Validation
- Response Time Validation
- JSON Response Validation
- JSON Schema Validation
- POJO Validation
- JSONPath Assertions

---

# Framework Highlights

- Enterprise Level REST Assured Framework
- Modular Architecture
- Factory Design Pattern
- Data Driven Testing
- JSON Schema Validation
- POJO Serialization / Deserialization
- Multiple Authentication Support
- Parallel Execution Ready
- Environment Ready
- CI/CD Ready
- Interview Ready Project

---
# Framework Design Decisions

This framework has been designed by following enterprise automation standards with a strong focus on scalability, maintainability, reusability, and clean architecture.

---

## BaseAPI

A common reusable API layer that encapsulates all HTTP methods.

### Responsibilities

- Centralizes GET, POST, PUT, PATCH and DELETE methods.
- Eliminates duplicate REST Assured code.
- Supports Path Parameters.
- Supports Query Parameters.
- Supports Request Body.
- Supports all Authentication mechanisms.
- Easy to extend for future API implementations.

---

## Request Specification Factory

Implements the Factory Design Pattern for creating reusable Request Specifications.

### Responsibilities

- Base URI configuration
- Content-Type configuration
- Accept headers
- Proxy configuration
- Request logging
- Authentication injection
- Common request configuration

This avoids repeating common REST Assured configurations in every test.

---

## Response Specification Factory

Centralizes common response validations.

### Responsibilities

- Expected Content-Type
- Response Time
- Common Headers
- Reusable Response Specifications

Improves maintainability and keeps test cases clean.

---

## Authentication Factory

Authentication is completely decoupled from test cases.

Supported Authentication:

- No Authentication
- Basic Authentication
- Bearer Token
- OAuth2
- API Key
- JWT (Framework Ready)

New authentication mechanisms can be added without modifying existing test cases.

---

## Token Manager

Implements centralized token management.

### Responsibilities

- Generate access tokens
- Cache tokens
- Refresh expired tokens
- Avoid unnecessary authentication requests

This improves execution speed and reduces duplicate authentication calls.

---

## ConfigReader

Implements centralized configuration management.

Configuration includes:

- Environment
- Base URL
- Authentication
- Proxy
- Timeouts
- API configuration

Supports multiple environments such as:

- QA
- DEV
- UAT
- PROD

without changing framework code.

---

## Test Data Factory

Separates test data generation from test logic.

Advantages:

- Cleaner test cases
- Dynamic random data generation
- Reusable POJO creation
- Easy maintenance

---

## Context Classes

Context classes are used for sharing runtime data between dependent test cases.

Example:

- PetContext
- UserContext

These eliminate hardcoded IDs and improve test chaining.

---

## Assertion Utilities

Centralized reusable assertion library.

Supports validation of:

- Status Code
- Content Type
- Response Time
- Response Body
- JSON Schema
- Common API assertions

Keeps test methods concise and readable.

---

## Schema Validation Utility

Provides centralized JSON Schema validation.

Advantages:

- Eliminates duplicate validation logic
- Easy schema maintenance
- Better API contract verification

---

## Excel Utility

Reusable Apache POI wrapper for reading Excel data.

Supports:

- Dynamic column lookup
- Row mapping
- Data Providers
- Data Driven Testing

---

## Reporting

The framework generates detailed execution reports using:

- Extent Reports
- Allure Reports
- TestNG Reports

Reports include:

- Test Status
- Execution Time
- Failure Details
- Exception Stack Trace
- Environment Information

---

## Logging

Log4j2 is used for centralized framework logging.

Logging includes:

- Framework initialization
- API Requests
- API Responses
- Validation Details
- Failures
- Exceptions

---

## Framework Goals

The framework has been designed with the following objectives:

- Maximum Reusability
- Easy Maintenance
- Scalability
- Clean Code
- Enterprise Standards
- CI/CD Compatibility
- Interview Ready Architecture

---

## Design Patterns Used

- Factory Pattern
- Page Object Model (for UI projects)
- Singleton Pattern
- Builder Pattern (REST Assured Specifications)
- Strategy Pattern (Authentication)
- Data Provider Pattern
- ThreadLocal Pattern

# Future Enhancements

- Complete Store Module Automation
- GraphQL API Testing
- SOAP API Support
- Database Validation
- Kafka Event Validation
- Email Report Integration
- GitHub Actions CI
- Dockerized API Execution
- Contract Testing
- Performance Testing (JMeter)
- AI Assisted Test Generation

---
# Why This Framework?

This project was developed to simulate a real-world enterprise automation framework rather than a basic learning project.

The framework emphasizes:

- Maintainability
- Reusability
- Scalability
- Clean Architecture
- Industry Best Practices
# Author

**Danish**

Senior Test Engineer

Automation Test Engineer

Java | REST Assured | Selenium | TestNG | Maven | Jenkins | Git | Appium | API Automation

---
