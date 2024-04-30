
[logo]: src/main/frontend/public/logo.png

# The Giving Tree

[name]: https://img.shields.io/badge/The%20Giving%20Tree-Web%20Application-blue
[img]: https://img.shields.io/badge/Status-In%20Progress-yellow

A web application that connects donors with non-profit organizations.

## Table of Contents

- [Project Description](#project-description)
- [Project Structure](#project-structure)
- [Project Setup Instructions](#project-setup-instructions)
  - [1. Clone the Repository](#1-clone-the-repository)
  - [2. Install SQL Server Drivers](#2-install-sql-server-drivers)
  - [3. Install Maven Dependencies](#3-install-maven-dependencies)
  - [4. Run the Spring Boot Application](#4-run-the-spring-boot-application)
  - [5. Build the Frontend](#5-build-the-frontend)
  - [6. Access the Website](#6-access-the-website)
- [Usage](#usage)
- [License](#license)

## Project Description

The Giving Tree is a web application that connects donors with non-profit organizations. The application allows donors to browse and donate to various non-profit organizations. Non-profit organizations can create an account, view donations, and update their organization information.

The application is built using the following technologies:

- Spring Boot: Backend framework for building the REST API.
- React: Frontend library for building the user interface.
- MySQL: Database for storing user and organization information.
- HikariCP: Connection pool for connecting to the MySQL database.
- Maven: Build tool for managing dependencies and building the project.

The application has the following features:

- User Registration: Users can create an account and log in to the application.
- Organization Registration: Non-profit organizations can create an account and log in to the application.
- Organization Profile: Organizations can view and update their profile information.
- Donation: Users can browse and donate to various non-profit organizations.

The application is designed to be user-friendly and easy to use. It provides a simple and intuitive interface for users to browse and donate to non-profit organizations.

## Project Structure

The project is structured as follows:

- `src/main/java`: Contains the Java source code for the Spring Boot application.
- `src/main/resources`: Contains the configuration files for the Spring Boot application.
- `src/main/frontend`: Contains the React frontend code for the application.
- `pom.xml`: Contains the Maven dependencies for the project.

The Java source code is organized into the following packages:

- `com.utdallas.capstone`: Contains the main application class and configuration files.
- `com.utdallas.capstone.config`: Contains configuration classes for the application.
- `com.utdallas.capstone.constants`: Contains constants used throughout the application.
- `com.utdallas.capstone.controller`: Contains the REST controllers for handling HTTP requests.
- `com.utdallas.capstone.dao`: Contains the data access objects for interacting with the database.
- `com.utdallas.capstone.mapper`: Contains mapper classes for mapping entity classes to DTO classes.
- `com.utdallas.capstone.props`: Contains properties files for configuring the application.
- `com.utdallas.capstone.service`: Contains the service classes for handling business logic.
- `com.utdallas.capstone.vo`: Contains value objects for transferring data between layers.

The project uses Maven to manage dependencies and build the project. The `pom.xml` file contains the dependencies for the project, including Spring Boot, HikariCP, and MySQL.

The React frontend code is organized into the following directories:

`src/main/frontend/`

- `src/`: Contains the source code and pages for the React application.
- `src/components`: Contains the React components for the application.
- `src/services`: Contains the service classes for making API requests.
- `src/utils`: Contains utility classes for handling common tasks.

## Project Setup Instructions

Follow these steps to set up the project on your local machine:

### 1. Clone the Repository

First, you need to clone the git repository to your local machine. You can do this by running the following command in your terminal:

```bash
$ git clone https://github.com/Dylan-Kaneshiro/nonprofit-demo.git
```

### 2. Install SQL Server Drivers

Next, download and install the Microsoft SQL Server Drivers. These are necessary for the application to connect to the SQL Server database. After downloading the drivers, add them to your classpath.

You can download the drivers from the following link: [Microsoft SQL Server Drivers](https://docs.microsoft.com/en-us/sql/connect/jdbc/download-microsoft-jdbc-driver-for-sql-server?view=sql-server-ver15)

### 3. Install Maven Dependencies

The project uses Maven to manage dependencies. To install the dependencies, run the following command in the root directory of the project:

```bash
//bash
$ mvn clean install
//windows
$ mvn.cmd clean install
```

This will download all the necessary dependencies and build the project.

### 4. Run the Spring Boot Application

To run the Spring Boot application, run the following command in the root directory of the project:

```bash
//bash
$ mvn spring-boot:run
//windows
$ mvn.cmd spring-boot:run
```

This will start the application on the port (8086). Ensure that the port is not being used by another application.

### 5. Build the Frontend

The frontend of the application is built using React. To build the frontend, open a new terminal window and navigate to the `src/main/frontend` directory. Then run the following command:

```bash
$ npm install
$ npm start
```

This will build the frontend and start the development server. You can access the website at `http://localhost:3000`. Ensure that the port is not being used by another application.

### 6. Access the Website

You can now access the website by navigating to `http://localhost:3000` in your browser. You should see the homepage of the application.

## Usage

#### Features any user can use:

- Browse by most-recent or most-popular events
- Search for events by name or organization
  - Filter events by city
- View event details
- Donate to an event
##### Test Organization Account Credentials:
- anyone can login using any google account

#### Features for organizations:

- Login to an organization account
- View organization event history
- Create a new event
- Edit an existing event

##### Test Organization Account Credentials:
- username: -, password: -

