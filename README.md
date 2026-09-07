# Job Application Tracker

A Java desktop application for tracking internship and full-time job applications throughout the application process.

This project was developed as a portfolio project for my Java Programming course. It demonstrates object-oriented programming concepts including inheritance, polymorphism, method and constructor overloading, generics, collections, and unit testing.

## Features

- Add and track internship and full-time job applications
- Store company, position, application date, status, and notes
- Track internship-specific information including internship type and semester
- Track full-time position salary and remote-work availability
- Display applications alphabetically by company and position
- Search for applications by company or by company and position
- Update the status of an existing application
- Edit application notes
- Remove applications with confirmation
- Validate application dates and salary input
- Display application information through a Java Swing graphical interface

## Technologies

- Java
- Java Swing
- Maven
- JUnit 5
- Git
- GitHub

## Object-Oriented Programming

The project uses a base `JobApplication` class to store information shared by all job applications. `InternshipApplication` and `FullTimeApplication` extend the base class with information specific to each application type.

Polymorphism allows both application types to be stored and managed as `JobApplication` objects while their overridden `getSummary()` methods provide the appropriate information for each type.

The `ApplicationManager` class manages the collection of applications and provides functionality for adding, removing, searching, retrieving, and displaying application information.

## Testing

JUnit tests are included for the application models and application manager. The tests verify constructor behavior, default values, application-specific fields, formatted summaries, collection management, and search functionality.

Tests can be run with Maven using `mvn test`.

## Running the Application

Run the `JobApplicationTrackerGUI` class to launch the graphical interface.

The interface provides three main sections for entering application information, viewing tracked applications, and viewing or modifying the currently selected application.