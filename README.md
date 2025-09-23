# Online Book Store System Using Spring Boot

## Project Overview  
The Online Book Store backend is a Spring Boot application designed to manage users, books, categories, authors, carts, and orders. It provides RESTful APIs to perform core e-commerce operations such as user registration, book management, cart operations, and order processing.  

---

## Features  
- **User Management**: Create, fetch, update, and delete users.  
- **Book Management**: Manage books, authors, categories, and images.  
- **Cart and Order System**: Add or remove books from cart, place orders, and track order history.  
- **Role-Based Access**: Secure endpoints based on user roles (user, admin).  
- **Database Integration**: MySQL with JPA/Hibernate for persistence.  

---

## Tech Stack  
- **Backend Framework**: Spring Boot (Java 17)  
- **Database**: MySQL  
- **ORM**: JPA/Hibernate  
- **Build Tool**: Maven  
- **Libraries**: Lombok, Spring Data JPA, Spring Web  

---

## Project Structure  
OnlineBookStore/
├── src/main/java/com/spring/OnlineBookStore
│ ├── controller/ # REST Controllers
│ ├── service/ # Service Interfaces & Implementations
│ ├── repository/ # Spring Data JPA Repositories
│ ├── model/ # Entities (User, Book, Author, Cart, Order, etc.)
│ └── OnlineBookStoreApplication.java
├── src/main/resources/
│ ├── application.properties # DB Configurations
└── pom.xml

yaml
Copy code

---

## Installation and Setup  

1. **Clone the repository**  
   ```bash
   git clone https://github.com/your-username/OnlineBookStore.git
   cd OnlineBookStore
Configure database (MySQL)
Edit application.properties:

properties
Copy code
spring.datasource.url=jdbc:mysql://localhost:3306/bookstore
spring.datasource.username=your-username
spring.datasource.password=your-password
spring.jpa.hibernate.ddl-auto=update
Build and run the application

bash
Copy code
mvn spring-boot:run
