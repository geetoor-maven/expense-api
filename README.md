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
### User Module
#### Login

```http
  POST /expense-api-v1/login
```
###### Request
```
{
    "email" : "test@gmail.com",
    "password" : "123"
}
```
###### Response
```
{
    "email" : "test@gmail.com"    
}
```



