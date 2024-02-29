# GeniusGym

## About The Project

This project was developed as part of a full-stack course at ZHAW (Zurich University of Applied Sciences), which spanned one week. Our team, consisting of two members, was given two days to develop an application. Given the constrained timeline, the application is currently in an unfinished state. However, it is important to note that this project is actively open for further development and improvement.

The aim of GeniusGym is to provide a comprehensive platform for users to manage their fitness routines, including tracking workouts, setting goals, and monitoring progress. Despite its current incomplete status, the groundwork laid provides a solid foundation for future enhancements and features.

## Technology Stack

GeniusGym leverages a sophisticated stack to offer a seamless user experience across mobile and web platforms:

- **Frontend:** Utilizes Ionic for its versatile application development capabilities.
- **Backend:** Employs Java and the Spring Framework, enriched with Spring Boot for microservices architecture and Spring Security for robust authentication mechanisms.
- **Authentication:** Integrates JWT to ensure secure, token-based authentication.
- **Database & Tools:** Incorporates standard database solutions and essential tools like Docker for seamless containerization and Maven for efficient dependency management, all chosen for their proven reliability and scalability.

## Getting Started

Embark on your GeniusGym journey with these straightforward setup steps.

### Prerequisites

Ensure you have the following installed:

- Docker
- Node.js
- npm or yarn

### Installation Guide

1. **Clone the Repository**
   ```sh
   git clone https://github.com/your_username/GeniusGym.git

2. **Install Dependencies**

        npm install

### **Docker Setup**
For Docker enthusiasts, build and launch your container with:

    docker build -t geniusgym .
    docker run -d -p 8080:80 geniusgym

## Running the Application

### **Backend with Spring Boot and Maven:**

For the backend, ensure you are in the root directory where the pom.xml file is located. Then, use Maven to start the Spring Boot application with the following command:

    ./mvnw spring-boot:run

Or, if you're using Windows:

    cmd

    mvnw spring-boot:run

This command compiles the application and starts the Spring Boot server, making the backend services available for the frontend to consume.

### **Frontend with Ionic:**

To launch the frontend, navigate to the project's root directory and execute the following command. This will start the Ionic development server, making the app accessible via a web browser.

```sh
ionic serve

