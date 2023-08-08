### User Module
#### LOGIN USER
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
    "jwtToken": "token"
}
```

#### REGISTER USER
```http
  POST /expense-api-v1/register
```
###### Request
```
{
    "name" : "test name",
    "email" : "test@gmail.com",
    "password" : "12345"
}
```
###### Response
```
{
    "userId": "c0b837ea-02c4-44ce-828d-36f8d3f3b793",
    "name": "test name",
    "email": "test@gmail.com",
    "age": 0,
    "createAt": "2023-08-08T14:45:30.474+00:00",
    "updateAt": "2023-08-08T14:45:30.474+00:00"
}
```

#### UPDATE USER
```http
  PUT /expense-api-v1/profile
```
###### Request
```
{
    "name" : "test name",
    "email" : "test@gmail.com",
    "password" : "12325",
    "age" : "20"
}
```
###### Response
```
{
    "userId": "d2a357b4-8cd8-41d7-8fda-cfcb94db7b7b",
    "name": "test name",
    "email": "test@gmail.com",
    "age": 20,
    "createAt": "2023-08-03T16:32:02.098+00:00",
    "updateAt": "2023-08-08T14:59:35.468+00:00"
}
```

#### READ USER
```http
  GET /expense-api-v1/profile
```
###### Request
```
Just Authorize Bearer Token
```
###### Response
```
{
    "userId": "d2a357b4-8cd8-41d7-8fda-cfcb94db7b7b",
    "name": "test name",
    "email": "testemail@gmail.com",
    "age": 20,
    "createAt": "2023-08-03T16:32:02.098+00:00",
    "updateAt": "2023-08-08T14:59:35.468+00:00"
}
```

#### DELETE USER
```http
  DELETE /expense-api-v1/deactivate
```
###### Request
```
Just Authorize Bearer Token
```
###### Response
```
Just status code 204 no content
```



