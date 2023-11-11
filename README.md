# Java EE Bus Ticketing System

## Table of Contents

- [Description](#description)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## Description

The Java EE Bus Ticketing System is a web-based application designed to facilitate bus ticket booking and management. It
allows users to search for available bus routes, view schedules, and purchase tickets online. This system provides a
seamless experience for both customers and administrators.

## Features

- User Registration and Authentication: Customers can create accounts and log in securely.
- Bus Route Management: Admins can add, edit, and delete bus routes.
- Ticket Booking: Customers can search for routes, select available schedules, and book tickets.
- Ticket Management: Admins can manage ticket reservations and view booking details.
- Payment Integration: Integration with payment gateways for secure transactions - (to be implemented).
- User-friendly Interface: An intuitive and responsive web interface for easy navigation.

## Technologies Used

- **Java EE**: The project is built using Java Enterprise Edition for robust and scalable server-side development.
- **Servlets and JSP**: Used for web components and dynamic web page generation.
- **MySQL**: The database system for storing user data, bus route information, and ticket bookings.
- **Hibernate**: Object-relational mapping for database interaction.
- **HTML/CSS**: Frontend design and layout.
- **Maven**: Dependency management.

## Getting Started

1. Clone the repository:

   ```bash
   git clone https://github.com/CSC506-Redhat/Bus.git
   ```

2. Configure your database connection in `persistence.xml`.

3. Build the project using Maven:

   ```bash
   mvn clean install
   ```

4. Deploy the application on a Java EE application server (e.g., Apache Tomcat, WildFly, or GlassFish).

5. Access the application through your web browser:

   ```
   http://localhost:8080/BusTicketingSystem-1.0-SNAPSHOT
   ```

## Usage

- Register as a user or login if you are an existing user.
- Search for available bus routes and schedules.
- Select a schedule and book your tickets.
- Make secure payments online.
- Admins can log in to manage bus routes and ticket bookings.

## Contributing

Contributions are welcome! Please follow these steps to contribute:

1. Fork the repository.
2. Create a new branch for your feature or bug fix.
3. Make your changes and test thoroughly.
4. Commit your changes.
5. Push your branch to your forked repository.
6. Create a pull request to the main repository.


## Please ensure your code follows coding standards and is well-documented.

## After successful fork and clone, please make sure to create a branch and commit your work there. All your subsequent work will remain in that branch.

## Ensure to provide necessary comments/documentation as well as state what you have implemented in your commit message!

## License

This project is licensed under the [Apache License 2.0](LICENSE).
