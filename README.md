# Online Voting System (Java Spring Boot)

This is a modern Online Voting System built with **Java Spring Boot**, **Thymeleaf**, and **Tailwind CSS**.

## Prerequisites
To run this application, you need to have the following installed on your machine:
1.  **JDK 17 or higher** (Java Development Kit)
2.  **Maven** (Build tool)

## How to Run

1.  **Open a terminal** in this directory.
2.  **Run the application** using Maven:
    ```bash
    mvn spring-boot:run
    ```
3.  Once started, open your browser and go to:
    **http://localhost:8080**

## Logins (Demo Users)

| Role | Username | Password |
|---|---|---|
| **Admin** | `admin` | `admin123` |
| **Voter** | `voter` | `voter123` |

## Features
- **Admin Dashboard**: Add candidates, view live results (Chart.js).
- **Voter Dashboard**: View candidates, cast a secure vote.
- **Security**: Role-based access control (Admin vs Voter).
- **UI**: Responsive and modern design using Tailwind CSS.
- **Database**: H2 In-Memory Database (resets on restart).
