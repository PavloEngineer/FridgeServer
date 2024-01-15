#  Server part of system for smart fridges

It is a server part of a software system for organizing corporate work
refrigerators. This part supports three types of users: employee, admin for database and business admin. The server part provides functions such as CRUD operations for data, the logic of inventory for each fridge and sending messages to users using email, the function to deliver food and payment for additional functions, authorization and authentication, ensuring data protection using hash and tokens.

## Technology

Server based on Java, Spring Boot and REST API. Security was built using Spring Security including hashing and JWT. To work with data from a database, the server system uses Hibernate. The system uses Stripe API in test mode and Delivety API.
Other stack: Code Conventions, SOLID, Unit testing


## Documentation

To summarize the business capabilities and functionality of the system created a document known as  "Vision and Scope", which describes the entire system, including the server system, and contains UML diagrams

[Vision and Scope.docx](https://github.com/PavloEngineer/FridgeServer/files/13929091/Vision.and.Scope.docx)

