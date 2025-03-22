# SpringSecurityBasics

This project demonstrates basic security concepts in Spring Boot applications, including user creation and authentication, access management, and logout implementation.

## Technologies Used

- **Java 17**
- **Spring Boot 3.4.3**
  - `spring-boot-starter-web` (for REST API development)
  - `spring-boot-starter-security` (for authentication and authorization)
  - `spring-boot-starter-test` (for testing)
- **JUnit 5** (for automated testing)
- **Maven** (dependency management)

## Project Structure

```
com.tutorialseu
│── Main.java (Main class to initialize the application)
│
├── controller
│   ├── AdminController.java (Protected endpoints for administrators)
│   ├── DemoController.java (Public and protected endpoints)
│   ├── UserController.java (Protected endpoints for users)
│
├── security
│   ├── SecurityConfig.java (Authentication and authorization configuration)
```

## Endpoints

### Public Endpoints

- `GET /public` - Accessible by anyone, no authentication required.

### Protected Endpoints

- `GET /secured` - Accessible only by authenticated users.
- `GET /user/home` - Accessible only by users with the `USER` role.
- `GET /admin/dashboard` - Accessible only by users with the `ADMIN` role.

## Authentication and Security

Authentication is implemented using **Spring Security**, with users stored in memory. Default credentials:

- **Username:** `Carlos` | **Password:** `Carlos123` | **Role:** `USER`
- **Username:** `Admin` | **Password:** `admin` | **Role:** `ADMIN`

The application supports both **Basic Authentication** and form-based login provided by Spring Security.

## Logout

Users can log out using the `/logout` endpoint. This will invalidate the session and delete cookies.

## How to Run

1. Clone this repository:
   ```sh
   git clone https://github.com/your-username/spring-security-basics.git
   ```
2. Navigate to the project directory:
   ```sh
   cd spring-security-basics
   ```
3. Compile and run the application:
   ```sh
   mvn spring-boot:run
   ```
4. The API will be available at `http://localhost:8080`.

## Testing

To run automated tests:
```sh
mvn test
```

## Skills Demonstrated

- Backend development with **Java** and **Spring Boot**
- Implementation of **authentication and authorization** using **Spring Security**
- Session management and logout handling
- Using **BCryptPasswordEncoder** for password hashing
- Unit testing with **JUnit 5**
- Security best practices in web applications

## License

This project is licensed under the MIT License. Feel free to contribute!
