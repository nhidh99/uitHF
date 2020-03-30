# Simple Bakery Store WebApp
A Single Web page application with ReactJS + Spring for practice.

![Alt text](bakery-store-webui/src/images/webpage.png?raw=true)

## Server-side (Backend)
### `com.example.config`
- JwtTokenProvider: Generate, validate, expand, deactivate Json Web Token.
- JwtAuthenticationFilter: Validate jwt from every request needs authorization and expand expiration for the token.
- SecurityConfig: Spring Security using BCrypt Password-Encoder and JwtAuthenticationFilter for specific requests.
- UserConfig: Validate user by username in Database.
- WebConfig: Set View-Controllers for Single Web page Application to avoid not-found pages.

### `com.example.dao | model`
- Model and Data-Access-Object implementations.
- Use JPA Repository with Hibernate Annotations.

### `com.example.service`
- Rest Controllers to implement RESTful-API(s) for client-side.
- Every request needs authorization must include Authorization headers: `Bearer {jwt}`

### `database config`
- Database: MariaDB (if you want to use other databases, edit `resources/application.properties`)
- Tables: import from `config\db-config.sql` to MariaDB (remember to customize queries for other databases).
- User data: undo the comments in the `BakeryStoreApplication.java` in the first run to insert new user(s).

## Client side (Frontend)
### `pages`
- index-page ("/"): products from database.
- login-page ("/login"): simple login form.
- order-page ("/order"): orders of logged user, or else redirect to login page.
- error-page ("/error"): show when error occurs while server fails to handle request.
### `plugins`
- bootstrap
- reactstrap
- node-sass
- react-router-dom

## Run Application
- Requirements: npm, maven, spring, mariadb.
- Method 1: run standalone client-side (`npm install` -> `npm start`) and server-side (run `main` method).
- Method 2: run `mvnw spring-boot:run` -> application will run on port 8080
