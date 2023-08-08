### Expense Module
Before making a request in Expense Module, You must crete authorization bearer token in user module (login)

#### CREATE EXPENSE
```http
  POST /expense-api-v1/expenses
```
###### Request
```
{
    "expenseName": "Food Test",
    "description": "Food Testing",
    "expenseAmount": 100.0,
    "category": "Food",
    "date": "2023-10-13"
}
```
###### Response
```
{
    "status": 201,
    "data": {
        "expenseId": "2479e37e-2e42-4841-81b3-b6587ab1d3ac",
        "expenseName": "Food Test",
        "description": "Food Testing",
        "expenseAmount": 100.0,
        "category": "Food",
        "date": "2023-10-13",
        "createAt": "2023-08-08T16:16:00.088+00:00",
        "updateAt": null
    },
    "error": null
}
```

#### UPDATE EXPENSE
```http
  PUT /expense-api-v1/expenses/{expenseID}
```
###### Request
```
{
    "expenseName": "Food Test",
    "description": "Food Testing",
    "expenseAmount": 100.0,
    "category": "Food",
    "date": "2023-10-13"
}
```
###### Response
```
{
    "status": 201,
    "data": {
        "expenseId": "2479e37e-2e42-4841-81b3-b6587ab1d3ac",
        "expenseName": "Food Test",
        "description": "Food Testing",
        "expenseAmount": 100.0,
        "category": "Food",
        "date": "2023-10-13",
        "createAt": "2023-08-08T16:16:00.088+00:00",
        "updateAt": "2023-08-08T16:21:03.098+00:00"
    },
    "error": null
}
```

#### DELETE EXPENSE
```http
  DELETE /expense-api-v1/expenses/{expenseID}
```
###### Request
```
Just Authorize Bearer Token
```
###### Response
```
Just status code 200 ok
```

#### READ EXPENSE
```http
  GET /expense-api-v1/expenses/
```
###### Request
```
Just Authorize Bearer Token 
```
Note : You cant also read by Category, start date and end date(just add params)
```http
  GET /expense-api-v1/expenses/category?category={category}
```
```http
  GET /expense-api-v1/expenses/date?endDate=2023-08-04&startDate=2023-08-03
```
###### Response
```
[
    {
        "expenseId": "76f659f7-f819-4e40-9fcc-8b10fb05c874",
        "expenseName": "Food Test",
        "description": "Food Testing",
        "expenseAmount": 100.00,
        "category": "Food",
        "date": "2023-11-11",
        "createAt": "2023-08-03T14:22:21.606+00:00",
        "updateAt": "2023-08-03T14:59:09.464+00:00"
    }
]
```

#### READ EXPENSE BY ID
```http
  GET /expense-api-v1/expenses/{expenseID}
```
###### Request
```
Just Authorize Bearer Token
```
###### Response
```
{
    "status": 302,
    "data": {
        "expenseId": "76f659f7-f819-4e40-9fcc-8b10fb05c874",
        "expenseName": "Food Test",
        "description": "Food Testing",
        "expenseAmount": 100.00,
        "category": "Food",
        "date": "2023-11-11",
        "createAt": "2023-08-03T14:22:21.606+00:00",
        "updateAt": "2023-08-03T14:59:09.464+00:00"
    },
    "error": null
}
```
