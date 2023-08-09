<p align="center">
    <h1 align="center">EXPENSE-REST-API</h1>
    <p align="center">
        Rest API to Record Expenses
        <br>
        <br>
    </p>    
</p>

## Technology
- Spring Boot 3.1
- Java 17
- MySql
- Data JPA
- JsonWebToken (JWT)
- Lombok

## Application Properties
To run this project, first of all you have to create a table
`db/expansetracker.sql` and
you will need to update the following Application Properties to your application.properties file

`spring.datasource.url=jdbc:mysql://localhost:{yourport}/{tablename}`

`spring.datasource.username=username`

`spring.datasource.password=password`

## API Reference

> [!WARNING] all api must be authenticated (except login and register) with authorization:Bearer token

| Module  | README                                                                                              |
|---------|-----------------------------------------------------------------------------------------------------|
| User    | [[USERREADME.md][PlDb] ](https://github.com/geetoor-maven/expense-api/blob/master/USERREADME.md)    |
| Expense | [[EXPENSEREADME.md][PlDb] ](https://github.com/geetoor-maven/expense-api/blob/master/EXPENSEREADME.md) |

## Authors
- [@aguskurniawan](https://www.instagram.com/geetoor.mvn/)

If you have any questions, suggestions or feedback regarding this project, please feel free to contact mee:
telegram : `@geetoor`

`share if this is helpful`
