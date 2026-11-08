# Student Management System
![Java](https://img.shields.io/badge/Java-25-ED8B00?logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-4.1.2-6DB33F?logo=springboot&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-Database-4479A1?logo=mysql&logoColor=white)

A web-based student registry built with **Spring Boot**, **Thymeleaf** and **MySQL**. It lets you add, view, edit and delete student records through a simple browser UI, and also exposes a few JSON endpoints for working with the data directly.

## Features

- View all students in a table (ID, name, email, address)
- Register a new student through a form
- Edit an existing student's details
- Delete a student record
- Server-side validation (name and address length, valid email format) with error messages shown on the form
- Data stored in MySQL through Spring Data JPA (tables are created automatically)

## ⚙️ Tools & Technologies

![Java](https://img.shields.io/badge/Java_25-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-005F0F?style=for-the-badge&logo=thymeleaf&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![Bootstrap](https://img.shields.io/badge/Bootstrap-7952B3?style=for-the-badge&logo=bootstrap&logoColor=white)
![HTML5](https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=html5&logoColor=white)
![CSS3](https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=css3&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)

| Layer      | Technology                                  |
|------------|---------------------------------------------|
| Language   | Java 25                                     |
| Framework  | Spring Boot 4.1.2 (Spring MVC)              |
| Persistence| Spring Data JPA / Hibernate                 |
| Database   | MySQL                                       |
| Templating | Thymeleaf                                   |
| Validation | Jakarta Bean Validation                     |
| Frontend   | HTML, CSS, Bootstrap                        |
| Build tool | Maven (Maven Wrapper included)              |

## 📁 Project Structure

```
StudentManagement/
├── src/
│   ├── main/
│   │   ├── java/org/example/studentmanagement/
│   │   │   ├── StudentManagementApplication.java   # Entry point
│   │   │   ├── Student.java                        # JPA entity + validation rules
│   │   │   ├── StudentRepo.java                    # JpaRepository interface
│   │   │   ├── StudentService.java                 # Business logic
│   │   │   └── StudentController.java              # UI + JSON endpoints
│   │   └── resources/
│   │       ├── templates/                          # Index, addstudent, editstudent
│   │       ├── static/css/                         # heading.css, forms.css
│   │       └── application.properties              # DB and Thymeleaf config
│   └── test/
├── pom.xml
└── README.md
```

## Getting Started

### Prerequisites

- JDK 25 (or change `java.version` in `pom.xml` to the JDK you have installed, for example 21)
- MySQL Server running on `localhost:3306`
- Maven (or use the included `mvnw` / `mvnw.cmd` wrapper)

### 1. Clone the repository

```bash
git clone https://github.com/chathuranga-K/StudentManagement.git
cd StudentManagement
```

### 2. Create the database

```sql
CREATE DATABASE school;
```

### 3. Configure the database connection

Edit `src/main/resources/application.properties` to match your MySQL setup:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/school
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

The `student` table is created automatically on first run.

### 4. Run the application

```bash
# Windows
mvnw.cmd spring-boot:run

# macOS / Linux
./mvnw spring-boot:run
```

### 5. Open it in your browser

```
http://localhost:8080/student/index
```

## 🌐 Application Routes

### Web UI

| Route                          | Description                    |
|--------------------------------|--------------------------------|
| `/student/index`               | Student list (home page)       |
| `/student/addstudent`          | New student form               |
| `/student/add-action`          | Saves a student (form submit)  |
| `/student/edit-action/{id}`    | Edit form for a student        |
| `/student/delete-action/{id}`  | Deletes a student              |

### JSON endpoints

| Method | Route                  | Description              |
|--------|------------------------|--------------------------|
| GET    | `/student/list`        | Returns all students     |
| GET    | `/student/get/{id}`    | Returns one student      |
| POST   | `/student/add`         | Adds a student (JSON body) |
| GET    | `/student/delete/{id}` | Deletes a student        |

Example request body for `POST /student/add`:

```json
{
  "name": "John Doe",
  "email": "john.doe@example.com",
  "address": "123 Main St, Colombo"
}
```

## Validation Rules

| Field   | Rule                         |
|---------|------------------------------|
| Name    | 3 to 50 characters           |
| Email   | Must be a valid email address|
| Address | 3 to 50 characters           |

## Future Improvements

- Search and pagination for the student list
- Confirmation prompt before deleting
- User authentication (admin login)
- Additional fields (course, date of birth, phone number)
- Unit and integration tests

## Author
I built this project to practise full-stack Java development with Spring Boot, covering layered architecture, database integration with JPA, server-side validation and building a UI with Thymeleaf.

**[Chathuranga Kalhara]**
GitHub: [@chathuranga-K](https://github.com/chathuranga-K)
