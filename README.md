
# Expense-Rest-Api
Rest API to Record Expenses

## Technology
- Spring Boot 3.1
- Java 17
- MySql
- Data JPA
- JsonWebToken (JWT)
- Project Lombok

## Application Properties
To run this project, you will need to update the following Application Properties to your application.properties file

`spring.datasource.url=jdbc:mysql://localhost:{yourport}/{tablename}`

`spring.datasource.username=username`

`spring.datasource.password=password`

## API Reference
Warning : all api must be authenticated (except login and register) with authorization:Bearer token

| Module | README                           |
|--------|----------------------------------|
| User   | [[USERREADME.md][PlDb] ](https://github.com/geetoor-maven/expense-api/blob/master/USERREADME.md)           |